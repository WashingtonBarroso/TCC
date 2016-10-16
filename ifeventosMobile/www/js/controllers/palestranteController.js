angular.module("app").controller('palestranteController', function ($scope, eventoService) {

	$scope.programacoes = [];
	$scope.programacoes = eventoService.events;
	$scope.id = eventoService.id;
    $scope.show = false;
   	
	$scope.toggleShown = function (show) {
		 $scope.show = !$scope.show;
	};
	$scope.isShown = function (show) {
		return $scope.show;	
	};

});
