angular.module("app").controller('palestranteController', function($scope, eventoService){
	$scope.programacoes = []; 
    $scope.programacoes = eventoService.events;
	$scope.id = eventoService.id;
});