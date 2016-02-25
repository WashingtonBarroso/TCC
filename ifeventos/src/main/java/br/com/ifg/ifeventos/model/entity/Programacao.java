package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.hibernate.annotations.Type;

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
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Getter @Setter private LocalDate data;
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalTime")
	@Getter @Setter private LocalTime hora;
	@Getter @Setter private String local;
	@ManyToOne
	@JoinColumn(name="tp_programacao_id")
	@Getter @Setter private TipoProgramacao tipoProgramacao;
	@ManyToOne
	@JoinColumn(name="evento_id")
	@Getter @Setter
	private Evento evento;
	
	public Programacao() {
		super();
	}

	public Programacao(Long id, LocalDate data, LocalTime hora, String local,
			TipoProgramacao tipoProgramacao) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.local = local;
		this.tipoProgramacao = tipoProgramacao;
	}

}
