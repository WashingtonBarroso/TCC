app.factory('OrganizadorEvento', function(Evento, Organizador, TipoOrganizador){    
    return function(){ 
    	this.evento = new Evento();    	
    	this.organizador = new Organizador();    	
    	this.tipoOrganizador = new TipoOrganizador();  
    }
});
