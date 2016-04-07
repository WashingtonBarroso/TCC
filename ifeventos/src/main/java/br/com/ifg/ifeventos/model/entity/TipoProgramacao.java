package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbtipo_programacao")
public class TipoProgramacao extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter private String descricao;
	public TipoProgramacao() {
	}
	public TipoProgramacao(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
}
