package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbprogramacao")
public class Programacao extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L; 
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Getter @Setter private LocalDate data;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalTime")
	@Getter @Setter private LocalTime hora;	
	
	@Getter @Setter private String descricao;
	@Getter @Setter private String local;
	
	@ManyToOne
	@JoinColumn(name="tp_programacao_id")
	@Getter @Setter private TipoProgramacao tipoProgramacao;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@Getter @Setter private Evento evento;
	
	@ManyToOne @JoinColumn(name="palestrante_id")
	@Getter @Setter private Palestrante palestrante;
	
	
	public Programacao() {
		super();
	}

	public Programacao(Long id, LocalDate data, LocalTime hora, String local,
			TipoProgramacao tipoProgramacao, Palestrante palestrante, Evento evento) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.local = local;
		this.tipoProgramacao = tipoProgramacao;
		this.palestrante = palestrante;
		this.evento = evento;
	}

}


