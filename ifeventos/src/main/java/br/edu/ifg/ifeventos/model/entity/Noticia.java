package br.edu.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbnoticia")
public class Noticia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Getter @Setter private Long id;
	@Getter @Setter private String mensagem;

	public Noticia() {
	}

	public Noticia(Long id, String mensagem) {
		super();
		this.id = id;
		this.mensagem = mensagem;
	} 	

}
