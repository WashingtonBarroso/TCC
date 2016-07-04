package br.com.ifg.ifeventos.model.dao.impl;

import java.util.List;

import br.com.ifg.ifeventos.dto.BootstrapTableParamsDTO;
import br.com.ifg.ifeventos.model.entity.TipoOrganizador;

public class TipoOrganizadorDAO extends DAO<TipoOrganizador, Long> {
	
	public List<TipoOrganizador> getAllActives() {
		return (List<TipoOrganizador>) this.getList("from TipoOrganizador to where to.ativo = true");
	}
	
	public TipoOrganizador getByDescricao(String descricao){
		return ((List<TipoOrganizador>) this.getList("from TipoOrganizador to where to.descricao = :param", "param",descricao)).get(0);		
	}
	
	public List<TipoOrganizador> search(BootstrapTableParamsDTO params) {
		pageSize = params.getLimit();
		Long id = -1L;
		try {
			id = Long.parseLong(params.getSearch());
		} 
		catch (Exception e) {};
		return (List<TipoOrganizador>) this.getPageableList(
				params.getOffset(), "from TipoOrganizador to where to.descricao like :param or to.id = :id order by to."
					+ params.getSort() + " " + params.getOrder(),
					"id", id, "param", "%" + params.getSearch() + "%");
	}
	
	public List<TipoOrganizador> searchOnActiveRecords(BootstrapTableParamsDTO params) {
		pageSize = params.getLimit();
		Long id = -1L;
		try {
			id = Long.parseLong(params.getSearch());
		} 
		catch (Exception e) {};
		return (List<TipoOrganizador>) this.getPageableList(
				params.getOffset(), "from TipoOrganizador to where to.ativo = true and to.descricao like :param or to.id = :id order by to."
					+ params.getSort() + " " + params.getOrder(),
					"id", id, "param", "%" + params.getSearch() + "%");
	}
	

	public Long count(BootstrapTableParamsDTO params) {
		pageSize = params.getLimit();
		Long id = -1L;
		try {
			id = Long.parseLong(params.getSearch());
		} 
		catch (Exception e) {}

		return (Long) this
				.getGenericList("select count(*) from TipoOrganizador where descricao like :param or id = :id", "id",
						id, "param", "%" + params.getSearch() + "%").get(0);
	}

}
