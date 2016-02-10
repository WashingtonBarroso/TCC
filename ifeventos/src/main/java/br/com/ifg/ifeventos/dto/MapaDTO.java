package br.com.ifg.ifeventos.dto;

import lombok.Getter;
import lombok.Setter;
import br.com.ifg.ifeventos.model.entity.Mapa;

public class MapaDTO {

	@Getter @Setter
	private Mapa mapa;
	
	public MapaDTO(){
		this.mapa = new Mapa();
	}
	
	public MapaDTO(Mapa mapa){
		this.mapa = mapa;
	}
	
}
