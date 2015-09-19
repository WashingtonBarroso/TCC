package br.com.natasoft.horus.dto;

import lombok.Getter;
import lombok.Setter;
import br.com.natasoft.horus.model.entity.Organizador;

public class OrganizadorDTO {

	@Getter @Setter
	private Organizador organizador;

	public OrganizadorDTO() {
		this.organizador = new Organizador();
	}
	public OrganizadorDTO(Organizador organizador) {
		this.organizador = organizador;
	}

}
