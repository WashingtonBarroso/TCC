package br.edu.ifg.ifeventos.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.ifg.ifeventos.dto.OrganizadorDTO;
import br.edu.ifg.ifeventos.model.entity.Organizador;
import br.edu.ifg.ifeventos.service.OrganizadorService;

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
		result.redirectTo(this).lista();
	}
	
	@Path("/organizador/lista")
	public void lista(){
		List<Organizador> organizadores = service.listar();
		result.include("list",organizadores);
	}
	@Delete("/organizador")
	public void remove(Long id){
		service.deleteById(id);
		result.redirectTo(this).lista();
	}
}
