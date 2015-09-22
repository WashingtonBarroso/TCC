package br.com.natasoft.horus.service;

import java.util.List;

import javax.inject.Inject;

import br.com.natasoft.horus.dto.OrganizadorDTO;
import br.com.natasoft.horus.model.dao.impl.OrganizadorDAO;
import br.com.natasoft.horus.model.dao.impl.TipoOrganizadorDAO;
import br.com.natasoft.horus.model.entity.Organizador;
import br.com.natasoft.horus.model.entity.TipoOrganizador;

public class OrganizadorService {

	@Inject	
	private OrganizadorDAO dao;
	@Inject
	private TipoOrganizadorDAO tipoOrganizadorDao;

	public OrganizadorDTO loadForm(){
		OrganizadorDTO dto = new OrganizadorDTO();
		dto.setTipos(tipoOrganizadorDao.getAll());
		return dto;
	}
	
	public List<TipoOrganizador> loadForm2(){
		return tipoOrganizadorDao.getAll();
	}

	public OrganizadorDTO load(OrganizadorDTO dto){
		return new OrganizadorDTO(dao.getById(dto.getOrganizador().getId()),null);
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
