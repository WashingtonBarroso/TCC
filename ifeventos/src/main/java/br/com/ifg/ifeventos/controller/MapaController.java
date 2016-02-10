package br.com.ifg.ifeventos.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.ifg.ifeventos.dto.MapaDTO;
import br.com.ifg.ifeventos.model.entity.Mapa;
import br.com.ifg.ifeventos.service.MapaService;

@Controller
public class MapaController {


	private final Result result;

	@Inject
	private MapaService service;

	
	protected MapaController(){
		this(null);
	}

	@Inject
	public MapaController(Result result) {
		this.result = result;
	}

	@Path("/mapa/form")
	public void form(){
		MapaDTO dto = service.loadForm();	
		result.include("dto", dto);
	}

	
	@Post("/mapa/save")
	public void save(MapaDTO dto){
		service.save(dto);
		result.redirectTo(this).form();
	}
   
	
    @Path("/mapa/list") 
    public void list(){
     List<Mapa> mapa = service.list();
     result.include("list", mapa);
    }

    @Delete("/mapa")
    public void remove(Long id){
    service.deleteById(id);
    result.redirectTo(this).list();
    }
   
    
    @Post("/mapa/edit")
    public void edit(Long id){
    	MapaDTO dto = new MapaDTO();
    	dto.getMapa().setId(id);
        dto = service.load(dto);
        result.include("dto", dto);
    }


    @Path("/mapa/loadJson")
    public void loadJson(){
    	result.use(Results.json()).from(service.list()).serialize();	
    }

}
