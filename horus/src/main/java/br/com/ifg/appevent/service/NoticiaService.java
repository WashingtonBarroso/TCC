package br.com.ifg.appevent.service;

import java.util.List;

import javax.inject.Inject;

import br.com.ifg.appevent.dto.NoticiaDTO;
import br.com.ifg.appevent.model.dao.impl.NoticiaDAO;
import br.com.ifg.appevent.model.entity.Noticia;

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
	public Noticia editar(Long id){
		return dao.getById(id);
	}
	public void alterar(Noticia noticia){
		dao.save(noticia);
		dao.commit();
	}

}// fim class
