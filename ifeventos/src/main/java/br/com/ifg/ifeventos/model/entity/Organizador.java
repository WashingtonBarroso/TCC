package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tborganizador")
public class Organizador extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter @Setter private String nome;	
	@Getter @Setter private String cargo;
	@Getter @Setter private String area;
	@Getter @Setter private String url;
	@ManyToOne @JoinColumn(name="tipo_organizador_id")
	@Getter @Setter private TipoOrganizador tipoOrganizador;
	
	public Organizador() {
	}
	public Organizador(Long id, String nome, String cargo, String area,
			TipoOrganizador tipoOrganizador, String url) {
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.area = area;
		this.tipoOrganizador = tipoOrganizador;
		this.url = url;
	}
}
