package br.com.ifg.ifeventos.dto;

import lombok.Getter;
import lombok.Setter;
import br.com.ifg.ifeventos.model.entity.TipoProgramacao;

public class TipoProgramacaoDTO {
    
	
	@Getter @Setter private TipoProgramacao tipoPalestra;

	public TipoProgramacaoDTO() {
		this.tipoPalestra = new TipoProgramacao();
	}

	public TipoProgramacaoDTO(TipoProgramacao tipoPalestra) {
		this.tipoPalestra = tipoPalestra;
	}	



}
