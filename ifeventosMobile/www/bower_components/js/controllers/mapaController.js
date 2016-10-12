angular.module("app").controller('mapaController', function($scope, eventoService){

	$scope.mapas = []; 
	$scope.mapas =  eventoService.eventMapas;
	$scope.id = eventoService.id;

});

