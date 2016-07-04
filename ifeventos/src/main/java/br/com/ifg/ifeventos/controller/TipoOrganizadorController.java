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
import br.com.ifg.ifeventos.model.dao.impl.TipoOrganizadorDAO;
import br.com.ifg.ifeventos.model.entity.TipoOrganizador;
import br.com.ifg.ifeventos.utils.WriteLog;

@Controller
public class TipoOrganizadorController {

	private final Result result;
	final String clazz = TipoOrganizadorController.class.getSimpleName();

	@Inject
	private TipoOrganizadorDAO dao;
	
	protected TipoOrganizadorController(){
		this(null);
	}

	@Inject
	public TipoOrganizadorController(Result result){
		this.result = result;
	}
	
	/*
	 * Métodos Privados
	 */
	
	/*** Controle de exclusão lógica ***/
	

	private GenericDTO<TipoOrganizador> activate(TipoOrganizador entity) {
		try{		
			entity = dao.getByDescricao(entity.getDescricao());
			if (!entity.getAtivo()){
				entity.setAtivo(true);
				dao.save(entity);
				dao.commit();
				return new GenericDTO<TipoOrganizador>(entity, "");
			}
			else
				return new GenericDTO<TipoOrganizador>(null, "Registro duplicado!");
		}catch(Exception e){		
			dao.rollback();
			WriteLog.log(clazz, e.getMessage(), e.getCause());
			e.printStackTrace();
			return new GenericDTO<TipoOrganizador>(null, "Falha ao tentar salvar o Tipo de Organizador! Informe o ocorrido ao suporte técnico.");
		}		
	}
	
	private GenericDTO<TipoOrganizador> deactivate(Long id) {
		try{
			TipoOrganizador entity = dao.getById(id);
			entity.setAtivo(false);
			dao.save(entity);
			dao.commit();
			return new GenericDTO<TipoOrganizador>(null, "");
		}catch(Exception e){		
			dao.rollback();
			WriteLog.log(clazz, e.getMessage(), e.getCause());
			e.printStackTrace();
			return new GenericDTO<TipoOrganizador>(null, "Falha ao tentar remover o Tipo de Organizador! Informe o ocorrido ao suporte técnico.");
		}
	}
	
	private GenericDTO<TipoOrganizador> removeById(Long id){
		try{
			dao.removeById(id);
			dao.commit();
			return new GenericDTO<TipoOrganizador>(null, "");
		}catch(PersistenceException pe){
			dao.rollback();
			return deactivate(id);
		}catch(Exception e){
			dao.rollback();
			WriteLog.log(clazz, e.getMessage(), e.getCause());
			e.printStackTrace();
			return new GenericDTO<TipoOrganizador>(null, "Falha ao tentar remover o Tipo de Organizador! Informe o ocorrido ao suporte técnico.");
		}
	}
	
	/*
	 * Métodos públicos
	 */
	

	@Path("/tipoorganizador/form")
	public void form(){
	}
	
	@Get("/tipoorganizador/form/{id}")
	public void form(Long id){
		TipoOrganizador entity = dao.getById(id);; 
		if (entity == null)
			result.redirectTo("/erro/404");
		else{
			Gson gson = new Gson();		
			result.include("dto",gson.toJson(entity));
		}	
	}
	
	@Path("/tipoorganizador/list")
	public void list(){
	}

	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/tipoorganizador/save")
	public void save(TipoOrganizador entity){		
		GenericDTO<TipoOrganizador> dto = new GenericDTO<TipoOrganizador>();
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
	@Post("/tipoorganizador/delete")
	public void delete(Id id) {
		result.use(Results.json()).withoutRoot().from(removeById(id.getId())).serialize();
	}
	
	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/tipoorganizador/deleteAllSelected")
	public void delete(List<Id> ids) {
		GenericDTO<TipoOrganizador> dto = new GenericDTO<TipoOrganizador>(null,"");
		for(Id id : ids){
			removeById(id.getId());
		}
		result.use(Results.json()).withoutRoot().from(dto).serialize();
	}	
	
	@Get("/tipoorganizador/search")
	public void search(String search, String sort, String order, Integer limit, Integer offset){
		BootstrapTableParamsDTO params = new BootstrapTableParamsDTO(search, sort, order, limit, offset);
		BootstrapTableDTO<TipoOrganizador> dto = new BootstrapTableDTO<TipoOrganizador>();
		dto.setRows(dao.searchOnActiveRecords(params));
		dto.setTotal(dao.count(params));		
		result.use(Results.json())
		.withoutRoot()
		.from(dto)
		.recursive()
		.serialize();
	}

}
