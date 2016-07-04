package br.com.ifg.ifeventos.controller;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
import br.com.ifg.ifeventos.dto.EventoListDTO;
import br.com.ifg.ifeventos.dto.GenericDTO;
import br.com.ifg.ifeventos.dto.Id;
import br.com.ifg.ifeventos.model.dao.impl.EnderecoDAO;
import br.com.ifg.ifeventos.model.dao.impl.EventoDAO;
import br.com.ifg.ifeventos.model.dao.impl.OrganizadorDAO;
import br.com.ifg.ifeventos.model.dao.impl.PalestranteDAO;
import br.com.ifg.ifeventos.model.dao.impl.TipoOrganizadorDAO;
import br.com.ifg.ifeventos.model.dao.impl.TipoProgramacaoDAO;
import br.com.ifg.ifeventos.model.entity.Evento;
import br.com.ifg.ifeventos.utils.HashUtils;
import br.com.ifg.ifeventos.utils.WriteLog;
import br.com.ifg.ifeventos.utils.gson.exclusion.SkipSerializationExclusionStrategy;

@Controller
public class EventoController {

	private final Result result;
	final String PATH = "img\\evento";
	final String clazz = EventoController.class.getSimpleName();
	

	@Inject
	private EventoDAO dao;	
	
	@Inject
	private EnderecoDAO enderecoDao;	

	@Inject 
	private HttpServletRequest request;

	@Inject
	private OrganizadorDAO organizadorDao;
	
	@Inject
	private TipoOrganizadorDAO tipoOrganizadorDao;
	
	@Inject
	private PalestranteDAO palestranteDao;
	
	@Inject
	private TipoProgramacaoDAO tipoProgramacaoDao;	
	
	
	protected EventoController(){
		this(null);
	}

	@Inject
	public EventoController(Result result){
		this.result = result; 
	}
	
	/*
	 * Métodos Privados
	 */
	
	/*** Controle de exclusão lógica ***/
	

	private GenericDTO<Evento> activate(Evento entity) {
		try{		
			entity = dao.getByNome(entity.getNome());
			if (!entity.getAtivo()){
				entity.setAtivo(true);
				dao.save(entity);
				dao.commit();
				return new GenericDTO<Evento>(entity, "");
			}
			else
				return new GenericDTO<Evento>(null, "Registro duplicado!");
		}catch(Exception e){		
			dao.rollback();
			WriteLog.log(clazz, e.getMessage(), e.getCause());
			e.printStackTrace();
			return new GenericDTO<Evento>(null, "Falha ao tentar salvar o Evento! Informe o ocorrido ao suporte técnico.");
		}		
	}
	
	private GenericDTO<Evento> deactivate(Long id) {
		try{
			Evento entity = dao.getById(id);
			entity.setAtivo(false);
			dao.save(entity);
			dao.commit();
			return new GenericDTO<Evento>(null, "");
		}catch(Exception e){		
			dao.rollback();
			WriteLog.log(clazz, e.getMessage(), e.getCause());
			e.printStackTrace();
			return new GenericDTO<Evento>(null, "Falha ao tentar remover o Evento! Informe o ocorrido ao suporte técnico.");
		}
	}
	
	private GenericDTO<Evento> removeById(Long id){
		dao.setEntityManager(enderecoDao.getEntityManager());
		try{
			Long enderecoId = (enderecoDao.getByEventoId(id)).getId();
			dao.removeById(id);
			enderecoDao.removeById(enderecoId);
			dao.commit();
			return new GenericDTO<Evento>(null, "");
		}catch(PersistenceException pe){
			dao.rollback();
			return deactivate(id);
		}catch(Exception e){
			dao.rollback();
			WriteLog.log(clazz, e.getMessage(), e.getCause());
			e.printStackTrace();
			return new GenericDTO<Evento>(null, "Falha ao tentar remover o Evento! Informe o ocorrido ao suporte técnico.");
		}
	}
	
	/*
	 * Métodos públicos
	 */

	@Path("/evento/form")
	public void form(){	
		Gson gson = new Gson();
		result.include("listTpProgramacao",gson.toJson(tipoProgramacaoDao.getAllActives()));
		result.include("listOrganizador", gson.toJson(organizadorDao.getAllActives()));
		result.include("listTpOrganizador", gson.toJson(tipoOrganizadorDao.getAllActives()));
		result.include("listPalestrante", gson.toJson(palestranteDao.getAllActives()));
	}

	@Get("/evento/form/{id}")
	public void form(Long id){
		Evento entity = dao.getById(id);; 
		if (entity == null)
			result.redirectTo("/erro/404");
		else{
			Gson gson = new Gson();
			result.include("listTpProgramacao",gson.toJson(tipoProgramacaoDao.getAllActives()));
			result.include("listOrganizador", gson.toJson(organizadorDao.getAllActives()));
			result.include("listTpOrganizador", gson.toJson(tipoOrganizadorDao.getAllActives()));
			result.include("listPalestrante", gson.toJson(palestranteDao.getAllActives()));
			gson = new GsonBuilder().addSerializationExclusionStrategy(new SkipSerializationExclusionStrategy()).create();
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
			WriteLog.log(clazz, e.getMessage(), e.getCause());
		}
		result.use(Results.json()).withoutRoot()
		//		.from(dto)
		.from("").recursive().serialize();
	}
	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/evento/save")
	public void save(Evento entity){		
		GenericDTO<Evento> dto = new GenericDTO<Evento>();		
		dao.setEntityManager(enderecoDao.getEntityManager());
		try{			
			for (int i=0; i < entity.getMapas().size(); i++)
				entity.getMapas().get(i).setEvento(entity);		
			for (int i=0; i < entity.getProgramacao().size(); i++)
				entity.getProgramacao().get(i).setEvento(entity);
			for (int i=0; i < entity.getOrganizadores().size(); i++)
				entity.getOrganizadores().get(i).setEvento(entity);				
			enderecoDao.save(entity.getEndereco());			
			dao.save(entity);		
			dao.commit();
			dto.setDto(entity);
		}
		catch(PersistenceException e){
			dao.rollback();
			dto = activate(entity);
		}
		catch(Exception e){
			dao.rollback();
			WriteLog.log(clazz, e.getMessage(), e.getCause());
			dto.setMessage("Falha ao tentar salvar o Tipo de Programação! Informe o ocorrido ao suporte técnico.");
			e.printStackTrace();
		}
		result.use(Results.json()).withoutRoot().from(dto).recursive().serialize();
	}
	
	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/evento/delete")
	public void delete(Id id) {
		result.use(Results.json()).withoutRoot().from(removeById(id.getId())).serialize();
	}
	
	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/evento/deleteAllSelected")
	public void delete(List<Id> ids) {
		GenericDTO<Evento> dto = new GenericDTO<Evento>(null,"");
		for(Id id : ids){
			removeById(id.getId());
		}
		result.use(Results.json()).withoutRoot().from(dto).serialize();
	}

	@Get("/evento/search")
	public void search(String search, String sort, String order, Integer limit, Integer offset){
		BootstrapTableParamsDTO params = new BootstrapTableParamsDTO(search, sort, order, limit, offset);
		BootstrapTableDTO<EventoListDTO> dto = new BootstrapTableDTO<EventoListDTO>();
		dto.setRows(dao.searchOnActiveRecords(params));
		dto.setTotal(dao.count(params));		
		result.use(Results.json()).withoutRoot().from(dto).recursive().serialize();
	}
	
} 
