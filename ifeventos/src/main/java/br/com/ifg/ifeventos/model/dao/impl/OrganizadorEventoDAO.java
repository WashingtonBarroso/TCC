package br.com.ifg.ifeventos.model.dao.impl;

import java.util.List;

import br.com.ifg.ifeventos.model.entity.OrganizadorEvento;

public class OrganizadorEventoDAO extends DAO<OrganizadorEvento,Long> {
	
	public List<OrganizadorEvento> getByTipoOrganizadorId(Long id){
		return (List<OrganizadorEvento>) this.getList("from OrganizadorEvento where tipoOrganizador.id = :id", "id",id);
	}
	
	public List<OrganizadorEvento> getByEventoId(Long id){
		return (List<OrganizadorEvento>) this.getList("from OrganizadorEvento where evento.id = :id", "id",id);
	}
	
	public List<OrganizadorEvento> getByOrganizadorId(Long id){
		return (List<OrganizadorEvento>) this.getList("from OrganizadorEvento where organizador.id = :id", "id",id);
	}
	
	public void removeByEventoId(Long id){
		this.executeUpdate("delete * from OrganizadorEvento where evento.id = :id","id",id);
	}
}
