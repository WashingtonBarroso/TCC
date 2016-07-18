package br.com.ifg.ifeventos.model.dao.impl;

import java.util.List;

import br.com.ifg.ifeventos.dto.BootstrapTableParamsDTO;
import br.com.ifg.ifeventos.model.entity.TipoProgramacao;

public class TipoProgramacaoDAO extends DAO<TipoProgramacao, Long> {
	
	public List<TipoProgramacao> getAllActives() {
		return (List<TipoProgramacao>) this.getList("from TipoProgramacao tp where tp.ativo = true");
	}
	
	public TipoProgramacao getByDescricao(String descricao){
		return ((List<TipoProgramacao>) this.getList("from TipoProgramacao tp where tp.descricao = :param", "param",descricao)).get(0);		
	}
	
	public List<TipoProgramacao> search(BootstrapTableParamsDTO params) {
		pageSize = params.getLimit();
		Long id = -1L;
		try {
			id = Long.parseLong(params.getSearch());
		} 
		catch (Exception e) {};
		return (List<TipoProgramacao>) this.getPageableList(
				params.getOffset(), "from TipoProgramacao tp where tp.descricao like :param or tp.id = :id order by tp."
					+ params.getSort() + " " + params.getOrder(),
					"id", id, "param", "%" + params.getSearch() + "%");
	}
	
	public List<TipoProgramacao> searchOnActiveRecords(BootstrapTableParamsDTO params) {
		pageSize = params.getLimit();
		Long id = -1L;
		try {
			id = Long.parseLong(params.getSearch());
		} 
		catch (Exception e) {};
		return (List<TipoProgramacao>) this.getPageableList(
				params.getOffset(), "from TipoProgramacao tp where tp.ativo = true and tp.descricao like :param or tp.id = :id order by tp."
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
				.getGenericList("select count(*) from TipoProgramacao where descricao like :param or id = :id", "id",
						id, "param", "%" + params.getSearch() + "%").get(0);
	}

}
