app
.factory('Endereco', function(){    
    return function(){    	
    	this.id = null;
    	this.cep = ""; 
    	this.logradouro = ""; 
    	this.complemento = "";
    	this.bairro = "";
    	this.cidade = "";
    	this.estado = "";
    	this.ativo = true;
    }
});