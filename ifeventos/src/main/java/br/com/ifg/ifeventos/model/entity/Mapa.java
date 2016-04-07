package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

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
	@ManyToOne @JoinColumn(name="evento_id")
	@Getter @Setter private Evento evento;

	public Mapa() {
	}  

	public Mapa(Long id, Double latitude, Double longitude, Evento evento) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.evento = evento;
	}
}