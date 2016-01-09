package br.com.ifg.ifeventos.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.ifg.ifeventos.dto.TipoProgramacaoDTO;
import br.com.ifg.ifeventos.model.entity.TipoProgramacao;
import br.com.ifg.ifeventos.service.TipoProgramacaoService;

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
	public void form(){
		TipoProgramacaoDTO dto = service.loadForm();
		result.include("dto",dto);
	}


	@Post("/tipoProgramacao/save")
	public void save(TipoProgramacaoDTO dto){
		service.save(dto);
		result.redirectTo(this).form();
	}


	@Path("/tipoProgramacao/list")
	public void list(){
		List<TipoProgramacao> TipoProgramacoes = service.listar();
		result.include("list",TipoProgramacoes);
	}


	@Delete("/tipoProgramacao")
	public void remove(Long id){
		service.deleteByid(id);
		result.redirectTo(this).list();
	}

	
	@Post("/tipoProgramacao/edit")
	public void edit(Long id){
		TipoProgramacaoDTO  dto = new TipoProgramacaoDTO();
		dto.getTipoProgramacao().setId(id);
		dto = service.load(dto);
		result.include("dto", dto);
	}

	
}
