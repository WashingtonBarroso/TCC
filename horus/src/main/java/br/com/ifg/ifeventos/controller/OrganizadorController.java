package br.com.ifg.ifeventos.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.ifg.ifeventos.dto.OrganizadorDTO;
import br.com.ifg.ifeventos.model.entity.Organizador;
import br.com.ifg.ifeventos.service.OrganizadorService;

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
	public void form(){
		OrganizadorDTO dto = service.loadForm();
		result.include("dto",dto);
	}


	@Post("/organizador/save")
	public void save(OrganizadorDTO dto){
		service.save(dto);
		result.redirectTo(this).form();

	}
	@Path("/organizador/list")
	public void list(){
		List<Organizador> organizadores = service.list();
		result.include("list",organizadores);
	}


	@Delete("/organizador")
	public void remove(Long id){
		service.deleteById(id);
		result.redirectTo(this).list();
	}


	@Post("/organizador/edit")
	public void edit(Long id){
		OrganizadorDTO dto = new OrganizadorDTO();
		dto.getOrganizador().setId(id);
		dto = service.load(dto);
		result.include("dto", dto);
	}

}
