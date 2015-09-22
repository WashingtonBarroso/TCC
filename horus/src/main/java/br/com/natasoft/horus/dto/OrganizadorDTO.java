package br.com.natasoft.horus.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import br.com.natasoft.horus.model.entity.Organizador;
import br.com.natasoft.horus.model.entity.TipoOrganizador;

public class OrganizadorDTO {

	@Getter @Setter
	private Organizador organizador;
	@Getter @Setter
	private List<TipoOrganizador> tipos;

	public OrganizadorDTO() {
		this.organizador = new Organizador();
		this.tipos = new ArrayList<TipoOrganizador>();
	}

	public OrganizadorDTO(Organizador organizador, List<TipoOrganizador> tipos) {
		super();
		this.organizador = organizador;
		this.tipos = tipos;
	}
	
}
