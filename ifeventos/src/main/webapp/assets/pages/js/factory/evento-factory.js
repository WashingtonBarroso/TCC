app.factory('Evento', function(Endereco){    
    return function(){
    	this.id = null;    	
    	this.nome = "";    	
    	this.local = "";    	
    	this.site = "";    	
    	this.imagem = "";
    	this.endereco = new Endereco();
    	this.organizadores = [];
    	this.programacoes = [];
    	this.pontos = [];
    	this.ativo = true;
    }
});