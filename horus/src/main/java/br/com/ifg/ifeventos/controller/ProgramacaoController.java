package br.com.ifg.ifeventos.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.ifg.ifeventos.dto.ProgramacaoDTO;
import br.com.ifg.ifeventos.model.entity.Programacao;
import br.com.ifg.ifeventos.service.ProgramacaoService;



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
	public void form(){
		ProgramacaoDTO dto = service.loadForm();
		result.include("dto",dto);
	}


	@Post("/programacao/save")
	public void save(ProgramacaoDTO dto){
		
		service.save(dto);
		result.redirectTo(this).form();
	}


	@Path("/programacao/list")
	public void list(){
		List<Programacao> programacao  = service.List(); 
		result.include("list",programacao);
	}


	@Delete("/programacao")
	public void remove(Long id){
		service.deleteById(id);
		result.redirectTo(this).list();
	}

	
    @Post("/programacao/edit")
	public void edit(Long id){
		ProgramacaoDTO dto = new ProgramacaoDTO();
		dto.getProgramacao().setId(id);
		dto = service.load(dto);
		result.include("dto", dto);
	}


}//fim
	