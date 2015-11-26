package br.com.ifg.ifeventos.service;

import java.util.List;

import javax.inject.Inject;

import br.com.ifg.ifeventos.dto.ProgramacaoDTO;
import br.com.ifg.ifeventos.model.dao.impl.ProgramacaoDAO;
import br.com.ifg.ifeventos.model.dao.impl.TipoProgramacaoDAO;
import br.com.ifg.ifeventos.model.entity.Programacao;

public class ProgramacaoService {

	@Inject
	private ProgramacaoDAO dao;	

	@Inject
	private TipoProgramacaoDAO tipoProgramacaoDao;

	
	public ProgramacaoDTO loadForm(){    
		ProgramacaoDTO dto =  new ProgramacaoDTO();
		dto.setTipoProgramacao(tipoProgramacaoDao.getAll());
		return dto;
	}
	
	
	public ProgramacaoDTO load(ProgramacaoDTO dto){
		return new ProgramacaoDTO(dao.getById(dto.getProgramacao().getId()),null);	
	}

	
	public ProgramacaoDTO save(ProgramacaoDTO dto){
		dao.save(dto.getProgramacao());
		dao.commit();
		return dto; 
	}

	
	public ProgramacaoDTO delete(ProgramacaoDTO dto){
		dao.remove(dto.getProgramacao());;
		dao.commit();
		return dto;
	}

	
	public List<Programacao> List(){
		return	dao.getAll(); 
	}	

	
	public void deleteById(Long id){
		dao.removeById(id);
		dao.commit();
	}

}
