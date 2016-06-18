package br.com.ifg.ifeventos.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbevento")
public class Evento extends AbstractEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotEmpty 
	@Getter @Setter private String nome; 
 	@Getter @Setter private String local;
	@Getter @Setter private String site;
	//@Getter @Setter private String imagem; 
	
	@ManyToOne @JoinColumn(name="endereco_id")
	@Getter @Setter private Endereco endereco;
	
	//@ManyToMany
	//@JoinTable(name="tb_evento_has_organizador", 
	//joinColumns={@JoinColumn(name="evento_id")}, 
	//inverseJoinColumns={@JoinColumn(name="organizador_id")})
	//@Getter @Setter private List<Organizador> organizadores;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER) 
	@JoinColumn(name="organizador_evento_id")
	@Getter @Setter private List<OrganizadorEvento> organizadores;	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER) 
	@JoinColumn(name="evento_id")
	@Getter @Setter private List<Programacao> programacao;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="evento_id")
	@Getter @Setter private List<Mapa> mapa;
	
	public Evento(){
		super();
	}

	public Evento(Long id, String nome, String local, String site, Endereco endereco, List<Programacao> programacao, List<OrganizadorEvento> organizadores, List<Mapa> mapa, Boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.local = local;
		this.endereco = endereco;
		this.site = site;
		this.ativo = ativo;
		this.programacao = programacao;
		this.organizadores = organizadores;
		this.mapa = mapa;
	}

}
