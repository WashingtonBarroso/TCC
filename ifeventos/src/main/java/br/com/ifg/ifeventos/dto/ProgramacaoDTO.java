package br.com.ifg.ifeventos.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import br.com.ifg.ifeventos.model.entity.Programacao;
import br.com.ifg.ifeventos.model.entity.TipoProgramacao;


public class ProgramacaoDTO {

	@Getter @Setter
	private Programacao programacao;
	@Getter @Setter 
	private List<TipoProgramacao> tipoProgramacao;

	public ProgramacaoDTO() {
		this.programacao = new Programacao();
		this.tipoProgramacao = new ArrayList<TipoProgramacao>();
	}

	
	public ProgramacaoDTO(Programacao Programacao, List<TipoProgramacao> tipoProgramacao) {
		this.programacao = Programacao;
		this.tipoProgramacao = tipoProgramacao;
	} 		

}
