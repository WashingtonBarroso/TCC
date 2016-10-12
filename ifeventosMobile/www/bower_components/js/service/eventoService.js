angular.module("app").service("eventoService", function($http, config){
   
	var events = [];
	var id;
	var eventOrganizadores = [];
	var eventMapas = []; 
	
	this.getEventos = function(){
		return $http.get(config.baseURL + "/loadEvento");
	};	

	this.getEventosById = function(id){
		return $http.get(config.baseURL + "/loadEventoId/"+id);
	}; 

});