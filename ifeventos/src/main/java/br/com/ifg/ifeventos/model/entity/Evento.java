package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbevento")
public class Evento extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotEmpty 
	@Getter @Setter private String nome; 
 	@Getter @Setter private String local;
	@Getter @Setter private String site;
	@Getter @Setter private String imagem; 
	@ManyToOne @JoinColumn(name="endereco_id")
	@Getter @Setter private Endereco endereco;
	
	
	public Evento(){
		super();
	}

	public Evento(Long id, String nome, String local, String site, String imagem, Endereco endereco, Boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.local = local;
		this.endereco = endereco;
		this.site = site;
		this.imagem =  imagem;
		this.ativo = ativo;
	}

}
