angular.module("app").controller('noticiaController', function($scope, $state, $ionicSlideBoxDelegate, eventoService){
 
  $scope.listOrganizadores = [];
	$scope.listOrganizadores =  eventoService.eventOrganizadores;
	$scope.id = eventoService.id;

  // Called to navigate to the main app
  $scope.startApp = function() {
    $state.go('home');
  };
  $scope.next = function() {	
    $ionicSlideBoxDelegate.next();
  };
  $scope.previous = function() {
    $ionicSlideBoxDelegate.previous();
  };

  // Called each time the slide changes
  $scope.slideChanged = function(index) {
    $scope.slideIndex = index;
  };

  $scope.toIntro = function(){
    $state.go('home');
  }

});

