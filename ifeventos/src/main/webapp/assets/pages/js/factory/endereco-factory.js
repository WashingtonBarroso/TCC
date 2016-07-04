app.factory('Endereco', function(){
    return function(id, cep, logradouro, complemento, bairro, cidade, estado){
    	if (id)
    		this.id = id;
    	else
    		this.id = null;
    	if (cep)
    		this.cep = cep;
    	else
    		this.cep = "";
    	if (logradouro)
    		this.logradouro = logradouro;
    	else
    		this.logradouro = ""; 
    	if (complemento)
    		this.complemento = complemento;
    	else
    		this.complemento = "";
    	if (bairro)
    		this.bairro = bairro;
    	else
    		this.bairro = "";
    	if (cidade)    	
    		this.cidade = cidade;
    	else
    		this.cidade = "";
    	
    	if (estado)    	
    		this.estado = estado;
    	else
    		this.estado = "";
    	this.ativo = true;
    }
});