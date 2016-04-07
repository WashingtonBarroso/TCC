package br.com.ifg.ifeventos.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class DatatableDTO<T> {
	
	@Getter @Setter Integer recordsTotal; 
	@Getter @Setter Integer recordsFiltered; 
	@Getter @Setter List<T> data;
	
	public DatatableDTO(){
		this.recordsTotal = 0;
		this.recordsFiltered = 0;
		this.data = new ArrayList<T>();
	}
	
	public DatatableDTO(Integer recordsTotal, Integer recordsFiltered, List<T> data){
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}
}