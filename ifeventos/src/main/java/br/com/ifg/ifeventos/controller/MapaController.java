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
import br.com.ifg.ifeventos.model.dao.impl.MapaDAO;
import br.com.ifg.ifeventos.model.entity.Mapa;


@Controller
public class MapaController {

	private final Result result;

	@Inject 
	private MapaDAO dao;

	protected MapaController(){
		this(null);
	}

	@Inject
	public MapaController(Result result){
		this.result = result; 
	}

	@Path("/mapa/form")
	public void form(){	
	}

	@Get("/mapa/form/{id}")
	public void form(Long id){
		Mapa entity = dao.getById(id); 
		if (entity == null)
			result.redirectTo("/erro/404");
		else{
			Gson gson = new Gson();		
			result.include("dto",gson.toJson(entity));
		}	
	}

	@Path("/mapa/list")
	public void list(){
	}

	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/mapa/save")
	public void save(Mapa dto){
		try{
			dao.save(dto);
			dao.commit();
		}
		catch(Exception e){
			dao.rollback();
			e.printStackTrace();
			dto = new Mapa();
		}
		result.use(Results.json())
		.withoutRoot()
		.from(dto)
		.serialize();
	}

	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/mapa/delete")
	public void delete(Mapa entity) {
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


	@Get("/mapa/search")
	public void search(String search, String sort, String order, Integer limit, Integer offset){
		BootstrapTableParamsDTO params = new BootstrapTableParamsDTO(search, sort, order, limit, offset);
		BootstrapTableDTO<Mapa> dto = new BootstrapTableDTO<Mapa>();
		dto.setRows(dao.search(params));
		dto.setTotal(dao.count(params));		
		result.use(Results.json())
		.withoutRoot()
		.from(dto)
		.recursive()
		.serialize();
	}



}
