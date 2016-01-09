package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbgenero")
public class Genero implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Getter @Setter private Long id;
	@NotEmpty
	@Getter @Setter private String nome;
	
	public Genero(){		
	}

	public Genero(Long id, String nome){
		this.id = id;
		this.nome = nome;
	}
}
