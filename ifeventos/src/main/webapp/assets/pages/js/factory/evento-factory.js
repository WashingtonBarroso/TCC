app.factory('Evento', function(Endereco, Organizador, Programacao){    
    return function(){    	
    	this.id = null;    	
    	this.nome = "";    	
    	this.local = "";    	
    	this.endereco = new Endereco();
    	this.organizador = new Organizador();
    	this.organizadores = [];
    	this.programacoes = [];
    	this.site = "";    	
    	this.imagem = "";    	
    	this.ativo = true;
    }
});