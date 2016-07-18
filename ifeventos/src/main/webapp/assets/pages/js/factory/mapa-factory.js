app.factory('Mapa', function(){    
    return function(id, descricao, latitude, longitude){    	
    	if (id)
    		this.id = id;
    	else
    		this.id = null;
    	
    	if (descricao)
    		this.descricao = descricao;
    	else
    		this.descricao = "";
    	
    	if (latitude)
    		this.latitude = latitude;
    	else
    		this.latitude = 0;
    	
    	if (longitude)
    		this.longtude = longitude;
    	else
    		this.longitude = 0;
    	
    	this.ativo = true;
    }
});