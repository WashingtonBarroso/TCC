package br.com.ifg.ifeventos.model.dao.impl;

import java.util.List;

import br.com.ifg.ifeventos.dto.BootstrapTableParamsDTO;
import br.com.ifg.ifeventos.model.entity.Organizador;

public class OrganizadorDAO extends DAO<Organizador,Long> {
	
	public List<Organizador> getAllActives() {
		return (List<Organizador>) this.getList("from Organizador o where o.ativo = true");
	}
	
	public Organizador getByNome(String descricao){
		return ((List<Organizador>) this.getList("from Organizador o where o.nome = :param", "param",descricao)).get(0);		
	}
	
	public List<Organizador> getByTipoOrganizadorId(Long id){
		return (List<Organizador>) this.getList("from Organizador where tipoOrganizador.id = :id", "id",id);
	}

	public List<Organizador> searchOnActiveRecords(BootstrapTableParamsDTO params){
		pageSize = params.getLimit();		
		Long id = -1L;
		try{
			id = Long.parseLong(params.getSearch());
		}catch(Exception e){
		};
		return (List<Organizador>) this.getPageableList(params.getOffset(),"from Organizador o where o.ativo = true and (o.nome like :param or o.id = :id) order by o."+params.getSort()+" "+params.getOrder(),
				"id",id,
				"param","%"+params.getSearch()+"%");
	}
	
	public List<Organizador> search(BootstrapTableParamsDTO params){
		pageSize = params.getLimit();		
		Long id = -1L;
		try{
			id = Long.parseLong(params.getSearch());
		}catch(Exception e){
		};
		return (List<Organizador>) this.getPageableList(params.getOffset(),"from Organizador o where o.nome like :param or o.id = :id order by o."+params.getSort()+" "+params.getOrder(),
				"id",id,
				"param","%"+params.getSearch()+"%");
	}
	
	public Long count(BootstrapTableParamsDTO params){
		pageSize = params.getLimit();		
		Long id = -1L;
		try{
			id = Long.parseLong(params.getSearch());
		}catch(Exception e){}
		
		return (Long) this.getGenericList("select count(*) from Organizador where nome like :param or id = :id",
				"id",id,
				"param","%"+params.getSearch()+"%").get(0);
	}


}
