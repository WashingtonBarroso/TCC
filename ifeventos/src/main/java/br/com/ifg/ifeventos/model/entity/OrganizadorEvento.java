package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="tborganizador_evento")
public class OrganizadorEvento extends AbstractEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter private Evento evento;
	@Getter @Setter private Organizador organizador;
	@Getter @Setter private TipoOrganizador tipoOrganizador;
	
	public OrganizadorEvento(){		
	}

	public OrganizadorEvento(Evento evento, Organizador organizador, TipoOrganizador tipoOrganizador) {
		super();
		this.evento = evento;
		this.organizador = organizador;
		this.tipoOrganizador = tipoOrganizador;
	}
}
