package br.com.ifg.ifeventos.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.view.Results;
import br.com.ifg.ifeventos.dto.EventoDTO;
import br.com.ifg.ifeventos.model.entity.Evento;
import br.com.ifg.ifeventos.service.EventoService;

@Controller
public class EventoController {

	private final Result result;
     
	final String PATH = "C:\\Users\\Personal\\Documents\\GitHub\\TCC\\ifeventos\\src\\main\\webapp\\img\\upload\\evento";
	
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
	public void form(){
		EventoDTO dto = service.loadForm();
		result.include("dto", dto);
	}


	@Post("/evento/save")
	public void save(EventoDTO dto, UploadedFile imagem) throws IOException{	
        File fotoSalva = new File(PATH, imagem.getFileName());
		imagem.writeTo(fotoSalva);
        service.save(dto);
		result.redirectTo(this).form();
	}


	@Path("/evento/list")
	public void list(){
		List<Evento> eventos = service.list();
		result.include("list",eventos);
	}


	@Delete("/evento")
	public void remove(Long id) {
		service.deleteById(id);	
		result.redirectTo(this).list();
	}  

	
	@Post("/evento/edit")
	public void edit(Long id){
		EventoDTO dto = new EventoDTO();
		dto.getEvento().setId(id);
		dto = service.load(dto);
		result.include("dto",dto);

	}

	
	@Path("/evento/loadJson")
	public void loadJson(){
		result.use(Results.json()).from(service.list()).serialize();
	}


} 
