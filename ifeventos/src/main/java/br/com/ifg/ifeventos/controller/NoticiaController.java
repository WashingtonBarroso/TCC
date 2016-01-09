package br.com.ifg.ifeventos.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.ifg.ifeventos.dto.NoticiaDTO;
import br.com.ifg.ifeventos.model.entity.Noticia;
import br.com.ifg.ifeventos.service.NoticiaService;

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
		result.redirectTo(this).form(); 
	}


	@Path("/noticia/list")
	public void list(){
		List<Noticia> noticias =  service.list();
		result.include("list", noticias);
	}


	@Delete("/noticia")
	public void remove(Long id) {
		service.deleteById(id);	
		result.redirectTo(this).list();   
	}


	@Post("/noticia/edit")
	public void edit(Long id){
		NoticiaDTO dto = new NoticiaDTO(); 
		dto.getNoticia().setId(id);	
		dto = service.load(dto);
		result.include("dto", dto);
	}	

	
	@Path("/noticia/loadJson")
	public void loadJson(){	
		result.use(Results.json()).from(service.list()).serialize(); 
	}

	
}//fim
