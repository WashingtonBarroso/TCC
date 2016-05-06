app.controller('MapaFormController', function($compile, $scope, $http, $window, $resource, Mapa, globalService){

	/**
	 *Variables
	 */    
	$scope.url = 'mapa';
	$scope.dto = new Mapa(); 
	/**
	 *Functions
	 */  

	$scope.setDTO = function(dto){
		if (dto != "")
			$scope.dto = dto;
	}

	$scope.newForm = function(){
		$scope.dto = new Mapa();
	}


	$scope.save = function(){    
		$http.post($scope.url+"/save", $scope.dto)
		.then(function success(response){
			if (response.data.id != null){
				$scope.dto = response.data;
				globalService.showMensage('div_alert','Registro salvo com sucesso!','success');
			}    				
			else
				globalService.showMensage('div_alert','Erro ao tentar salvar o registro!','danger');
		}, function error(response){
			console.log(response);
		});
	}

	$scope.remove = function(){
		$scope.dto.ativo = false;
		$http.post($scope.url+"/delete", $scope.dto)
		.then(function success(response){
			console.log("response: "+response);
			$scope.dto = new Mapa();
		}, function error(response){    		
			console.log(response);
		});
		$scope.save();
	}

	$scope.cancel = function(){
		$window.location.href = $scope.url+"/list";
	}


	// Maps

	var myLocal = {lat: -16.255613, lng: -47.9267677};
  
	$scope.markers = [];

	$scope.map = new google.maps.Map(document.getElementById('map'), {
		zoom: 15,
		center: myLocal,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	});
	// Adiciona as marker no map com click
	$scope.map.addListener('click', function(event){
		$scope.dto = new Mapa(); 
        
		$scope.dto.latitude = event.latLng.lat();
		$scope.dto.longitude = event.latLng.lng();
		$scope.addMarker(event.latLng);

	});

	//Adcionar a mapa no array 
	$scope.addMarker = function(myLocal){

		$scope.marker = new google.maps.Marker({
			map: $scope.map,
			position: myLocal, 
			
		});
     $scope.markers.push($scope.marker);
	}


	$scope.set = function(map) {
	  	
	  for (var i = 0; i < $scope.markers.length; i++) {
	    $scope.markers[i].setMap($scope.map);
	  }
	}


	$scope.clear = function() {
	  $scope.set(null);
	}
	
	$scope.deletar = function() {
		$scope.clear();
	  $scope.markers = [];
	} 
	
	
	var infoWindow = new google.maps.InfoWindow({map: $scope.map});

	if (navigator.geolocation) {
	    navigator.geolocation.getCurrentPosition(function(position) {
        
			 var pos = {
				        lat: position.coords.latitude,
				        lng: position.coords.longitude
		     };
			
	        infoWindow.setPosition(pos);
	        infoWindow.setContent('Seu local.');
	        $scope.map.setCenter(pos);
	    }, function() {
	      handleLocationError(true, infoWindow, $scope.map.getCenter());
	    });
	  } else {
	    // Browser doesn't support Geolocation
	     alert("Browser não suporta geolocalização");
		 handleLocationError(false, infoWindow, $scope.map.getCenter());
	  }

	function handleLocationError(browserHasGeolocation, infoWindow, pos) {
	  infoWindow.setPosition(pos);
	  infoWindow.setContent(browserHasGeolocation ?
	                        'Error: O serviço de localização falhou.' :
	                        'Error: Seu browser não suporta geolocalização.');
	}

});   
