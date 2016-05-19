package br.com.ifg.ifeventos.dto;

import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.ifg.ifeventos.model.entity.Evento;
import br.com.ifg.ifeventos.model.entity.Programacao;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import br.com.ifg.ifeventos.model.entity.Organizador;

public class EventoDTO {


	@Getter @Setter	
	private Evento evento;
	@Getter @Setter	
	private UploadedFile imagem;    
	@Getter @Setter 
    private List<Organizador> organizadores; 
	@Getter @Setter
	private List<Programacao> programacoes;
	
	public EventoDTO(){
		this.evento = new Evento();
		this.organizadores = new ArrayList<Organizador>();
	}

	public EventoDTO(Evento evento){
		this.evento = evento;
	}
	
	public EventoDTO(Evento evento, UploadedFile imagem, List<Organizador> organizadores, List<Programacao> programacoes){
		this.evento = evento;
		this.imagem = imagem;
		this.organizadores = organizadores;
		this.programacoes = programacoes;
	}

}
