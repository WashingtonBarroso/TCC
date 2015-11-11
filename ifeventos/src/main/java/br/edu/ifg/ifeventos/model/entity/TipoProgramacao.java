package br.edu.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbtipo_programacao")
public class TipoProgramacao implements Serializable {

	private static final long serialVersionUID = 1L;
    
	@Id
    @GeneratedValue
	@Getter @Setter private Long id;	
	@Getter @Setter private String tipo;
	public TipoProgramacao() {
	}
	public TipoProgramacao(Long id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}
}
