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
import br.com.ifg.ifeventos.model.dao.impl.TipoProgramacaoDAO;
import br.com.ifg.ifeventos.model.entity.TipoProgramacao;

@Controller
public class TipoProgramacaoController {

	private final Result result;

	@Inject
	private TipoProgramacaoDAO dao;
	
	protected TipoProgramacaoController(){
		this(null);
	}

	
	@Inject
	public TipoProgramacaoController(Result result){
		this.result = result;
	}


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
	public void save(TipoProgramacao dto){
		try{
			dao.save(dto);
			dao.commit();
		}
		catch(Exception e){
			dao.rollback();
			e.printStackTrace();
			dto = new TipoProgramacao();
		}
		result.use(Results.json())
		.withoutRoot()
		.from(dto)
		.serialize();
	}
	
	@Consumes(value = "application/json", options = WithoutRoot.class)
	@Post("/tipoprogramacao/delete")
	public void delete(TipoProgramacao entity) {
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
	
	@Get("/tipoprogramacao/search")
	public void search(String search, String sort, String order, Integer limit, Integer offset){
		BootstrapTableParamsDTO params = new BootstrapTableParamsDTO(search, sort, order, limit, offset);
		BootstrapTableDTO<TipoProgramacao> dto = new BootstrapTableDTO<TipoProgramacao>();
		dto.setRows(dao.search(params));
		dto.setTotal(dao.count(params));		
		result.use(Results.json())
		.withoutRoot()
		.from(dto)
		.recursive()
		.serialize();
	}

}
