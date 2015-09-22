package br.com.natasoft.horus.model.dao.impl;

import java.util.List;

import br.com.natasoft.horus.model.entity.Organizador;

public class OrganizadorDAO extends DAO<Organizador,Long> {
	
	public List<Organizador> getByTipoOrganizadorId(Long id){
		return this.list("from Organizador where tipoOrganizador.id = :id", "id",id);
	}

}
