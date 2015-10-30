package br.com.ifg.dame.service;

import java.util.List;

import javax.inject.Inject;

import br.com.ifg.dame.dto.TipoOrganizadorDTO;
import br.com.ifg.dame.model.dao.impl.TipoOrganizadorDAO;
import br.com.ifg.dame.model.entity.TipoOrganizador;

public class TipoOrganizadorService {

	@Inject
	private TipoOrganizadorDAO dao;

	public TipoOrganizadorDTO loadForm(){
		return new TipoOrganizadorDTO(new TipoOrganizador(null, ""));
	}

	public TipoOrganizadorDTO load(TipoOrganizadorDTO dto){
		return new TipoOrganizadorDTO(dao.getById(dto.getTipoOrganizador().getId()));	
	}

	public TipoOrganizadorDTO save(TipoOrganizadorDTO dto){
		dao.save(dto.getTipoOrganizador());
		dao.commit();
		return dto;
	}

	public TipoOrganizadorDTO delete(TipoOrganizadorDTO dto){
		dao.remove(dto.getTipoOrganizador());
		dao.commit();
		return dto;
	}

	public List<TipoOrganizador> listar(){
		return dao.getAll();
	}

}
