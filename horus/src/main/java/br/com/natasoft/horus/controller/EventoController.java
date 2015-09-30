package br.com.natasoft.horus.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.natasoft.horus.dto.EventoDTO;
import br.com.natasoft.horus.model.entity.Evento;
import br.com.natasoft.horus.service.EventoService;

@Controller
public class EventoController {

	private final Result result;

	@Inject
	private EventoService service;

	protected EventoController(){
		this(null);
	}

	@Inject
	public EventoController(Result result){
		this.result = result; 
	}

	@Path("/evento/form")
	public void form(EventoDTO eventoDTO){
		EventoDTO dto = service.loadForm();
		result.include("dto", dto);
	}
	@Post("/evento/save")
	public void save(EventoDTO dto){
		service.save(dto);
		result.include("dto",dto);
	}
	@Path("/evento/lista")
	public void lista(){
		List<Evento> eventos = service.listar();
		result.include("list",eventos);
	}
	@Delete("/evento")
	public void remove(Long id) {
		//EventoDTO dto = new EventoDTO();
		service.deleteById(id);	
		//result.include("dto", dto);
		result.redirectTo(this).lista();
	}  
} 
