package br.com.ifg.ifeventos.model.dao.impl;

import br.com.ifg.ifeventos.model.entity.Endereco;

public class EnderecoDAO extends DAO<Endereco, Long> {	
	
	public Endereco getByEventoId(Long id){
		return getList("select en from Evento e inner join e.endereco en where e.id = :id", "id",id).get(0);
	}
}
