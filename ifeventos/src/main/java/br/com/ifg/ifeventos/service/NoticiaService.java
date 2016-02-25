package br.com.ifg.ifeventos.service;

import java.util.List;

import javax.inject.Inject;

import br.com.ifg.ifeventos.dto.NoticiaDTO;
import br.com.ifg.ifeventos.model.dao.impl.NoticiaDAO;
import br.com.ifg.ifeventos.model.entity.Noticia;

public class NoticiaService {

	@Inject	
	private NoticiaDAO dao;	

	public NoticiaDTO loadForm(){
		return new NoticiaDTO(new Noticia(null, "", null));
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
	
	
	public List<Noticia> list(){
		return dao.getAll();
	}
	
	
	public void deleteById(Long id) {
		dao.removeById(id);
		dao.commit();		
	}
	

}// fim class
