package br.com.natasoft.horus.service;

import java.util.List;

import javax.inject.Inject;

import br.com.natasoft.horus.dto.OrganizadorDTO;
import br.com.natasoft.horus.model.dao.impl.OrganizadorDAO;
import br.com.natasoft.horus.model.entity.Organizador;

public class OrganizadorService {

	@Inject	
	private OrganizadorDAO dao;

	public OrganizadorDTO loadForm(){
		return new OrganizadorDTO(new Organizador(null, "", "", "",null));
	}

	public OrganizadorDTO load(OrganizadorDTO dto){
		return new OrganizadorDTO(dao.getById(dto.getOrganizador().getId()));
	}

	public OrganizadorDTO save(OrganizadorDTO dto){
		dao.save(dto.getOrganizador());
		dao.commit();
		return dto;
	}

	public OrganizadorDTO delete(OrganizadorDTO dto){
		dao.remove(dto.getOrganizador());
		dao.commit();
		return dto;
	}
	public List<Organizador> listar(){
		return dao.getAll();
	}
     
}
