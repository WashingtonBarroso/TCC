package br.com.ifg.ifeventos.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.ifg.ifeventos.dto.EventoAppDTO;
import br.com.ifg.ifeventos.dto.ServiceEventoListDTO;
import br.com.ifg.ifeventos.model.dao.impl.EventoDAO;
import br.com.ifg.ifeventos.model.dao.impl.PalestranteDAO;
import br.com.ifg.ifeventos.model.entity.Evento;

@Controller
public class ServiceController {

	@Inject
	PalestranteDAO palestranteDao;

	@Inject
	EventoDAO eventoDao;

	private final Result result;

	protected ServiceController() {
		this(null);
	}

	@Inject
	public ServiceController(Result result) {
		this.result = result;
	}

	@Get("/service/loadEvento")
	public void loadEvento() {
		ServiceEventoListDTO<EventoAppDTO> dto = new ServiceEventoListDTO<EventoAppDTO>();
        dto.setRows(eventoDao.getListEventos());	  	
		result.use(Results.json()).withoutRoot()
				.from(dto.getRows()).recursive().serialize();
	}

	@Get("/service/loadEventoId/{id}")
	public void loadEventoId(Long id) {	
		Evento dto = eventoDao.getById(id);
		if (dto == null)
			result.notFound();
		else {
			result.use(Results.json()).withoutRoot().from(dto).recursive()
					.serialize();
		}
	}
	

}
