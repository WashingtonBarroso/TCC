package br.com.natasoft.horus.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;


import lombok.Getter;
import lombok.Setter;


@Entity 
@Table(name="tbpalestrante")
public class Palestrante implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Getter @Setter private Long id; 
	@Getter @Setter private String nome;	
	@Getter @Setter private String resumo;	
	@Getter @Setter private  String titulo;


	public Palestrante(){

	}

	public Palestrante(Long id, String nome, String resumo, String titulo) {
		super();
		this.id = id;
		this.nome = nome;
		this.resumo = resumo;
		this.titulo = titulo;
	}

}
