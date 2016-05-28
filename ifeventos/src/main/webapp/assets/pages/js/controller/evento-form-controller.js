app.controller('EventoFormController', function($compile, $scope, $http, $window, $resource, Evento, Endereco, Organizador, Programacao, Mapa, Palestrante, globalService, Upload, $timeout){

	/**
	 *Variables
	 */    
    $scope.url = 'evento';
    $scope.dto = new Evento();
    $scope.organizadores = [];
    $scope.programacoes = [];
 
    $scope.mapas = [];
    $scope.descricao; 
    
    $scope.listOrganizadores = [];
    $scope.listProgramacao = [];
    $scope.listPontos = [];
    
    $scope.markers = [];
    
    $scope.map = '';
    
    
    // Recebe uma lista de organizadores 
    $scope.setListOrganizador = function(listOrganizador){
    	$scope.organizadores = listOrganizador;
    }
    
    // Recebe uma lista de programacao 
    $scope.setListProgramacao = function(listProgramacao){
    	$scope.programacoes = listProgramacao;
    }
   
    // Recebe uma lista de pontos mapa
    $scope.setListMapa = function(listMapa){
    	$scope.mapas = listMapa;
    }
    
    $scope.adicionarOrganizador = function(item){
    	$scope.listOrganizadores.push(item);
    }
   
    $scope.adicionarProgramacao = function(item){
    	$scope.listProgramacao.push(item);
    }
    
	$scope.uploadPic = function(file) {
		file.upload = Upload.upload({
			url: $scope.url+"/save2",
			data: file,
		});

		file.upload.then(function (response) {
			$timeout(function () {
				file.result = response.data;
			});
		}, function (response) {
			if (response.status > 0)
				$scope.errorMsg = response.status + ': ' + response.data;
		}, function (evt) {
			//Math.min is to fix IE which reports 200% sometimes
			file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
		});
	}
    
    /**
     *Functions
     */
    
    $scope.setDTO = function(dto){
    	if (dto != "")
    		$scope.dto = dto;
    }
    
    $scope.newForm = function(){
    	$scope.dto = new Evento();
    }
    
    $scope.save = function(file){
    	console.log($scope.dto);
    	$http.post($scope.url+"/save", $scope.dto)
		.then(function success(response){
			console.log("response: "+response);
			if (response.data.id != null){
				$scope.dto = response.data;
				globalService.showMensage('div_alert','Registro salvo com sucesso!','success');
			}    				
			else
				globalService.showMensage('div_alert','Erro ao tentar salvar o registro!','danger');
		}, function error(response){
			console.log(response);
		});
    	
//    	file.upload = Upload.upload({
//            url: $scope.url+"/save",
//            data: {
//            	evento: $scope.dto, 
//            	imagem: file
//            },
//          });
//          
//  	    file.upload.then(function (response) {
//  	        $timeout(function () {
//  	          file.result = response.data;
//  	        });
//  	      }, function (response) {
//  	        if (response.status > 0)
//  	          $scope.errorMsg = response.status + ': ' + response.data;
//  	      }, function (evt) {
//  	        // Math.min is to fix IE which reports 200% sometimes
//  	        file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
//  	      });
    }
    
    $scope.remove = function(){
    	$scope.dto.ativo = false;
    	$http.post($scope.url+"/delete", $scope.dto)
    	.then(function success(response){
    		console.log("response: "+response);
    		$scope.dto = new EventoDTO();
    	}, function error(response){    		
    		console.log(response);
    	});
    	$scope.save();
    }
    
    $scope.cancel = function(){
    	$window.location.href = $scope.url+"/list";
    }
        
	// Mapas
 
    $scope.initGoogleMap = function(){
    	$scope.map = new google.maps.Map(document.getElementById('map'), {
    		zoom: 15,
    		center: {lat: -15.397, lng: -47.644},
    		mapTypeId: google.maps.MapTypeId.ROADMAP
    	});
    	
    	// Adiciona as marker no map com click
    	$scope.map.addListener('click', function(event){
    		var ponto = $scope.getGPS(event);
    		$scope.dto.pontos.push(ponto);
    		
    		$scope.marker = new google.maps.Marker({
    			map: $scope.map,
    			position: {lat:ponto.latitude, lng: ponto.longitude} 
    		});    			
    	});
    }
    
	$scope.adicionarPonto = function(item){
	   $scope.listPontos.push(item);
	}
	
	
	
	$scope.getGPS = function(event){
		var ponto = new Mapa(); 		
		ponto.descricao = $scope.descricao;
		ponto.latitude = event.latLng.lat();
		ponto.longitude = event.latLng.lng();		
		$scope.position = {
				descricao: ponto.descricao,
				lat: ponto.latitude,	
				lng: ponto.longitude
		}
		$scope.addMarker($scope.position);
		
		return ponto;
	}
	
	
	var infoWindow = new google.maps.InfoWindow({map: $scope.map});

	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position) {

			var pos = {
					lat: position.coords.latitude,
					lng: position.coords.longitude
			};
			console.log(pos);

			infoWindow.setPosition(pos);
			infoWindow.setContent('Seu local.');
			$scope.map.setCenter(pos);
		}, function() {
			handleLocationError(true, infoWindow, $scope.map.getCenter());
		});
	}else {
		// Browser doesn't support Geolocation
		alert("Browser não suporta geolocalocation");
        handleLocationError(false, infoWindow, $scope.map.getCenter());
	}

	function handleLocationError(browserHasGeolocation, infoWindow, pos) {
		infoWindow.setPosition(pos);
		infoWindow.setContent(browserHasGeolocation ?
				'Error: O serviço de location falhou.' :
		'Error: Seu browser não suporta geolocation.');
	}

      
});