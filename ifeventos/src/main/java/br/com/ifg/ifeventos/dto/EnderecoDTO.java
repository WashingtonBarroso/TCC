package br.com.ifg.ifeventos.dto;

import br.com.ifg.ifeventos.model.entity.Endereco;
import lombok.Getter;
import lombok.Setter;

public class EnderecoDTO {
     
	@Getter @Setter private Endereco endereco;

	public EnderecoDTO(){
	   this.endereco = new Endereco();	
	}
	
	public EnderecoDTO(Endereco endereco) {
		super();
		this.endereco = endereco;
	}

}
