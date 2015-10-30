package br.com.ifg.dame.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    @Getter @Setter protected Long id;
 
    @Column(nullable = false)
    @Getter @Setter protected Boolean ativo;
    
    protected AbstractEntity(){
    	ativo = true;
    }
}
