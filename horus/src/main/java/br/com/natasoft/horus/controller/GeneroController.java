package br.com.natasoft.horus.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.natasoft.horus.dto.GeneroDTO;
import br.com.natasoft.horus.model.entity.Genero;
import br.com.natasoft.horus.service.GeneroService;

@Controller
public class GeneroController {
	
	private final Result result;

	@Inject
	private GeneroService service;
	
	protected GeneroController() {
		this(null);
	}
	
	@Inject
	public GeneroController(Result result) {
		this.result = result;
	}

	@Path("/genero/form")
	public void form(GeneroDTO generoDTO) {
		GeneroDTO dto = service.loadForm();
		result.include("dto", dto);
	}
	
	@Post("/genero/save")
	public void save(GeneroDTO dto) {
		service.save(dto);
		result.include("dto", dto);
	}
    @Path("genero/lista")
	public void lista(){
		List<Genero> generos = service.listar();
		result.include("list", generos);
	}
}
