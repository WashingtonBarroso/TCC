package br.com.natasoft.horus.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.natasoft.horus.model.dao.impl.PessoaDAO;

@Controller
public class IndexController {

	private final Result result;

	 @Inject
	 private PessoaDAO dao;

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
		result.include("variable", "Hórus! Pessoas: " + dao.count().toString());
	}
}