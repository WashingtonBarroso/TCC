package br.com.ifg.ifeventos.service;

import java.util.List;

import javax.inject.Inject;

import br.com.ifg.ifeventos.dto.MapaDTO;
import br.com.ifg.ifeventos.model.dao.impl.MapaDAO;
import br.com.ifg.ifeventos.model.entity.Mapa;

public class MapaService {

	@Inject
	private MapaDAO dao;

	public MapaDTO loadForm(){
		return new MapaDTO(new Mapa());
	}


	public MapaDTO load(MapaDTO dto){
		return new MapaDTO(dao.getById(dto.getMapa().getId()));
	}


	public MapaDTO save(MapaDTO dto){
		dao.save(dto.getMapa());
		dao.commit();
		return dto;
	}


	public MapaDTO delete(MapaDTO dto){
		dao.remove(dto.getMapa());
		dao.commit();
		return dto;
	}


	public List<Mapa> list(){
		return dao.getAll();
	}


	public void deleteById(Long id){
		dao.removeById(id);
		dao.commit();
	}


}
