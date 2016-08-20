package br.com.ifg.ifeventos.controller;

import java.util.List;

import javax.inject.Inject;

import com.google.gson.Gson;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.serialization.gson.WithoutRoot;
import br.com.caelum.vraptor.view.Results;
import br.com.ifg.ifeventos.dto.BootstrapTableDTO;
import br.com.ifg.ifeventos.dto.BootstrapTableParamsDTO;
import br.com.ifg.ifeventos.dto.GenericDTO;
import br.com.ifg.ifeventos.dto.Id;
import br.com.ifg.ifeventos.model.dao.impl.NoticiaDAO;
import br.com.ifg.ifeventos.model.entity.Noticia;
import br.com.ifg.ifeventos.utils.WriteLog;

@Controller
public class NoticiaController {
	
	private final Result result;
	final String clazz = NoticiaController.class.getSimpleName();

	@Inject
	private NoticiaDAO dao;
	
	protected NoticiaController(){
		this(null);
	}

	@Inject
	public NoticiaController(Result result){
		this.result = result;
	}
	
	/*
	 * Métodos Privados
	 */
	
	/*** Controle de exclusão lógica ***/
	
	private GenericDTO<Noticia> removeById(Long id){
		try{
			dao.removeById(id);
			dao.commit();
			return new GenericDTO<Noticia>(null, "");	
		}catch(Exception e){
			dao.rollback();
			WriteLog.log(clazz, e.getMessage(), e.getCause());
			e.printStackTrace();
			return new GenericDTO<Noticia>(null, "Falha ao tentar remover o Notícia! Informe o ocorrido ao suporte técnico.");
		}
	}
	
	/*
	 * Métodos públicos
	 */
	

	@Path("/noticia/form")
	public void form(){
	}
	
	@Get("/noticia/form/{id}")
	public void form(Long id){
		Noticia entity = dao.getById(id);; 
		if (entity == null)
			result.redirectTo("/erro/404");
		else{
			Gson gson = new Gson();		
			result.include("dto",gson.toJson(entity));
		}	
	}
	
	@Path("/noticia/list")
	public void list(){
	}

	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/noticia/save")
	public void save(Noticia entity){		
		GenericDTO<Noticia> dto = new GenericDTO<Noticia>();
		try{
			dao.save(entity);
			dto.setDto(entity);
			dao.commit();
		}
		catch(Exception e){
			dao.rollback();
			WriteLog.log(clazz, e.getMessage(), e.getCause());
			dto.setMessage("Falha ao tentar salvar o Notícia! Informe o ocorrido ao suporte técnico.");
			e.printStackTrace();
		}
		result.use(Results.json()).withoutRoot().from(dto).recursive().serialize();
	}
	
	
	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/noticia/delete")
	public void delete(Id id) {
		result.use(Results.json()).withoutRoot().from(removeById(id.getId())).serialize();
	}
	
	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/noticia/deleteAllSelected")
	public void delete(List<Id> ids) {
		GenericDTO<Noticia> dto = new GenericDTO<Noticia>(null,"");
		for(Id id : ids){
			removeById(id.getId());
		}
		result.use(Results.json()).withoutRoot().from(dto).serialize();
	}	
	
	@Get("/noticia/search")
	public void search(String search, String sort, String order, Integer limit, Integer offset){
		BootstrapTableParamsDTO params = new BootstrapTableParamsDTO(search, sort, order, limit, offset);
		BootstrapTableDTO<Noticia> dto = new BootstrapTableDTO<Noticia>();
		dto.setRows(dao.search(params));
		dto.setTotal(dao.count(params));		
		result.use(Results.json())
		.withoutRoot()
		.from(dto)
		.recursive()
		.serialize();
	}

}
