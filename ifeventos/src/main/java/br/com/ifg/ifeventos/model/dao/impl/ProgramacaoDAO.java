package br.com.ifg.ifeventos.model.dao.impl;

import java.util.List;

import br.com.ifg.ifeventos.dto.BootstrapTableParamsDTO;
import br.com.ifg.ifeventos.model.entity.Programacao;

public class ProgramacaoDAO extends DAO<Programacao, Long> {

	public List<Programacao> search(BootstrapTableParamsDTO params){
		pageSize = params.getLimit();		
		Long id = -1L;
		try{
			id = Long.parseLong(params.getSearch());
		}catch(Exception e){
		};
		return (List<Programacao>) this.getPageableList(params.getOffset(),"from Programacao pr where pr.local like :param or pr.id = :id order by pr."+params.getSort()+" "+params.getOrder(),
				"id",id,
				"param","%"+params.getSearch()+"%");
	}
	
	public Long count(BootstrapTableParamsDTO params){
		pageSize = params.getLimit();		
		Long id = -1L;
		try{
			id = Long.parseLong(params.getSearch());
		}catch(Exception e){}
		
		return (Long) this.getGenericList("select count(*) from Programacao where local like :param or id = :id",
				"id",id,
				"param","%"+params.getSearch()+"%").get(0);
	}	
	
	
	
}
