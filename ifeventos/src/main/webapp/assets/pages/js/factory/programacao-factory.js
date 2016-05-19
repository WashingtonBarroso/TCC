app.factory('Programacao', function(TipoProgramacao){    
    return function(){    	
    	this.id = null; 
    	this.descricao = "";
    	this.data = new Date();    	
    	this.hora = new Date();    	
    	this.local = "";   	    	
    	this.tipoProgramacao = new TipoProgramacao();
    	this.ativo = true;
    }
});