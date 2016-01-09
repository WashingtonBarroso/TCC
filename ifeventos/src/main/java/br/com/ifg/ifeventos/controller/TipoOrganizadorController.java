package br.com.ifg.ifeventos.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.ifg.ifeventos.dto.TipoOrganizadorDTO;
import br.com.ifg.ifeventos.model.entity.TipoOrganizador;
import br.com.ifg.ifeventos.service.TipoOrganizadorService;

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
	public void form(){
		TipoOrganizadorDTO dto = service.loadForm();
		result.include("dto", dto);
	}


	@Post("/tipoOrganizador/save")
	public void save(TipoOrganizadorDTO dto){
		service.save(dto);
		result.redirectTo(this).form();
	}


	@Path("/tipoOrganizador/list")
	public void list(){
		List<TipoOrganizador> tipoOrganizador = service.list();
		result.include("list", tipoOrganizador);
	}


	@Delete("/tipoOrganizador")
	public void remove(Long id){
		service.deleteById(id);
		result.redirectTo(this).list();
	}


	@Post("/tipoOrganizador/edit")
	public void edit(Long id){
		TipoOrganizadorDTO dto = new TipoOrganizadorDTO();
		dto.getTipoOrganizador().setId(id);
		dto = service.load(dto);
		result.include("dto", dto);
	}


}
