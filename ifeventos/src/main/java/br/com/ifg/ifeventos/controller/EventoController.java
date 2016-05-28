package br.com.ifg.ifeventos.controller;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadSizeLimit;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.serialization.gson.WithoutRoot;
import br.com.caelum.vraptor.view.Results;
import br.com.ifg.ifeventos.dto.BootstrapTableDTO;
import br.com.ifg.ifeventos.dto.BootstrapTableParamsDTO;
import br.com.ifg.ifeventos.dto.EventoDTO;
import br.com.ifg.ifeventos.model.dao.impl.EnderecoDAO;
import br.com.ifg.ifeventos.model.dao.impl.EventoDAO;
import br.com.ifg.ifeventos.model.dao.impl.MapaDAO;
import br.com.ifg.ifeventos.model.dao.impl.OrganizadorDAO;
import br.com.ifg.ifeventos.model.dao.impl.ProgramacaoDAO;
import br.com.ifg.ifeventos.model.entity.Endereco;
import br.com.ifg.ifeventos.model.entity.Evento;
import br.com.ifg.ifeventos.utils.HashUtils;

import com.google.gson.Gson;

@Controller
public class EventoController {

	private final Result result;
	final String PATH = "img\\evento";

	@Inject
	private EventoDAO dao;	
	
	@Inject
	private EnderecoDAO enderecoDao;	

	@Inject 
	private HttpServletRequest request;

	@Inject
	private OrganizadorDAO organizadorDao;

	@Inject
	private ProgramacaoDAO programacaoDao;
	
	@Inject
    private MapaDAO mapaDao;
	
	protected EventoController(){
		this(null);
	}

	@Inject
	public EventoController(Result result){
		this.result = result; 
	}

	@Path("/evento/form")
	public void form(){	
		Gson  gson =  new Gson();
		result.include("listOrganizador", gson.toJson(organizadorDao.getAll()));
		result.include("listProgramacao", gson.toJson(programacaoDao.getAll()));
		result.include("listMapa", gson.toJson(mapaDao.getAll()));
	}

	@Get("/evento/form/{id}")
	public void form(Long id){
		Evento entity = dao.getById(id);; 
		if (entity == null)
			result.redirectTo("/erro/404");
		else{
			Gson gson = new Gson();		
			result.include("dto",gson.toJson(entity));
		}	
	}

	@Path("/evento/list")
	public void list(){	
	}

	@Post("/evento/save2")
	@UploadSizeLimit(sizeLimit=1 * 1024 * 1024, fileSizeLimit=1 * 1024 * 1024)
	public void save(UploadedFile imagem){
		try{
			String ext[] = imagem.getFileName().split("\\.");
			File imageFile = new File(request.getServletContext().getRealPath("")+ File.separator + PATH, HashUtils.hash(imagem.getFileName())+"."+ext[1]);
			imagem.writeTo(imageFile);
			//			dto.setImagem(imageFile.getName());
			//			enderecoDao.save(dto.getEndereco());
			//			dao.save(dto);
			//			dao.commit();
		}
		catch(Exception e){
			dao.rollback();
			e.printStackTrace();
		}
		result.use(Results.json())
		.withoutRoot()
		//		.from(dto)
		.from("")
		.recursive()
		.serialize();
	}

	@Post("/evento/save")
	@Consumes(value = "application/json", options = WithoutRoot.class)
	public void save(EventoDTO dto){		
		try{
			enderecoDao.save(dto.getEvento().getEndereco());
			dao.save(dto.getEvento());
			programacaoDao.removeByEventoId(dto.getEvento().getId());		
			for (int i=0; i < dto.getEvento().getProgramacao().size(); i++){
				dto.getEvento().getProgramacao().get(i).setEvento(dto.getEvento());
				programacaoDao.save(dto.getEvento().getProgramacao().get(i));
			}			
			dao.commit();
		}
		catch(Exception e){
			dao.rollback();
			e.printStackTrace();
		}
		result.use(Results.json())
		.withoutRoot()
		.from(dto)
		.recursive()
		.serialize();
	}

	/**
	 * TODO EXISTE UMA INCONSISTENCIA AO RECEBER 
	 * UM PARÂMETRO DE TIPO PRIMITIVO ENVIADO PELO ANGULARJS
	 * 
	 * @param id
	 */
	@Post("/evento/delete")
	@Consumes(value = "application/json", options = WithoutRoot.class)
	//	public void delete(Evento entity) {
	public void delete(Long id) {
		try{
			//			Endereco endereco = enderecoDao.getByEventoId(entity.getId());
			//			dao.removeById(entity.getId());
			Endereco endereco = enderecoDao.getByEventoId(id);
			dao.removeById(id);
			enderecoDao.remove(endereco);
			dao.commit();
		}catch(ConstraintViolationException cve){
			dao.rollback();
			//			entity.setAtivo(false);
			//			dao.save(entity);
			//			dao.commit();
		}finally{
			result.use(Results.json())
			.withoutRoot()
			.from("ok")
			.serialize();
		}		
	}

	@Get("/evento/search")
	public void search(String search, String sort, String order, Integer limit, Integer offset){
		BootstrapTableParamsDTO params = new BootstrapTableParamsDTO(search, sort, order, limit, offset);
		BootstrapTableDTO<Evento> dto = new BootstrapTableDTO<Evento>();
		dto.setRows(dao.search(params));
		dto.setTotal(dao.count(params));		
		result.use(Results.json())
		.withoutRoot()
		.from(dto)
		.recursive()
		.serialize();
	}


} 
