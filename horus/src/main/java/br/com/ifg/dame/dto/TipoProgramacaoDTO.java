package br.com.ifg.dame.dto;

import lombok.Getter;
import lombok.Setter;
import br.com.ifg.dame.model.entity.TipoProgramacao;

public class TipoProgramacaoDTO {
    
	
	@Getter @Setter private TipoProgramacao tipoProgramacao;

	public TipoProgramacaoDTO() {
		this.tipoProgramacao = new TipoProgramacao();
	}

	public TipoProgramacaoDTO(TipoProgramacao tipoProgramacao) {
		this.tipoProgramacao = tipoProgramacao;
	}	



}
