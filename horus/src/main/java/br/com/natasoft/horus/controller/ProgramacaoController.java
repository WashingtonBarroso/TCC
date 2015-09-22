package br.com.natasoft.horus.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.natasoft.horus.dto.ProgramacaoDTO;
import br.com.natasoft.horus.model.entity.Programacao;
import br.com.natasoft.horus.service.ProgramacaoService;

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

	@Path("/horus/programacao/form")
	public void form(ProgramacaoDTO programacaoDTO){
		ProgramacaoDTO dto = service.loadForm();
		result.include("dto",dto);
	}

	@Post("/horus/progamacao/save")
	public void save(ProgramacaoDTO dto){
		service.save(dto);
		result.include("dto",dto);
	}

    @Path("/horus/programacao/lista")
    public void lista(){
    	List<Programacao> programacao  = service.Lista(); 
    	result.include("list",programacao);
    }
}

