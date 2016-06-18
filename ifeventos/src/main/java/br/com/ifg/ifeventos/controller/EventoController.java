package br.com.ifg.ifeventos.controller;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;

import com.google.gson.Gson;

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
import br.com.ifg.ifeventos.model.dao.impl.EnderecoDAO;
import br.com.ifg.ifeventos.model.dao.impl.EventoDAO;
import br.com.ifg.ifeventos.model.dao.impl.OrganizadorDAO;
import br.com.ifg.ifeventos.model.dao.impl.OrganizadorEventoDAO;
import br.com.ifg.ifeventos.model.dao.impl.ProgramacaoDAO;
import br.com.ifg.ifeventos.model.dao.impl.TipoProgramacaoDAO;
import br.com.ifg.ifeventos.model.entity.Endereco;
import br.com.ifg.ifeventos.model.entity.Evento;
import br.com.ifg.ifeventos.utils.HashUtils;

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
	private OrganizadorEventoDAO organizadorEventoDao;

	@Inject
	private ProgramacaoDAO programacaoDao;
	
	@Inject
	private TipoProgramacaoDAO tipoProgramacaoDao;
	
	
	
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
		result.include("listTpProgramacao",gson.toJson(tipoProgramacaoDao.getAll()));
		//result.include("listProgramacao", gson.toJson(programacaoDao.getAll()));
		//result.include("listPalestrante", gson.toJson(palestranteDao.getAll()));
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
	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/evento/save")
	public void save(Evento dto){		
		organizadorEventoDao.setEntityManager(dao.getEntityManager());
		programacaoDao.setEntityManager(dao.getEntityManager());
		enderecoDao.setEntityManager(dao.getEntityManager());
		try{
			enderecoDao.save(dto.getEndereco());			
			dao.save(dto);		
			programacaoDao.removeByEventoId(dto.getId());
			for (int i=0; i < dto.getProgramacao().size(); i++){
				dto.getProgramacao().get(i).setEvento(dto);
				programacaoDao.save(dto.getProgramacao().get(i));
			}
			organizadorEventoDao.removeByEventoId(dto.getId());
			for (int i=0; i < dto.getOrganizadores().size(); i++){
				dto.getOrganizadores().get(i).setEvento(dto);
				organizadorEventoDao.save(dto.getOrganizadores().get(i));
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
