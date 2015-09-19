package br.com.natasoft.horus.service;

import java.util.List;

import javax.inject.Inject;

import br.com.natasoft.horus.dto.GeneroDTO;
import br.com.natasoft.horus.model.dao.impl.GeneroDAO;
import br.com.natasoft.horus.model.entity.Genero;

public class GeneroService {

	@Inject
	private GeneroDAO dao;

	public GeneroDTO loadForm(){
		//simula��o
		return new GeneroDTO(new Genero(null, "Siclano"));
	}

	public GeneroDTO load(GeneroDTO dto){
		return new GeneroDTO(dao.getById(dto.getGenero().getId()));
	}

	public GeneroDTO save(GeneroDTO dto){
		dao.save(dto.getGenero());
		dao.commit();
		return dto;
	}

	public GeneroDTO delete(GeneroDTO dto){
		dao.remove(dto.getGenero());
		dao.commit();
		return dto;
	}
	
	public List<Genero> listar(){
		return dao.getAll();
 	}

}