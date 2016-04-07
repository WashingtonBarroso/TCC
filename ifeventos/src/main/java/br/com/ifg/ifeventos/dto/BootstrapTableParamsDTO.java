package br.com.ifg.ifeventos.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class BootstrapTableParamsDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Getter @Setter private String search = "";	
	@Getter @Setter private String sort = "id";
	@Getter @Setter private String order = "";
	@Getter @Setter private Integer limit = 0;
	@Getter @Setter private Integer offset = 0;
	
	public BootstrapTableParamsDTO(String search, String sort, String order, Integer limit, Integer offset) {
		super();
		if (search != null)
			this.search = search;
		if (sort != null)
			this.sort = sort;
		if (order != null)
			this.order = order;
		if (limit != null)
			this.limit = limit;
		if (offset != null)
			this.offset = offset;
	}
}
