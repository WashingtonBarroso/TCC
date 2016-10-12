angular.module("app").controller('eventoController', function($scope, eventoService){
     
	$scope.eventos = [];
	
	var loadEventos = function(){
		eventoService.getEventos().success(function (data) {
			$scope.eventos = data;
		}).error(function (data, status) {
			$scope.message = "Sem service: " + data;
		});
	};
	loadEventos();
});

