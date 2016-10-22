app.factory('Palestrante', function(){    
    return function(){    	
    	this.id = null;    	
    	this.nome = "";    	
    	this.resumo = "";    	
    	this.titulo = ""; 
    	this.imagem = "";
    	this.ativo = true;
    }
});