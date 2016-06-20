package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tborganizador")
public class Organizador extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter @Setter private String nome;	
	//@Getter @Setter private String imagem;	
	@Getter @Setter private String cargo;
	@Getter @Setter private String area;
	@Getter @Setter private String url;

	public Organizador() {
	}

	public Organizador(String nome, String cargo, String area, String url) {
		super();
		this.nome = nome;
		//this.imagem = imagem;
		this.cargo = cargo;
		this.area = area;
		this.url = url;
	}
}
