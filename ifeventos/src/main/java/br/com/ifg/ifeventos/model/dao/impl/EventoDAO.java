package br.com.ifg.ifeventos.model.dao.impl;

import java.util.List;

import br.com.ifg.ifeventos.dto.BootstrapTableParamsDTO;
import br.com.ifg.ifeventos.model.entity.Evento;

public class EventoDAO extends DAO<Evento, Long>{
	
	public List<Evento> search(BootstrapTableParamsDTO params){
		pageSize = params.getLimit();		
		Long id = -1L;
		try{
			id = Long.parseLong(params.getSearch());
		}catch(Exception e){
		};
		return (List<Evento>) this.getPageableList(params.getOffset(),"select e from Evento e "
				+ "left join e.endereco en "
				+ "where e.nome like :param "
				+ "or e.local like :param "
				+ "or en.logradouro like :param "
				+ "or en.complemento like :param "
				+ "or en.bairro like :param "
				+ "or en.cidade like :param "
				+ "or en.estado like :param "
				+ "or en.cep like :param "
				+ "or e.site like :param "
				+ "or e.id = :id "
				+ "order by e."+params.getSort()+" "+params.getOrder(),
				"id",id,
				"param","%"+params.getSearch()+"%");
	}
	
	public Long count(BootstrapTableParamsDTO params){
		pageSize = params.getLimit();		
		Long id = -1L;
		try{
			id = Long.parseLong(params.getSearch());
		}catch(Exception e){}
		
		return (Long) this.getGenericList("select count(e) from Evento e "
				+ "left join e.endereco en "
				+ "where e.nome like :param "
				+ "or e.local like :param "
				+ "or en.logradouro like :param "
				+ "or en.complemento like :param "
				+ "or en.bairro like :param "
				+ "or en.cidade like :param "
				+ "or en.estado like :param "
				+ "or en.cep like :param "
				+ "or e.site like :param "
				+ "or e.id = :id ",
				"id",id,
				"param","%"+params.getSearch()+"%").get(0);
	}

}