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
import br.com.ifg.ifeventos.model.dao.impl.TipoProgramacaoDAO;
import br.com.ifg.ifeventos.model.entity.TipoProgramacao;
import br.com.ifg.ifeventos.utils.WriteLog;

@Controller
public class TipoProgramacaoController {

	private final Result result;
	final String clazz = TipoProgramacaoController.class.getSimpleName();

	@Inject
	private TipoProgramacaoDAO dao;
	
	protected TipoProgramacaoController(){
		this(null);
	}

	@Inject
	public TipoProgramacaoController(Result result){
		this.result = result;
	}
	
	/*
	 * Métodos Privados
	 */
	
	/*** Controle de exclusão lógica ***/
	

	private GenericDTO<TipoProgramacao> activate(TipoProgramacao entity) {
		try{		
			entity = dao.getByDescricao(entity.getDescricao());
			if (!entity.getAtivo()){
				entity.setAtivo(true);
				dao.save(entity);
				dao.commit();
				return new GenericDTO<TipoProgramacao>(entity, "");
			}
			else
				return new GenericDTO<TipoProgramacao>(null, "Registro duplicado!");
		}catch(Exception e){		
			dao.rollback();
			WriteLog.log(clazz, e.getMessage(), e.getCause());
			e.printStackTrace();
			return new GenericDTO<TipoProgramacao>(null, "Falha ao tentar salvar o Tipo de Programação! Informe o ocorrido ao suporte técnico.");
		}		
	}
	
	private GenericDTO<TipoProgramacao> deactivate(Long id) {
		try{
			TipoProgramacao entity = dao.getById(id);
			entity.setAtivo(false);
			dao.save(entity);
			dao.commit();
			return new GenericDTO<TipoProgramacao>(null, "");
		}catch(Exception e){		
			dao.rollback();
			WriteLog.log(clazz, e.getMessage(), e.getCause());
			e.printStackTrace();
			return new GenericDTO<TipoProgramacao>(null, "Falha ao tentar remover o Tipo de Programação! Informe o ocorrido ao suporte técnico.");
		}
	}
	
	private GenericDTO<TipoProgramacao> removeById(Long id){
		try{
			dao.removeById(id);
			dao.commit();
			return new GenericDTO<TipoProgramacao>(null, "");
		}catch(PersistenceException pe){
			dao.rollback();
			return deactivate(id);
		}catch(Exception e){
			dao.rollback();
			WriteLog.log(clazz, e.getMessage(), e.getCause());
			e.printStackTrace();
			return new GenericDTO<TipoProgramacao>(null, "Falha ao tentar remover o Tipo de Programação! Informe o ocorrido ao suporte técnico.");
		}
	}
	
	/*
	 * Métodos públicos
	 */
	

	@Path("/tipoprogramacao/form")
	public void form(){
	}
	
	@Get("/tipoprogramacao/form/{id}")
	public void form(Long id){
		TipoProgramacao entity = dao.getById(id);; 
		if (entity == null)
			result.redirectTo("/erro/404");
		else{
			Gson gson = new Gson();		
			result.include("dto",gson.toJson(entity));
		}	
	}
	
	@Path("/tipoprogramacao/list")
	public void list(){
	}

	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/tipoprogramacao/save")
	public void save(TipoProgramacao entity){		
		GenericDTO<TipoProgramacao> dto = new GenericDTO<TipoProgramacao>();
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
			dto.setMessage("Falha ao tentar salvar o Tipo de Programação! Informe o ocorrido ao suporte técnico.");
			e.printStackTrace();
		}
		result.use(Results.json()).withoutRoot().from(dto).recursive().serialize();
	}
	
	
	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/tipoprogramacao/delete")
	public void delete(Id id) {
		result.use(Results.json()).withoutRoot().from(removeById(id.getId())).serialize();
	}
	
	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/tipoprogramacao/deleteAllSelected")
	public void delete(List<Id> ids) {
		GenericDTO<TipoProgramacao> dto = new GenericDTO<TipoProgramacao>(null,"");
		for(Id id : ids){
			removeById(id.getId());
		}
		result.use(Results.json()).withoutRoot().from(dto).serialize();
	}	
	
	@Get("/tipoprogramacao/search")
	public void search(String search, String sort, String order, Integer limit, Integer offset){
		BootstrapTableParamsDTO params = new BootstrapTableParamsDTO(search, sort, order, limit, offset);
		BootstrapTableDTO<TipoProgramacao> dto = new BootstrapTableDTO<TipoProgramacao>();
		dto.setRows(dao.searchOnActiveRecords(params));
		dto.setTotal(dao.count(params));		
		result.use(Results.json())
		.withoutRoot()
		.from(dto)
		.recursive()
		.serialize();
	}

}
