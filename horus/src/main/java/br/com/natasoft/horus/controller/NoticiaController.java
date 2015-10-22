package br.com.natasoft.horus.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.natasoft.horus.dto.NoticiaDTO;
import br.com.natasoft.horus.model.entity.Noticia;
import br.com.natasoft.horus.service.NoticiaService;

@Controller
public class NoticiaController {

	private final Result result;

	@Inject 	
	private NoticiaService service;	

	protected NoticiaController(){
		this(null);
	}
	@Inject
	public NoticiaController(Result result){
		this.result = result;
	}

	@Path("/noticia/form")
	public void form(){ 
		NoticiaDTO dto = service.loadForm();
		result.include("dto", dto);
	}

	@Post("/noticia/save")
	public void save(NoticiaDTO dto){
		service.save(dto);
		result.include("dto", dto);
	}
	@Path("/noticia/lista")
	public void lista(){
		List<Noticia> noticias =  service.listar();
		result.include("list", noticias);
	}

	@Delete("/noticia")
	public void remove(Long id) {
		service.deleteById(id);	
		result.redirectTo(this).lista();
	}
	@Get("/noticia/editar/{id}")
	public Noticia editar(Long id){
		return service.alterar(id);
	}
	@Put	
	@Path("/noticia")
	public void modificar(Noticia noticia){
		service.modificar(noticia);
		result.redirectTo(this).lista();
	}
}
