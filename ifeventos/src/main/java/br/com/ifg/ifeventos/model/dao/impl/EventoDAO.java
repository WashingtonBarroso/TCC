package br.com.ifg.ifeventos.model.dao.impl;

import java.util.List;

import br.com.ifg.ifeventos.dto.BootstrapTableParamsDTO;
import br.com.ifg.ifeventos.dto.EventoAppDTO;
import br.com.ifg.ifeventos.dto.EventoListDTO;
import br.com.ifg.ifeventos.model.entity.Evento;
import br.com.ifg.ifeventos.model.entity.TipoOrganizador;


public class EventoDAO extends DAO<Evento, Long>{
	
	public List<Evento> getAllActives() {
		return (List<Evento>) this.getList("from Evento e where e.ativo = true");
	}
	
	public List<EventoAppDTO> getListEventos(){	
		return (List<EventoAppDTO>) this.getGenericList("select new br.com.ifg.ifeventos.dto.EventoAppDTO(e.id, e.nome, e.dataInicio, e.dataFim, e.local, e.site, e.endereco, e.imagem) from Evento e left join e.endereco where e.ativo = true");
		//return (List<Evento>) this.getList("from Evento e where p.ativo = true");

	}
	
	public Evento getByNome(String nome){
		return ((List<Evento>) this.getList("from Evento e where e.nome = :param", "param",nome)).get(0);		
	}
	
	public List<EventoListDTO> searchOnActiveRecords(BootstrapTableParamsDTO params){
		pageSize = params.getLimit();		
		Long id = -1L;
		try{
			id = Long.parseLong(params.getSearch());
		}catch(Exception e){
		};
		return (List<EventoListDTO>) this.getPageableGenericList(params.getOffset(),"select new br.com.ifg.ifeventos.dto.EventoListDTO(e.id, e.nome, e.local, e.endereco, e.imagem) from Evento e "
				+ "left join e.endereco en "
				+ "where e.ativo = true and (e.nome like :param "
				+ "or e.local like :param "
				+ "or en.logradouro like :param "
				+ "or en.complemento like :param "
				+ "or en.bairro like :param "
				+ "or en.cidade like :param "
				+ "or en.estado like :param "
				+ "or en.cep like :param "
				+ "or e.site like :param "
				+ "or e.id = :id) "
				+ "order by e."+params.getSort()+" "+params.getOrder(),
				"id",id,
				"param","%"+params.getSearch()+"%");
	}
	
	public List<EventoListDTO> search(BootstrapTableParamsDTO params){
		pageSize = params.getLimit();		
		Long id = -1L;
		try{
			id = Long.parseLong(params.getSearch());
		}catch(Exception e){
		};
		return (List<EventoListDTO>) this.getPageableGenericList(params.getOffset(),"select new br.com.ifg.ifeventos.dto.EventoListDTO(e.id, e.nome, e.local, e.endereco, e.imagem) from Evento e "
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
