package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbnoticia")
public class Noticia extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter @Setter private String mensagem;
	
	@ManyToOne @JoinColumn(name="evento_id")
	@Getter @Setter private Evento evento;
	
	public Noticia() {
	}

	public Noticia(Long id, String mensagem, Evento evento) {
		super();
		this.id = id;
		this.mensagem = mensagem;
		this.evento = evento;
	} 	

}
