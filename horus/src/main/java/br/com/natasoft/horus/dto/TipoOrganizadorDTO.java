package br.com.natasoft.horus.dto;

import lombok.Getter;
import lombok.Setter;
import br.com.natasoft.horus.model.entity.TipoOrganizador;

public class TipoOrganizadorDTO {

	@Getter @Setter
	private TipoOrganizador tipoOrganizador;

	public TipoOrganizadorDTO() {
		this.tipoOrganizador = new TipoOrganizador();
	}

	public TipoOrganizadorDTO(TipoOrganizador tipoOrganizador) {
		this.tipoOrganizador = tipoOrganizador;
	}	

}
