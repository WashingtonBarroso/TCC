package br.com.natasoft.horus.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Getter @Setter private Date data;
	@Temporal(TemporalType.TIME)
	@Getter @Setter private Date hora;
	@Getter @Setter private String local;
	@ManyToOne
	@JoinColumn(name="tp_programacao_id")
	@Getter @Setter private TipoProgramacao tipoProgramacao;

	public Programacao() {
		super();
	}

	public Programacao(Long id, Date data, Date hora, String local,
			TipoProgramacao tipoProgramacao) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.local = local;
		this.tipoProgramacao = tipoProgramacao;
	}
	
}
