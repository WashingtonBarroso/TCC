package br.com.ifg.ifeventos.dto;

import lombok.Getter;
import lombok.Setter;

public class Id {	
	@Getter @Setter private Long id;
	
	public Id() {
		this.id = null;		
	}
	public Id(Long id) {
		this.id = id;
	}		
}
