package br.com.ifg.ifeventos.dto;

import lombok.Getter;
import lombok.Setter;

public class GenericDTO<T> {
	
	@Getter @Setter T dto;
	@Getter @Setter String message;
	
	public GenericDTO() {
		message = "";
	}
	
	public GenericDTO(T dto, String message) {
		super();
		this.dto = dto;
		this.message = message;
	}
}
