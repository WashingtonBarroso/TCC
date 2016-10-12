angular.module("app").controller('detalhesMapaController', function($scope, $routeParams,eventoService){
    
	var listLocais = []; 
	
	var listLocais = eventoService.eventMapas;
	
	$scope.searchLocal = function(listLocais){
		
		for(var i = 0; i<listLocais.length; i++){
				if(listLocais[i].id == $routeParams.id){ 
				var local = {lat:"", lng:""};
				local.lat = listLocais[i].latitude; 
				local.lng = listLocais[i].longitude;
				return local;	
			}
		}
		  
	}
    
	var myLocal = $scope.searchLocal(listLocais);
	
	$scope.loadMap = function(mylocal){
        
		$scope.map = new google.maps.Map(document.getElementById('map'), {
				zoom: 12,
				center: myLocal,
				mapTypeId: google.maps.MapTypeId.ROADMAP
		});	 

	    $scope.marker = new google.maps.Marker({
		  position: myLocal,
          map: $scope.map,		  
		  title: "Lets go'"	
		});
	}
   
    $scope.loadMap(); 


});

