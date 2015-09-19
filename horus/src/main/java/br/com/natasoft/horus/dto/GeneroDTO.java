package br.com.natasoft.horus.dto;

import lombok.Getter;
import lombok.Setter;
import br.com.natasoft.horus.model.entity.Genero;

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
