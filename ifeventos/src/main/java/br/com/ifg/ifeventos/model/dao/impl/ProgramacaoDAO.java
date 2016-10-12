package br.com.ifg.ifeventos.model.dao.impl;

import java.util.List;

import br.com.ifg.ifeventos.dto.BootstrapTableParamsDTO;
import br.com.ifg.ifeventos.model.entity.Palestrante;
import br.com.ifg.ifeventos.model.entity.Programacao;

public class ProgramacaoDAO extends DAO<Programacao, Long> {
	
	public List<Programacao> getByEventoId(Long id){
		return (List<Programacao>) this.getList("from Programacao where evento.id = :id", "id",id);
	}
	
	public List<Programacao> searchOnActiveRecords(BootstrapTableParamsDTO params){
		pageSize = params.getLimit();		
		Long id = -1L;
		try{
			id = Long.parseLong(params.getSearch());
		}catch(Exception e){
		};
		return (List<Programacao>) this.getPageableList(params.getOffset(),"from Programacao pr where pr.ativo = true and (pr.descricao like :param or pr.id = :id) order by pr."+params.getSort()+" "+params.getOrder(),
				"id",id,
				"param","%"+params.getSearch()+"%");
	}

	public List<Programacao> search(BootstrapTableParamsDTO params){
		pageSize = params.getLimit();		
		Long id = -1L;
		try{
			id = Long.parseLong(params.getSearch());
		}catch(Exception e){
		};
		return (List<Programacao>) this.getPageableList(params.getOffset(),"from Programacao pr where pr.descricao like :param or pr.id = :id order by pr."+params.getSort()+" "+params.getOrder(),
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
	
	public void removeByEventoId(Long id){
		this.executeUpdate("delete * from Programacao p where p.evento.id = :id","id",id);
	}

}
