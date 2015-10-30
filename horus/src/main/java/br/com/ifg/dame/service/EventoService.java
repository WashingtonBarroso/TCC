package br.com.ifg.dame.service;

import java.util.List;

import javax.inject.Inject;

import br.com.ifg.dame.dto.EventoDTO;
import br.com.ifg.dame.model.dao.impl.EventoDAO;
import br.com.ifg.dame.model.entity.Evento;

public class EventoService {

	@Inject
	private EventoDAO dao;

	public EventoDTO loadForm(){
		return new EventoDTO(new Evento(null, "", "", "", "", "")); 
	}

	public EventoDTO load(EventoDTO dto){
		return new EventoDTO(dao.getById(dto.getEvento().getId())); 
	}	

	public EventoDTO save(EventoDTO dto){
		dao.save(dto.getEvento());
		dao.commit();
		return dto;
	}
	
	public void alterar(EventoDTO dto){
		dao.save(dto.getEvento());
		dao.commit();
	}
	
	public void deleteById(Long id){ 
		dao.removeById(id);
		dao.commit();
	}

	public void delete(EventoDTO dto){ 
		dao.remove(dto.getEvento());
		dao.commit();
	}

	public List<Evento> listar(){
		return dao.getAll();
	}
}

