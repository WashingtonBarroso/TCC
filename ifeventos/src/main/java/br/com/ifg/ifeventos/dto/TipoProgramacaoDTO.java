package br.com.ifg.ifeventos.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import br.com.ifg.ifeventos.model.entity.TipoProgramacao;

public class TipoProgramacaoDTO implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Getter @Setter private TipoProgramacao tipoProgramacao;
    
	public TipoProgramacaoDTO() {
		super();
		this.tipoProgramacao = new TipoProgramacao();
	}

	public TipoProgramacaoDTO(TipoProgramacao tipoProgramacao) {
		this.tipoProgramacao = tipoProgramacao;
	}	

}
