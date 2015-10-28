package br.com.ifg.appevent.dto;

import lombok.Getter;
import lombok.Setter;
import br.com.ifg.appevent.model.entity.Palestrante;

public class PalestranteDTO{

	@Getter @Setter
	private Palestrante palestrante; 

	public PalestranteDTO(){
		this.palestrante = new Palestrante();
	}
	public PalestranteDTO(Palestrante palestrante){
		this.palestrante = palestrante;
	}

}
