package br.edu.ifg.ifeventos.service;

import java.util.List;

import javax.inject.Inject;

import br.edu.ifg.ifeventos.dto.TipoProgramacaoDTO;
import br.edu.ifg.ifeventos.model.dao.impl.TipoProgramacaoDAO;
import br.edu.ifg.ifeventos.model.entity.TipoProgramacao;


public class TipoProgramacaoService {

	@Inject
	private TipoProgramacaoDAO dao;

	public TipoProgramacaoDTO loadForm(){
		return new TipoProgramacaoDTO(new TipoProgramacao(null, "")); 
	}

	public TipoProgramacaoDTO load(TipoProgramacaoDTO dto){
		return new TipoProgramacaoDTO(dao.getById(dto.getTipoProgramacao().getId())); 
	}	

	public TipoProgramacaoDTO save(TipoProgramacaoDTO dto){
		dao.save(dto.getTipoProgramacao());
		dao.commit();
		return dto;
	}

	public TipoProgramacaoDTO delete(TipoProgramacaoDTO dto){
		dao.remove(dto.getTipoProgramacao());
		dao.commit();
		return dto;
	}

	public List<TipoProgramacao> listar(){
		return dao.getAll();
	}
}
