package br.com.natasoft.horus.service;

import java.util.List;

import javax.inject.Inject;

import br.com.natasoft.horus.dto.EventoDTO;
import br.com.natasoft.horus.model.dao.impl.EventoDAO;
import br.com.natasoft.horus.model.entity.Evento;

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

	public EventoDTO delete(EventoDTO dto){
		dao.remove(dto.getEvento());
		dao.commit();
		return dto;
	}

	public List<Evento> listar(){
		return dao.getAll();
	}
}

