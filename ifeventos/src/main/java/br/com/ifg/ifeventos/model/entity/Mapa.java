package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbmap")
public class Mapa extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Getter @Setter private Double latitude;
	@Getter @Setter private Double longitude;
	@Getter @Setter private String descricao;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "evento_id")
	@Getter @Setter private Evento evento;

	public Mapa() {
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