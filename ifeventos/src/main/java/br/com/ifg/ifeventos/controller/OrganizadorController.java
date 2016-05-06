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
import br.com.ifg.ifeventos.model.dao.impl.OrganizadorDAO;
import br.com.ifg.ifeventos.model.dao.impl.TipoOrganizadorDAO;
import br.com.ifg.ifeventos.model.entity.Organizador;

@Controller
public class OrganizadorController {

	private final Result result;

	@Inject 
	private OrganizadorDAO dao;

	@Inject
	private TipoOrganizadorDAO tipoOrganizadorDao;


	protected OrganizadorController(){
		this(null);
	}


	@Inject
	public OrganizadorController(Result result){
		this.result = result; 
	}


	@Path("/organizador/form")
	public void form(){	
		Gson gson = new Gson();
		result.include("form",gson.toJson(tipoOrganizadorDao.getAll()));
	}



	@Get("/organizador/form/{id}")
	public void form(Long id){
		Organizador entity = dao.getById(id); 
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
	public void save(Organizador dto){
		try{
			dao.save(dto);
			dao.commit();
		}
		catch(Exception e){
			dao.rollback();
			e.printStackTrace();
			dto = new Organizador();
		}
		result.use(Results.json())
		.withoutRoot()
		.from(dto).recursive().serialize();
	}


	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/organizador/delete")
	public void delete(Organizador entity) {
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


	@Get("/organizador/search")
	public void search(String search, String sort, String order, Integer limit, Integer offset){
		BootstrapTableParamsDTO params = new BootstrapTableParamsDTO(search, sort, order, limit, offset);
		BootstrapTableDTO<Organizador> dto = new BootstrapTableDTO<Organizador>();
		dto.setRows(dao.search(params));
		dto.setTotal(dao.count(params));		
		result.use(Results.json())
		.withoutRoot()
		.from(dto)
		.recursive()
		.serialize();
	}



}
