angular.module('app', ['ionic', 'uiGmapgoogle-maps'])

.config(function($stateProvider, $urlRouterProvider) {

  $stateProvider
    .state('eventmenu', {
      url: "/event",
      abstract: true,
      templateUrl: "templates/event-menu.html"
    })
    .state('eventmenu.home', {
      url: "/home",
      views: {
        'menuContent' :{
          templateUrl: "templates/home.html",
          controller: "HomeCtrl" 
        }
      }
    })
    .state('eventmenu.palestrantes', {
      url: "/palestrantes",
      views: {
        'menuContent' :{
          templateUrl: "templates/palestrantes.html",
          controller: "PalestranteCtrl"
        }
      }
    })
    .state('eventmenu.programacao', {
      url: "/programacao/:id",
      views: {
        'menuContent' :{
          templateUrl: "templates/programacao.html",
		  controller: "programacaoController"
        }
      }
    })
    .state('eventmenu.pgorganizador', {
      url:"/pgorganizador",
      views: {
       'menuContent':{
        templateUrl:"templates/pgorganizador.html",
        controller: "OrganizadorCtrl"
       } 
      }
    })
    .state('eventmenu.pgevento', {
      url:"/pgevento",
      views: {
       'menuContent':{
        templateUrl:"templates/pgevento.html",
        controller: "EventoCtrl"
       } 
      }
    })
	.state('eventmenu.pgmapa',{
		url:"/pgmapa",
		views:{
        'menuContent':{
		templateUrl:"templates/pgmapa.html",
		controller:"MapaCtrl"	
	  } 		
	 }
	})
    .state('listevento',{
		url:"/listevento",
		templateUrl:"templates/listevento.html",
		controller:"eventoController"		
	}) 
	
  $urlRouterProvider.otherwise("/event/home");
})

.controller('MainCtrl', function($scope, $ionicSideMenuDelegate) {
 
  $scope.toggleLeft = function() {
    $ionicSideMenuDelegate.toggleLeft();
  };
})

.controller('PalestranteCtrl', function($scope) {
    $scope.groups = [];
    for (var i=0; i<10; i++) {
      $scope.groups[i] = {name: i,items:[]};
      for (var j=0; j<3; j++) {
        $scope.groups[i].items.push(i + '-' + j);
      }
    }
  /*
   * if given group is the selected group, deselect it
   * else, select the given group
   */
  $scope.toggleGroup = function(group) {
    if ($scope.isGroupShown(group)) {
      $scope.shownGroup = null;
    } else {
      $scope.shownGroup = group;
    }
  };
  $scope.isGroupShown = function(group) {
    return $scope.shownGroup === group;
  };
})

.controller('HomeCtrl', function($scope, $state, $ionicSlideBoxDelegate) {
 
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
})

.controller('HomeCtrl', function($scope, $state) {
  console.log('HomeCtrl');
  
  $scope.toIntro = function(){
    $state.go('home');
  }
})

.controller("HomeCtrl", function($scope, $http){
  $http.get("http://localhost:8080/ifeventos/noticia/loadJson")
  .then(function (response) {
	  console.log(response.data);
	  $scope.noticias = response.data.list;
	  });
})
	

.controller("EventoCtrl", function($scope, $http){
  $http.get("http://www.w3schools.com/angular/customers.php")
  .then(function (response){$scope.eventos = response.data.records;});
  })


.controller("OrganizadorCtrl", function($scope, $http){
  $http.get("http://www.w3schools.com/angular/customers.php")
  .then(function (response) {$scope.organizadores = response.data.records;});

 })
 
.controller("MapaCtrl", function($scope){
	 
  $scope.map = {center:{latitude:45, longitude: -73}, zoom:8};

 });

