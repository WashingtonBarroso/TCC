package br.edu.ifg.ifeventos.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.ifg.ifeventos.dto.ProgramacaoDTO;
import br.edu.ifg.ifeventos.model.entity.Programacao;
import br.edu.ifg.ifeventos.service.ProgramacaoService;

@Controller
public class ProgramacaoController {

	private final Result result;	

	@Inject
	private ProgramacaoService service;

	public ProgramacaoController() {
		this(null);
	}
	@Inject
	public ProgramacaoController(Result result) {
		this.result = result;
	}	

	@Path("/programacao/form")
	public void form(ProgramacaoDTO programacaoDTO){
		ProgramacaoDTO dto = service.loadForm();
		result.include("dto",dto);
	}
	
	@Post("/programacao/save")
	public void save(ProgramacaoDTO dto){
		service.save(dto);
		result.include("dto",dto);
	}
	
	@Path("/programacao/lista")
	public void lista(){
		List<Programacao> programacao  = service.Lista(); 
		result.include("list",programacao);
	}
	
	@Delete("/programacao")
	public void remove(Long id){
		service.deleteById(id);
		result.redirectTo(this).lista();
	}

}
