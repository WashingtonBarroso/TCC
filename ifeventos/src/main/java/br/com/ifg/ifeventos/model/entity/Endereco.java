package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbendereco")
public class Endereco extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Getter @Setter private String cep;
	@Getter @Setter private String logradouro;
 	@Getter @Setter private String complemento;
 	@Getter @Setter private String bairro; 
 	@Getter @Setter private String cidade; 
 	@Getter @Setter private String estado;
	
 	public Endereco() { 	
 		super();
 	}
 	
 	public Endereco(String cep, String logradouro, String complemento, String bairro, String cidade, String estado) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
}
