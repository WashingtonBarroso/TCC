app
.factory('Evento', function(Endereco){    
    return function(){    	
    	this.id = null;    	
    	this.nome = "";    	
    	this.local = "";    	
    	this.endereco = new Endereco();
    	this.site = "";    	
    	this.imagem = "";    	
    	this.ativo = true;
    }
});