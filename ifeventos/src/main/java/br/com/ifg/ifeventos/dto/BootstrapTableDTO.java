package br.com.ifg.ifeventos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class BootstrapTableDTO<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	private Long total;
	@Getter @Setter
	private List<T> rows;
	
	public BootstrapTableDTO(){
		total = 0L;
		rows = new ArrayList<T>();
	}

	public BootstrapTableDTO(Long total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
}
