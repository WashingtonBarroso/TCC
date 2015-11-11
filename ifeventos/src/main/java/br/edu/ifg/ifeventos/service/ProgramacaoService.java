package br.edu.ifg.ifeventos.service;

import java.util.List;

import javax.inject.Inject;

import br.edu.ifg.ifeventos.dto.ProgramacaoDTO;
import br.edu.ifg.ifeventos.model.dao.impl.ProgramacaoDAO;
import br.edu.ifg.ifeventos.model.dao.impl.TipoProgramacaoDAO;
import br.edu.ifg.ifeventos.model.entity.Programacao;

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

	public List<Programacao> Lista(){
		return	dao.getAll(); 
	}	

	public void deleteById(Long id){
		dao.removeById(id);
		dao.commit();
	}
}
