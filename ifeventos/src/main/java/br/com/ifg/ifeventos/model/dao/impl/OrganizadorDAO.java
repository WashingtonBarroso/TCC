package br.com.ifg.ifeventos.model.dao.impl;

import java.util.List;

import br.com.ifg.ifeventos.model.entity.Organizador;

public class OrganizadorDAO extends DAO<Organizador,Long> {
	
	public List<Organizador> getByTipoOrganizadorId(Long id){
		return (List<Organizador>) this.getList("from Organizador where tipoOrganizador.id = :id", "id",id);
	}

}
