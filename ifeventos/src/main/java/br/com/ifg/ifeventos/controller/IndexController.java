package br.com.ifg.ifeventos.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.ifg.ifeventos.model.dao.impl.EventoDAO;
import br.com.ifg.ifeventos.model.dao.impl.OrganizadorDAO;
import br.com.ifg.ifeventos.model.dao.impl.PalestranteDAO;
import br.com.ifg.ifeventos.model.dao.impl.TipoOrganizadorDAO;
import br.com.ifg.ifeventos.model.dao.impl.TipoProgramacaoDAO;
import br.com.ifg.ifeventos.model.entity.Organizador;
import br.com.ifg.ifeventos.model.entity.Palestrante;
import br.com.ifg.ifeventos.model.entity.TipoOrganizador;
import br.com.ifg.ifeventos.model.entity.TipoProgramacao;

@Controller
public class IndexController {

	@Inject 
	private EventoDAO eventoDao;
	
	@Inject 
	private TipoProgramacaoDAO tipoProgramacaoDao;
	
	@Inject 
	private TipoOrganizadorDAO tipoOrganizadorDao;
	
	@Inject 
	private PalestranteDAO palestranteDao;
	
	@Inject 
	private OrganizadorDAO organizadorDao;
	
	private final Result result;

	/**
	 * @deprecated CDI eyes only
	 */
	protected IndexController() {
		this(null);
	}

	@Inject
	public IndexController(Result result) {
		this.result = result;
	}

	@Path("/")
	public void index() {
	}
	
	@Path("/clear")
	public void clear() {
		eventoDao.deleteAll();
		tipoProgramacaoDao.deleteAll();
		tipoOrganizadorDao.deleteAll();
		palestranteDao.deleteAll();
		organizadorDao.deleteAll();;
	}
	
	@Path("/init")
	public void init() {
		if (tipoOrganizadorDao.getAll().size() == 0){
			tipoOrganizadorDao.setEntityManager(tipoProgramacaoDao.getEntityManager());
			palestranteDao.setEntityManager(tipoProgramacaoDao.getEntityManager());
			organizadorDao.setEntityManager(tipoProgramacaoDao.getEntityManager());		
			tipoProgramacaoDao.save(new TipoProgramacao("Mini curso"));
			tipoProgramacaoDao.save(new TipoProgramacao("Palestra"));		
			tipoOrganizadorDao.save(new TipoOrganizador("Apoio"));
			tipoOrganizadorDao.save(new TipoOrganizador("Realização"));		
			tipoOrganizadorDao.save(new TipoOrganizador("Patrocínio"));
			palestranteDao.save(new Palestrante(null, "Fulano", "Resumo do Fulano", "Doutor"));
			palestranteDao.save(new Palestrante(null, "Siclano", "Resumo do Siclano", "Mestre"));
			organizadorDao.save(new Organizador(null, "Beltrano 1", "", "Professor", "Informática", "www"));
			organizadorDao.save(new Organizador(null, "Beltrano 2", "", "Professor", "Informática", "www"));		
			organizadorDao.commit();
		}
	}
}