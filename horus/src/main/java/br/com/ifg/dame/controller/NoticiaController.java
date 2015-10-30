package br.com.ifg.dame.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.ifg.dame.dto.NoticiaDTO;
import br.com.ifg.dame.model.entity.Noticia;
import br.com.ifg.dame.service.NoticiaService;

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
	@Get("/noticia/edita/{id}")
	public Noticia editar(Long id){
		return service.editar(id);
	}	
	@Post("/noticia/altera")
	public void alterar(Noticia noticia){
		service.alterar(noticia);
		result.redirectTo(this).lista();
	}
}
