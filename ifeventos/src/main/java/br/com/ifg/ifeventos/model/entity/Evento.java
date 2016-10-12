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
 	@Getter @Setter private String dataInicio;
 	@Getter @Setter private String dataFim;
 	@Getter @Setter private String site;
	@Getter @Setter private String imagem;
	@ManyToOne @JoinColumn(name="endereco_id")
	@Getter @Setter private Endereco endereco;	
	@OneToMany(mappedBy = "evento", targetEntity = OrganizadorEvento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL,  orphanRemoval=true)
	@Getter @Setter private List<OrganizadorEvento> organizadores;
	@OneToMany(mappedBy = "evento", targetEntity = Programacao.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL,  orphanRemoval=true)
	@Getter @Setter private List<Programacao> programacao;
	@OneToMany(mappedBy = "evento", targetEntity = Mapa.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL,  orphanRemoval=true)
	@Getter @Setter private List<Mapa> mapas;
	
	public Evento(){
		super();
	}

	public Evento(Long id, String dataInicio, String dataFim, String nome, String local, String site, Endereco endereco, List<Programacao> programacao, List<OrganizadorEvento> organizadores, List<Mapa> mapas, Boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.local = local;
		this.endereco = endereco;
		this.site = site;
		this.ativo = ativo;
		this.programacao = programacao;
		this.organizadores = organizadores;
		this.mapas = mapas;
	}

}
