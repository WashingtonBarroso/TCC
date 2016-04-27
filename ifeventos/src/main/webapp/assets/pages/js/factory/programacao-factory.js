app.factory('Programacao', function(TipoProgramacao){    
    return function(){    	
    	this.id = null;    	
    	this.data = "";    	
    	this.hora = "";    	
    	this.local = "";   	    	
    	this.tipoProgramacao = new TipoProgramacao();
    	this.ativo = true;
    }
});