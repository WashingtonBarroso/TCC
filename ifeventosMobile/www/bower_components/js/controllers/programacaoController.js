angular.module("app").controller('programacaoController', function($scope, $stateParams, eventoService){
	
	$scope.programacoes = [];
	
	$scope.loadProgramacao = function(){
	 eventoService.getEventosById($stateParams.id).success(function(evento){	
		
		$scope.programacoes = evento.programacao;
    	eventoService.events = evento.programacao;
		eventoService.eventOrganizadores = evento.organizadores;
		eventoService.eventMapas = evento.mapas;
		eventoService.id = evento.id;
		
		});	
	};
	
});