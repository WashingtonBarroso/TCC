package br.com.ifg.dame.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.ifg.dame.dto.TipoProgramacaoDTO;
import br.com.ifg.dame.model.entity.TipoProgramacao;
import br.com.ifg.dame.service.TipoProgramacaoService;

@Controller
public class TipoProgramacaoController {

	private final Result result;

	@Inject
	private TipoProgramacaoService service;

	protected TipoProgramacaoController(){
		this(null);
	}

	@Inject
	public TipoProgramacaoController(Result result){
		this.result = result; 
	}

	@Path("/tipoProgramacao/form")
	public void form(TipoProgramacaoDTO TipoProgramacaoDTO){
		TipoProgramacaoDTO dto = service.loadForm();
		result.include("dto",dto);
	}
	@Post("/tipoProgramacao/save")
	public void save(TipoProgramacaoDTO dto){
		service.save(dto);
		result.include("dto",dto);
	}
	@Path("/tipoProgramacao/lista")
	public void lista(){
		List<TipoProgramacao> TipoProgramacoes = service.listar();
		result.include("list",TipoProgramacoes);
	}

}
