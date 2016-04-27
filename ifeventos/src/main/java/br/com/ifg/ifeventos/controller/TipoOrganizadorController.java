package br.com.ifg.ifeventos.controller;

import javax.inject.Inject;

import org.hibernate.exception.ConstraintViolationException;

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
import br.com.ifg.ifeventos.model.dao.impl.TipoOrganizadorDAO;
import br.com.ifg.ifeventos.model.entity.TipoOrganizador;

@Controller
public class TipoOrganizadorController {

	private final Result result;

	@Inject
	private TipoOrganizadorDAO dao;
	
	protected TipoOrganizadorController(){
		this(null);
	}

	@Inject
	public TipoOrganizadorController(Result result){
		this.result = result;
	}

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
	public void save(TipoOrganizador dto){
		try{
			dao.save(dto);
			dao.commit();
		}
		catch(Exception e){
			dao.rollback();
			e.printStackTrace();
			dto = new TipoOrganizador();
		}
		result.use(Results.json())
		.withoutRoot()
		.from(dto)
		.serialize();
	}
	
	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/tipoorganizador/delete")
	public void delete(TipoOrganizador entity) {
		try{
			dao.removeById(entity.getId());
			dao.commit();
		}catch(ConstraintViolationException cve){
			entity.setAtivo(false);
			dao.save(entity);
			dao.commit();
		}finally{
			result.use(Results.json())
			.withoutRoot()
			.from(entity)
			.serialize();
		}		
	}
	
	@Get("/tipoorganizador/search")
	public void search(String search, String sort, String order, Integer limit, Integer offset){
		BootstrapTableParamsDTO params = new BootstrapTableParamsDTO(search, sort, order, limit, offset);
		BootstrapTableDTO<TipoOrganizador> dto = new BootstrapTableDTO<TipoOrganizador>();
		dto.setRows(dao.search(params));
		dto.setTotal(dao.count(params));		
		result.use(Results.json())
		.withoutRoot()
		.from(dto)
		.recursive()
		.serialize();
	}

}
