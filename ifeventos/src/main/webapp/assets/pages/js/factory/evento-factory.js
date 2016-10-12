<<<<<<< HEAD
app.factory('Evento', function(Endereco){    
    return function(){
    	this.id = null;
    	this.dataInicio = "";
    	this.dataFim = "";
    	this.nome = "";    	
    	this.local = "";    	
    	this.site = "";    	
    	this.endereco = new Endereco();
    	this.organizadores = [];
    	this.programacao = [];
    	this.mapas = [];
    	this.ativo = true;
    }
=======
app.factory('Evento', function(Endereco){    
    return function(){
    	this.id = null;    	
    	this.nome = "";    	
    	this.local = "";    	
    	this.site = "";    	
    	this.endereco = new Endereco();
    	this.organizadores = [];
    	this.programacao = [];
    	this.mapas = [];
    	this.ativo = true;
    }
>>>>>>> refs/remotes/origin/master
});
