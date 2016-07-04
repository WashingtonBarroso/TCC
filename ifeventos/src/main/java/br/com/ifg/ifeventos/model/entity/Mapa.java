package br.com.ifg.ifeventos.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.caelum.vraptor.serialization.SkipSerialization;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbmapa")
public class Mapa extends AbstractEntity{

	private static final long serialVersionUID = 1L;	
	@Getter @Setter private Double latitude;	
	@Getter @Setter private Double longitude;
	@Getter @Setter private String descricao;
	@SkipSerialization
	@ManyToOne @JoinColumn(name = "evento_id")
	@Getter @Setter private Evento evento;

	public Mapa() {
		super();
	}  

	public Mapa(Long id, Double latitude, Double longitude, String descricao, Evento evento) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.descricao = descricao;
		this.evento = evento;
	}
}