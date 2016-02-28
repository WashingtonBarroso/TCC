package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	@Getter @Setter private String titulo;
	@Getter @Setter private String url;
	@ManyToOne
	@JoinColumn(name="programacao_id")
	@Getter @Setter
	private Programacao programacao;
	

	public Palestrante(){

	}

	public Palestrante(Long id, String nome, String resumo, String titulo, String url, Programacao programacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.resumo = resumo;
		this.titulo = titulo;
		this.programacao = programacao;
		this.url = url;
	}

}
