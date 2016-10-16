angular.module("app").controller('eventoController', function($scope, eventoService){
     
	$scope.eventos = [];
	$scope.$emit('LOAD')
	
	var loadEventos = function(){
		eventoService.getEventos().success(function (data) {
			$scope.eventos = data;
			$scope.$emit('UNLOAD')
		}).error(function (data, status) {
			$scope.message = "Sem service: " + data;
		});
	};
    

	loadEventos();

$scope.$on('LOAD', function(){
$scope.loading = true;
console.log(loading);
});

$scope.$on('UNLOAD', function(){
$scope.loading = false;
});



});

