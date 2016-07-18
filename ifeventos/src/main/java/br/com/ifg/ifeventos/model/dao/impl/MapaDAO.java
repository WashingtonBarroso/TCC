package br.com.ifg.ifeventos.model.dao.impl;

import java.util.List;

import br.com.ifg.ifeventos.dto.BootstrapTableParamsDTO;
import br.com.ifg.ifeventos.model.entity.Mapa;

public class MapaDAO extends DAO<Mapa, Long> {
	
	public List<Mapa> getByEventoId(Long id){
		return (List<Mapa>) this.getList("from Mapa where evento.id = :id", "id",id);
	}

	public List<Mapa> search(BootstrapTableParamsDTO params){
		pageSize = params.getLimit();		
		Long id = -1L;
		try{
			id = Long.parseLong(params.getSearch());
		}catch(Exception e){
		};
		return (List<Mapa>) this.getPageableList(params.getOffset(),"from Mapa m where m.descricao like :param or m.id = :id order by m."+params.getSort()+" "+params.getOrder(),
				"id",id,
				"param","%"+params.getSearch()+"%");
	}
	
	public Long count(BootstrapTableParamsDTO params){
		pageSize = params.getLimit();		
		Long id = -1L;
		try{
			id = Long.parseLong(params.getSearch());
		}catch(Exception e){}
		
		return (Long) this.getGenericList("select count(*) from Mapa where descricao like :param or id = :id",
				"id",id,
				"param","%"+params.getSearch()+"%").get(0);
	}
	
	
}
