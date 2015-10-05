package br.com.natasoft.horus.service;

import java.util.List;

import javax.inject.Inject;

import br.com.natasoft.horus.dto.NoticiaDTO;
import br.com.natasoft.horus.model.dao.impl.NoticiaDAO;
import br.com.natasoft.horus.model.entity.Noticia;

public class NoticiaService {

	@Inject	
	private NoticiaDAO dao;	

	public NoticiaDTO loadForm(){
		return new NoticiaDTO(new Noticia(null, ""));
	}	

	public NoticiaDTO load(NoticiaDTO dto){
		return new NoticiaDTO(dao.getById(dto.getNoticia().getId()));
	}

	public NoticiaDTO save(NoticiaDTO dto){
		dao.save(dto.getNoticia());
		dao.commit();
		return dto;
	}

	public NoticiaDTO delete(NoticiaDTO dto){
		dao.remove(dto.getNoticia());
		dao.commit();
		return dto;
	}
	public List<Noticia> listar(){
		return dao.getAll();
	}

	public void deleteById(Long id) {
	   dao.removeById(id);
	   dao.commit();		
	}
	public void modificarBy(Long id){
		
		
	}
		
}// fim class
