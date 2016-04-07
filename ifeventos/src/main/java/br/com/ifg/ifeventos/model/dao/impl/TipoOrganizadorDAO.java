package br.com.ifg.ifeventos.model.dao.impl;

import java.util.List;

import br.com.ifg.ifeventos.dto.BootstrapTableParamsDTO;
import br.com.ifg.ifeventos.model.entity.TipoOrganizador;

public class TipoOrganizadorDAO extends DAO<TipoOrganizador, Long> {
	
	public List<TipoOrganizador> search(BootstrapTableParamsDTO params){
		pageSize = params.getLimit();		
		Long id = -1L;
		try{
			id = Long.parseLong(params.getSearch());
		}catch(Exception e){
		};
		return (List<TipoOrganizador>) this.getPageableList(params.getOffset(),"from TipoOrganizador tp where tp.descricao like :param or tp.id = :id order by tp."+params.getSort()+" "+params.getOrder(),
				"id",id,
				"param","%"+params.getSearch()+"%");
	}
	
	public Long count(BootstrapTableParamsDTO params){
		pageSize = params.getLimit();		
		Long id = -1L;
		try{
			id = Long.parseLong(params.getSearch());
		}catch(Exception e){}
		
		return (Long) this.getGenericList("select count(*) from TipoOrganizador where descricao like :param or id = :id",
				"id",id,
				"param","%"+params.getSearch()+"%").get(0);
	}

}
