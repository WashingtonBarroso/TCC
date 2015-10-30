package br.com.ifg.dame.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tbpessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    @Getter @Setter protected Long id; 
    @Column(nullable = false)
    @Getter @Setter protected Boolean ativo;	
	@NotEmpty(message="O nome não pode ser vazio.")
	@Getter @Setter private String nome;
//	@ManyToOne @JoinColumn(name = "endereco_id")
//	@Getter @Setter private Endereco endereco;
//	@OneToMany(mappedBy = "pessoa", targetEntity = Contato.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@Getter @Setter private List<Contato> contatos;
//	@Getter @Setter private String observacao;
	
	public Pessoa(){	
		super();
//		this.endereco = new Endereco();
//		this.contatos = new ArrayList<Contato>();
		this.ativo = true;
	}
}