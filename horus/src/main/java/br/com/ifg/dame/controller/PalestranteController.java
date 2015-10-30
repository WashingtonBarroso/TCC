package br.com.ifg.dame.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.ifg.dame.dto.PalestranteDTO;
import br.com.ifg.dame.model.entity.Palestrante;
import br.com.ifg.dame.service.PalestranteService;

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
	public void form(PalestranteDTO palestranteDTO){
		PalestranteDTO dto = service.loadForm();
		result.include("dto", dto);
	}
	@Post("/palestrante/save")
	public void save(PalestranteDTO dto){
		service.save(dto);
		result.include("dto", dto);
	}
	@Path("/palestrante/lista")
	public void lista(){
		List<Palestrante> palestrantes = service.listar();
		result.include("list", palestrantes);
	}
	@Delete("/palestrante")
	public void remove(Long id){
		service.deleteById(id);
		result.redirectTo(this).lista();
	}
}
