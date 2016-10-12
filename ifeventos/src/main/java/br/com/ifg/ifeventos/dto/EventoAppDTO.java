package br.com.ifg.ifeventos.dto;

import lombok.Getter;
import lombok.Setter;
import br.com.ifg.ifeventos.model.entity.Endereco;

public class EventoAppDTO {
	
	@Getter @Setter private Long id ; 
	@Getter @Setter private String nome;
	@Getter @Setter private String dataInicio;
 	@Getter @Setter private String dataFim;
 	@Getter @Setter private String local;
 	@Getter @Setter private String site;
 	@Getter @Setter private Endereco endereco;
	@Getter @Setter private String imagem;
	
	
	public EventoAppDTO(){	
	}
	
	public EventoAppDTO(Long id, String nome, String dataInicio, String dataFim, String local, String site,
			Endereco endereco, String imagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.local = local;
		this.site = site;
		this.endereco = endereco;
		this.imagem = imagem;
	} 
	
	
}
