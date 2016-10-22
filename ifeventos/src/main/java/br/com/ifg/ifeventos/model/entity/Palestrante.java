package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity 
@Table(name="tbpalestrante")
public class Palestrante extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Getter @Setter private String nome;	
	@Getter @Setter private String resumo;	
	@Getter @Setter private String titulo;	
	@Getter @Setter private String imagem;	

	public Palestrante(){
		super();
	}

	public Palestrante(Long id, String nome, String resumo, String titulo, String imagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.resumo = resumo;
		this.titulo = titulo;
		this.imagem = imagem;	
	}
}
