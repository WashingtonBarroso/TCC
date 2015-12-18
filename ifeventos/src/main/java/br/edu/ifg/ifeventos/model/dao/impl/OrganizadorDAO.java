package br.edu.ifg.ifeventos.model.dao.impl;

import java.util.List;

import br.edu.ifg.ifeventos.model.entity.Organizador;

public class OrganizadorDAO extends DAO<Organizador,Long> {
	
	public List<Organizador> getByTipoOrganizadorId(Long id){
		return this.list("from Organizador where tipoOrganizador.id = :id", "id",id);
	}

}
