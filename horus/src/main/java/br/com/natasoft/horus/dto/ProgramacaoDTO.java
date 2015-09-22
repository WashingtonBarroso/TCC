package br.com.natasoft.horus.dto;

import lombok.Getter;
import lombok.Setter;
import br.com.natasoft.horus.model.entity.Programacao;

public class ProgramacaoDTO {

	@Getter @Setter
	private Programacao programacao;

	public ProgramacaoDTO() {
		this.programacao = new Programacao();
	} 		
	public ProgramacaoDTO(Programacao programacao) {
		this.programacao = programacao;
	}

}
