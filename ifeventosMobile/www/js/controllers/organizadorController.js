angular.module("app").controller('organizadorController', function($scope, eventoService){
    $scope.listOrganizadores = [];
	$scope.listOrganizadores =  eventoService.eventOrganizadores;
	$scope.id = eventoService.id;
});

