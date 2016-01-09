package br.com.ifg.ifeventos.dto;

import lombok.Getter;
import lombok.Setter;
import br.com.ifg.ifeventos.model.entity.Noticia;

public class NoticiaDTO {

	@Getter @Setter private Noticia noticia;	

	public NoticiaDTO() {	
		this.noticia = new Noticia();
	}
	public NoticiaDTO(Noticia noticia) {
		this.noticia = noticia;
	}

}
