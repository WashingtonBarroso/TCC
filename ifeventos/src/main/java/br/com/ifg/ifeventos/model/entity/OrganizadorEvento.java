package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="tborganizador_evento")
public class OrganizadorEvento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name="evento_id")
	@Getter @Setter private Evento evento;
	
	@Id
	@ManyToOne
	@JoinColumn(name="organizador_id")
	@Getter @Setter private Organizador organizador;
	
	@Id
	@ManyToOne
	@JoinColumn(name="tipo_organizador_id")
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
