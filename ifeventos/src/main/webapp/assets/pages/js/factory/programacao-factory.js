app.factory('Programacao', function(TipoProgramacao, Palestrante){    
    return function(){    	
    	this.id = null; 
    	this.descricao = "";
    	this.data = "";    	
    	this.hora = "";    	
    	this.local = "";   	    	
    	this.tipoProgramacao = new TipoProgramacao();
    	this.palestrante = new Palestrante();
    	this.ativo = true;
    }
});