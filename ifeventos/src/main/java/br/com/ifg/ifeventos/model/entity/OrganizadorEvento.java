<<<<<<< HEAD
package br.com.ifg.ifeventos.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.caelum.vraptor.serialization.SkipSerialization;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="tborganizador_evento")
public class OrganizadorEvento extends AbstractEntity{
	private static final long serialVersionUID = 1L;	
	
	@SkipSerialization
	@ManyToOne @JoinColumn(name="evento_id")
	@Getter @Setter private Evento evento;
	
	
	@ManyToOne @JoinColumn(name="organizador_id")
	@Getter @Setter private Organizador organizador;
	
	
	@ManyToOne @JoinColumn(name="tipo_organizador_id")
	@Getter @Setter private TipoOrganizador tipoOrganizador;
	
	public OrganizadorEvento(){	
		super();
	}

	public OrganizadorEvento(Evento evento, Organizador organizador, TipoOrganizador tipoOrganizador) {
		super();
		this.evento = evento;
		this.organizador = organizador;
		this.tipoOrganizador = tipoOrganizador;
	}
}
=======
package br.com.ifg.ifeventos.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.caelum.vraptor.serialization.SkipSerialization;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="tborganizador_evento")
public class OrganizadorEvento extends AbstractEntity{
	private static final long serialVersionUID = 1L;	
	
	@SkipSerialization
	@ManyToOne @JoinColumn(name="evento_id")
	@Getter @Setter private Evento evento;
	
	
	@ManyToOne @JoinColumn(name="organizador_id")
	@Getter @Setter private Organizador organizador;
	
	
	@ManyToOne @JoinColumn(name="tipo_organizador_id")
	@Getter @Setter private TipoOrganizador tipoOrganizador;
	
	public OrganizadorEvento(){	
		super();
	}

	public OrganizadorEvento(Evento evento, Organizador organizador, TipoOrganizador tipoOrganizador) {
		super();
		this.evento = evento;
		this.organizador = organizador;
		this.tipoOrganizador = tipoOrganizador;
	}
}
>>>>>>> refs/remotes/origin/master
