package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbmap")
public class Mapa implements Serializable {

private static final long serialVersionUID = 1L;
	
@Id	
@GeneratedValue 
@Getter @Setter private Long id; 	
@Getter @Setter private Double latitude;
@Getter @Setter private Double longitude;



public Mapa() {
}  

public Mapa(Long id, Double latitude, Double longitude) {
	super();
	this.id = id;
	this.latitude = latitude;
	this.longitude = longitude;
}

}
