package br.com.ifg.ifeventos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ServiceEventoMenuDTO <T> implements Serializable {

	private static final long serialVersionUID = 1L;
    
	 @Getter @Setter private List<T> rows; 
	 
	 public ServiceEventoMenuDTO(){	
		 this.rows =  new ArrayList<T>();
	 }
	
	 public ServiceEventoMenuDTO(List<T> rows){
		 super();
		 this.rows = rows;
	 }
	 
}
