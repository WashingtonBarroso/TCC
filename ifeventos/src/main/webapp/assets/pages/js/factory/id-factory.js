app.factory('Id', function(){
    return function(id){
    	if (id)
    		this.id = id;
    	else
    		this.id = null;    	
    }
});