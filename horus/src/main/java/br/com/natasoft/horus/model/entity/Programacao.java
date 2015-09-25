package br.com.natasoft.horus.model.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbprogramacao")
public class Programacao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	@Id	
	@GeneratedValue
	@Getter @Setter private Long id;	
	@Temporal(TemporalType.DATE)
	@Getter @Setter private Calendar data;
	@Temporal(TemporalType.TIME)
	@Getter @Setter private Calendar hora;
	@Getter @Setter private String local;

	public Programacao() {
		super();
	}

	public Programacao(Long id, Calendar data, Calendar hora,
			String local) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.local = local;
	}
}
