package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbtipo_organizador")
public class TipoOrganizador extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(unique=true)
	@Getter @Setter private String descricao;	

	public TipoOrganizador() {
		super();
	}

	public TipoOrganizador(String descricao) {
		super();
		this.descricao = descricao;
	} 

}
