package br.com.ifg.ifeventos.dto;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.ifg.ifeventos.model.entity.Evento;
import lombok.Getter;
import lombok.Setter;

public class EventoDTO {


	@Getter @Setter	
	private Evento evento;
	@Getter @Setter	
	private UploadedFile imagem;

	public EventoDTO(){
		this.evento = new Evento();
	}

	public EventoDTO(Evento evento){
		this.evento = evento;
	}
	
	public EventoDTO(Evento evento, UploadedFile imagem){
		this.evento = evento;
		this.imagem = imagem;
	}

}
