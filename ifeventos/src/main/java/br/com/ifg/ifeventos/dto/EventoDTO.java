package br.com.ifg.ifeventos.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import br.com.ifg.ifeventos.model.entity.Evento;
import br.com.ifg.ifeventos.model.entity.TipoOrganizador;
import br.com.ifg.ifeventos.model.entity.TipoProgramacao;

public class EventoDTO {


	@Getter @Setter	
	private Evento evento;    
	@Getter @Setter 
    private List<TipoOrganizador> tiposOrganizador; 
	@Getter @Setter
	private List<TipoProgramacao> tiposProgramacao;
	
	
	public EventoDTO(){
		this.evento = new Evento();
		this.tiposOrganizador = new ArrayList<TipoOrganizador>();
		this.tiposProgramacao = new ArrayList<TipoProgramacao>();
	}

	public EventoDTO(Evento evento){
		this.evento = evento;
		this.tiposOrganizador = new ArrayList<TipoOrganizador>();
		this.tiposProgramacao = new ArrayList<TipoProgramacao>();
	}
	
	public EventoDTO(Evento evento, List<TipoOrganizador> tiposOrganizador, List<TipoProgramacao> tiposProgramacao){
		this.evento = evento;
		this.tiposOrganizador = tiposOrganizador;
		this.tiposProgramacao = tiposProgramacao;
	}

}
