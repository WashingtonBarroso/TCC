package br.com.ifg.ifeventos.dto;

import lombok.Getter;
import lombok.Setter;
import br.com.ifg.ifeventos.model.entity.Genero;

public class GeneroDTO {

	@Getter @Setter
	private Genero genero;
	
	public GeneroDTO(){
		this.genero = new Genero();
	}
	
	public GeneroDTO(Genero genero){
		this.genero = genero;
	}
	
}
