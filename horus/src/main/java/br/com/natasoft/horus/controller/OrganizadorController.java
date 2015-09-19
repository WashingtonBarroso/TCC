package br.com.natasoft.horus.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.natasoft.horus.dto.OrganizadorDTO;
import br.com.natasoft.horus.model.entity.Organizador;
import br.com.natasoft.horus.service.OrganizadorService;

@Controller
public class OrganizadorController {
	private final Result result;

	@Inject
	private OrganizadorService service;

	protected OrganizadorController(){
		this(null);
	}

	@Inject
	public OrganizadorController(Result result){
		this.result = result; 
	}

	@Path("/organizador/form")
	public void form(OrganizadorDTO OrganizadorDTO){
		OrganizadorDTO dto = service.loadForm();
		result.include("dto",dto);
	}
	@Post("/organizador/save")
	public void save(OrganizadorDTO dto){
		service.save(dto);
		result.include("dto",dto);
	
	}
	@Path("/organizador/lista")
	public void lista(){
		List<Organizador> Organizadores = service.listar();
		result.include("list",Organizadores);
	}
}
