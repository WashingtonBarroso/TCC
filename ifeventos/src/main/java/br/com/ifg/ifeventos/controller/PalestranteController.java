package br.com.ifg.ifeventos.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.ifg.ifeventos.dto.PalestranteDTO;
import br.com.ifg.ifeventos.model.entity.Palestrante;
import br.com.ifg.ifeventos.service.PalestranteService;

@Controller
public class PalestranteController {

	private final Result result;

	@Inject
	private PalestranteService service;

	protected PalestranteController(){
		this(null);
	}


	@Inject
	public PalestranteController(Result result){
		this.result = result;
	}


	@Path("/palestrante/form")
	public void form(){
		PalestranteDTO dto = service.loadForm();
		result.include("dto", dto);
	}


	@Post("/palestrante/save")
	public void save(PalestranteDTO dto){
		service.save(dto);
		result.redirectTo(this).form();
	}


	@Path("/palestrante/list")
	public void list(){
		List<Palestrante> palestrantes = service.list();
		result.include("list", palestrantes);
	}


	@Delete("/palestrante")
	public void remove(Long id){
		service.deleteById(id);
		result.redirectTo(this).list();
	}


	@Post("palestrante/edit")
	public void edit(Long id){
		PalestranteDTO dto = new PalestranteDTO();
		dto.getPalestrante().setId(id);
		dto = service.load(dto);
		result.include("dto", dto);
	}


	@Path("/palestrante/loadJson")
	public void loadJson(){
		result.use(Results.json()).from(service.list()).serialize();	
	}
}
