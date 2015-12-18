package br.edu.ifg.ifeventos.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.ifg.ifeventos.dto.TipoOrganizadorDTO;
import br.edu.ifg.ifeventos.model.entity.TipoOrganizador;
import br.edu.ifg.ifeventos.service.TipoOrganizadorService;

@Controller
public class TipoOrganizadorController {

	private final Result result;

	@Inject
	private TipoOrganizadorService service;

	protected TipoOrganizadorController(){
		this(null);
	}

	@Inject
	public TipoOrganizadorController(Result result){
		this.result = result;
	}

	@Path("/tipoOrganizador/form")
	public void form(TipoOrganizadorDTO tipoOrganizadorDTO){
		TipoOrganizadorDTO dto = service.loadForm();
		result.include("dto", dto);
	}
	
	@Post("/tipoOrganizador/save")
	public void save(TipoOrganizadorDTO dto){
		service.save(dto);
		result.include("dto", dto);
		result.redirectTo(this).lista();
	}
	
	@Path("/tipoOrganizador/lista")
	public void lista(){
		List<TipoOrganizador> tipoOrganizador = service.listar();
		result.include("list", tipoOrganizador);
	}

}
