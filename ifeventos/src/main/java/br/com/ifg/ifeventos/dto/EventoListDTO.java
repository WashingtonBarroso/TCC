package br.com.ifg.ifeventos.dto;

import br.com.ifg.ifeventos.model.entity.Endereco;
import lombok.Getter;
import lombok.Setter;

public class EventoListDTO {
	
	@Getter @Setter private Long id ; 
	@Getter @Setter private String nome;
	@Getter @Setter private String dataInicio;
 	@Getter @Setter private String dataFim;
 	@Getter @Setter private String local;
 	@Getter @Setter private Endereco endereco;
	@Getter @Setter private String imagem; 
	
	public EventoListDTO(){		
	}
	
	public EventoListDTO(Long id, String nome, String dataInicio, String dataFim, String local, Endereco endereco,
			String imagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.local = local;
		this.endereco = endereco;
		this.imagem = imagem;
	}
	
	
}
