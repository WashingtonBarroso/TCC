package br.com.ifg.ifeventos.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

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
import br.com.ifg.ifeventos.model.dao.impl.OrganizadorDAO;
import br.com.ifg.ifeventos.model.entity.Organizador;
import br.com.ifg.ifeventos.utils.WriteLog;

@Controller
public class OrganizadorController {

	private final Result result;
	final String clazz = OrganizadorController.class.getSimpleName();

	@Inject
	private OrganizadorDAO dao;
	
	protected OrganizadorController(){
		this(null);
	}

	@Inject
	public OrganizadorController(Result result){
		this.result = result;
	}
	
	/*
	 * Métodos Privados
	 */
	
	/*** Controle de exclusão lógica ***/
	

	private GenericDTO<Organizador> activate(Organizador entity) {
		try{		
			entity = dao.getByNome(entity.getNome());
			if (!entity.getAtivo()){
				entity.setAtivo(true);
				dao.save(entity);
				dao.commit();
				return new GenericDTO<Organizador>(entity, "");
			}
			else
				return new GenericDTO<Organizador>(null, "Registro duplicado!");
		}catch(Exception e){		
			dao.rollback();
			WriteLog.log(clazz, e.getMessage(), e.getCause());
			e.printStackTrace();
			return new GenericDTO<Organizador>(null, "Falha ao tentar salvar o Organizador! Informe o ocorrido ao suporte técnico.");
		}		
	}
	
	private GenericDTO<Organizador> deactivate(Long id) {
		try{
			Organizador entity = dao.getById(id);
			entity.setAtivo(false);
			dao.save(entity);
			dao.commit();
			return new GenericDTO<Organizador>(null, "");
		}catch(Exception e){		
			dao.rollback();
			WriteLog.log(clazz, e.getMessage(), e.getCause());
			e.printStackTrace();
			return new GenericDTO<Organizador>(null, "Falha ao tentar remover o Organizador! Informe o ocorrido ao suporte técnico.");
		}
	}
	
	private GenericDTO<Organizador> removeById(Long id){
		try{
			dao.removeById(id);
			dao.commit();
			return new GenericDTO<Organizador>(null, "");
		}catch(PersistenceException pe){
			dao.rollback();
			return deactivate(id);
		}catch(Exception e){
			dao.rollback();
			WriteLog.log(clazz, e.getMessage(), e.getCause());
			e.printStackTrace();
			return new GenericDTO<Organizador>(null, "Falha ao tentar remover o Tipo de Organizador! Informe o ocorrido ao suporte técnico.");
		}
	}
	
	/*
	 * Métodos públicos
	 */
	

	@Path("/organizador/form")
	public void form(){
	}
	
	@Get("/organizador/form/{id}")
	public void form(Long id){
		Organizador entity = dao.getById(id);; 
		if (entity == null)
			result.redirectTo("/erro/404");
		else{
			Gson gson = new Gson();		
			result.include("dto",gson.toJson(entity));
		}	
	}
	
	@Path("/organizador/list")
	public void list(){
	}

	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/organizador/save")
	public void save(Organizador entity){		
		GenericDTO<Organizador> dto = new GenericDTO<Organizador>();
		try{
			dao.save(entity);
			dto.setDto(entity);
			dao.commit();
		}
		catch(PersistenceException e){
			dao.rollback();
			dto = activate(entity);
		}
		catch(Exception e){
			dao.rollback();
			WriteLog.log(clazz, e.getMessage(), e.getCause());
			dto.setMessage("Falha ao tentar salvar o Tipo de Organizador! Informe o ocorrido ao suporte técnico.");
			e.printStackTrace();
		}
		result.use(Results.json()).withoutRoot().from(dto).recursive().serialize();
	}
	
	
	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/organizador/delete")
	public void delete(Id id) {
		result.use(Results.json()).withoutRoot().from(removeById(id.getId())).serialize();
	}
	
	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/organizador/deleteAllSelected")
	public void delete(List<Id> ids) {
		GenericDTO<Organizador> dto = new GenericDTO<Organizador>(null,"");
		for(Id id : ids){
			removeById(id.getId());
		}
		result.use(Results.json()).withoutRoot().from(dto).serialize();
	}	
	
	@Get("/organizador/search")
	public void search(String search, String sort, String order, Integer limit, Integer offset){
		BootstrapTableParamsDTO params = new BootstrapTableParamsDTO(search, sort, order, limit, offset);
		BootstrapTableDTO<Organizador> dto = new BootstrapTableDTO<Organizador>();
		dto.setRows(dao.searchOnActiveRecords(params));
		dto.setTotal(dao.count(params));		
		result.use(Results.json())
		.withoutRoot()
		.from(dto)
		.recursive()
		.serialize();
	}

}
