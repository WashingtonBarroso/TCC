package br.com.ifg.appevent.dto;

import br.com.ifg.appevent.model.entity.Evento;
import lombok.Getter;
import lombok.Setter;

public class EventoDTO {


	@Getter @Setter	
	private Evento evento;

	public EventoDTO(){
		this.evento = new Evento();
	}

	public EventoDTO(Evento evento){
		this.evento = evento;
	}

}
