package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tborganizacao")
public class Organizacao extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="evento_id")
	@Getter @Setter private Evento evento;
	
	@ManyToOne @JoinColumn(name="organizador_id")
	@Getter @Setter private Organizador organizador;

	public Organizacao() {
		super();
		this.evento = new Evento();
		this.organizador = new Organizador();
	}
	
	public Organizacao(Evento evento, Organizador organizador) {
		super();
		this.evento = evento;
		this.organizador = organizador;
	}
}
