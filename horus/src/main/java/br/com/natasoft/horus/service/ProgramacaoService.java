package br.com.natasoft.horus.service;

import java.util.List;

import javax.inject.Inject;

import br.com.natasoft.horus.dto.ProgramacaoDTO;
import br.com.natasoft.horus.model.dao.impl.ProgramacaoDAO;
import br.com.natasoft.horus.model.dao.impl.TipoProgramacaoDAO;
import br.com.natasoft.horus.model.entity.Programacao;

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

}
