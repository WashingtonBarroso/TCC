package br.com.ifg.dame.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="tbevento")
public class Evento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Getter @Setter private Long id;
	@NotEmpty 
	@Getter @Setter private String nome; 
 	@Getter @Setter private String local; 
	@Getter @Setter private String cidade; 
	@Getter @Setter private String estado; 
	@Getter @Setter private String site; 

	public Evento(){

	}

	public Evento(Long id, String nome, String local, String cidade,
			String estado, String site) {
		super();
		this.id = id;
		this.nome = nome;
		this.local = local;
		this.cidade = cidade;
		this.estado = estado;
		this.site = site;
	}

}
