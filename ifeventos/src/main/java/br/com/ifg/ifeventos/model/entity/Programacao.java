package br.com.ifg.ifeventos.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.caelum.vraptor.serialization.SkipSerialization;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbprogramacao")
public class Programacao extends AbstractEntity{

	private static final long serialVersionUID = 1L; 
	//@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	//@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalTime")
	
	@Getter @Setter private String data;	
	@Getter @Setter private String descricao;	
	@Getter @Setter private String local;
	@ManyToOne @JoinColumn(name="tipo_programacao_id")
	@Getter @Setter private TipoProgramacao tipoProgramacao;
	@SkipSerialization
	@ManyToOne @JoinColumn(name = "evento_id")
	@Getter @Setter private Evento evento;
	
	
	@ManyToOne @JoinColumn(name="palestrante_id")
	@Getter @Setter private Palestrante palestrante;
	
	
	public Programacao() {
		super();
	}

	public Programacao(Long id, String data, String local,
			TipoProgramacao tipoProgramacao, Palestrante palestrante, Evento evento) {
		super();
		this.id = id;
		this.data = data;
		this.local = local;
		this.tipoProgramacao = tipoProgramacao;
		this.palestrante = palestrante;
		this.evento = evento;
	}

}


