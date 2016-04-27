package br.com.ifg.ifeventos.model.dao.impl;

import java.util.List;

import br.com.ifg.ifeventos.dto.BootstrapTableParamsDTO;
import br.com.ifg.ifeventos.model.entity.Palestrante;

public class PalestranteDAO extends DAO<Palestrante, Long> {

	public List<Palestrante> search(BootstrapTableParamsDTO params){
		pageSize = params.getLimit();		
		Long id = -1L;
		try{
			id = Long.parseLong(params.getSearch());
		}catch(Exception e){
		};
		return (List<Palestrante>) this.getPageableList(params.getOffset(),"from Palestrante p where p.nome like :param or p.id = :id order by p."+params.getSort()+" "+params.getOrder(),
				"id",id,
				"param","%"+params.getSearch()+"%");
	}
	
	public Long count(BootstrapTableParamsDTO params){
		pageSize = params.getLimit();		
		Long id = -1L;
		try{
			id = Long.parseLong(params.getSearch());
		}catch(Exception e){}
		
		return (Long) this.getGenericList("select count(*) from Palestrante where nome like :param or id = :id",
				"id",id,
				"param","%"+params.getSearch()+"%").get(0);
	}	
	
}
