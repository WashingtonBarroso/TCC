package br.edu.ifg.ifeventos.service;

import java.util.List;

import javax.inject.Inject;

import br.edu.ifg.ifeventos.dto.PalestranteDTO;
import br.edu.ifg.ifeventos.model.dao.impl.PalestranteDAO;
import br.edu.ifg.ifeventos.model.entity.Palestrante;

public class PalestranteService {

	@Inject
	private PalestranteDAO dao;

	public PalestranteDTO loadForm(){
		return new PalestranteDTO(new Palestrante(null, "", "", ""));
	}
	public PalestranteDTO load(PalestranteDTO dto){
		return new PalestranteDTO(dao.getById(dto.getPalestrante().getId()));
	}

	public PalestranteDTO save(PalestranteDTO dto){
		dao.save(dto.getPalestrante());
		dao.commit();
		return dto;
	}

	public PalestranteDTO delete(PalestranteDTO dto){
		dao.remove(dto.getPalestrante());
		dao.commit();
		return dto;
	}

	public List<Palestrante> listar(){
		return dao.getAll();
	}
	public void deleteById(Long id) {
		dao.removeById(id);
		dao.commit();
	}

}
