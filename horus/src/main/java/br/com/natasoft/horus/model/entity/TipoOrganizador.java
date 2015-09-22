package br.com.natasoft.horus.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbtipo_organizador")
public class TipoOrganizador implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Getter @Setter private Long id;
	@Getter @Setter private String tipo;
	@OneToMany(mappedBy="tipoOrganizador",targetEntity=Organizador.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Getter @Setter private List<Organizador> organizador;	

	public TipoOrganizador() {
	}

	public TipoOrganizador(Long id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	} 

}
