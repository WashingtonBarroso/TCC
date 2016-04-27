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
import br.com.ifg.ifeventos.model.dao.impl.NoticiaDAO;
import br.com.ifg.ifeventos.model.entity.Noticia;

@Controller
public class NoticiaController {

	private final Result result;

	@Inject 
	private NoticiaDAO dao;

	protected NoticiaController(){
		this(null);
	}

	@Inject
	public NoticiaController(Result result){
		this.result = result; 
	}

	@Path("/noticia/form")
	public void form(){	
	}

	@Get("/noticia/form/{id}")
	public void form(Long id){
		Noticia entity = dao.getById(id); 
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
	public void save(Noticia dto){
		try{
			dao.save(dto);
			dao.commit();
		}
		catch(Exception e){
			dao.rollback();
			e.printStackTrace();
			dto = new Noticia();
		}
		result.use(Results.json())
		.withoutRoot()
		.from(dto)
		.serialize();
	}

	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/noticia/delete")
	public void delete(Noticia entity) {
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
