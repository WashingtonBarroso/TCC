package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="tborganizador_evento")
public class OrganizadorEvento extends AbstractEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@Getter @Setter private Evento evento;
	
	@OneToOne
	@JoinColumn(name="organizador_id")
	@Getter @Setter private Organizador organizador;
	
	@OneToOne
	@JoinColumn(name="tipoOrganizador_id")
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
