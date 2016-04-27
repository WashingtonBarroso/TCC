app.factory('Organizador', function(TipoOrganizador){    
    return function(){    	
    	this.id = null;    	
    	this.nome = "";    	
    	this.cargo = "";    	
    	this.area = "";
    	this.tipoOrganizador = new TipoOrganizador();
    	this.url = "";
    	this.ativo = true;
    }
});