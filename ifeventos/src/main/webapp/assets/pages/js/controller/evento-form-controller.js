app.controller('EventoFormController', function($compile, $scope, $http, $window, $resource, Evento, Endereco, Organizador, Programacao, Mapa, Palestrante, OrganizadorEvento, globalService, Upload, $timeout){

	/**
	 *Variables
	 */    
    $scope.url = 'evento';
    $scope.dto = new Evento();
    
    $scope.organizadores = [];
    $scope.tipoOrganizadores = [];
          
    // Recebe uma lista de organizadores
    //listOrganizador é do tipo Organizador
    $scope.setListOrganizadores = function(listOrganizadores){
    	$scope.organizadores = listOrganizadores;
    }
    
    $scope.setListTipoOrganizadores = function(listTipoOrganizadores){
    	$scope.tipoOrganizadores = listTipoOrganizadores;
    }
    
    //organizador é do tipo OrganizadorEvento
    $scope.adicionarOrganizador = function(organizador){
    	$scope.dto.organizadores.push(angular.copy(organizador));
    	delete $scope.organizador;
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
	

	
//	file.upload = Upload.upload({
//        url: $scope.url+"/save",
//        data: {
//        	evento: $scope.dto, 
//        	imagem: file
//        },
//      });
//      
//	    file.upload.then(function (response) {
//	        $timeout(function () {
//	          file.result = response.data;
//	        });
//	      }, function (response) {
//	        if (response.status > 0)
//	          $scope.errorMsg = response.status + ': ' + response.data;
//	      }, function (evt) {
//	        // Math.min is to fix IE which reports 200% sometimes
//	        file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
//	      });


    
    /**
     *Functions
     */
    
    $scope.setDTO = function(dto){
    	if (dto != undefined)
    		$scope.dto = dto;
    }
    
    $scope.newForm = function(){
    	$scope.dto = new Evento();
    }
    
    $scope.save = function(){
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
        
    //tab
    $scope.adicionarProgramacao = function(programacao){
    	$scope.dto.programacoes.push(angular.copy(programacao));
    	delete $scope.programacao;
    };
    
    $scope.apagarProgramacao = function(listProgramacao){
     	$scope.dto.programacoes = listProgramacao.filter(function(programacao){
     		if(!programacao.selecionado) return programacao;
     	});
    };
    // fim tab4
    
    // Mapas    
    var myLocal = {lat: 0, lng: 0};

	$scope.map = new google.maps.Map(document.getElementById('map'), {
		zoom: 15,
		center: myLocal,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	});

	
	// Adiciona as marker no map com click
	$scope.map.addListener('click', function(event){

		//latitude = event.latLng.lat();
	//	longitude = event.latLng.lng();
		
		$scope.mapa = {
				descricao: $scope.mapa.descricao,
				lat: event.latLng.lat(),	
				lng: event.latLng.lng()
		}

		$scope.addMarker($scope.mapa);
	});
	
	
	 $scope.adicionarMapa = function(mapa){
		 console.log($scope.dto);
		 console.log($scope.dto.mapas);		 
		 $scope.dto.mapas.push(angular.copy(mapa));
	     delete $scope.mapa;
	 };
	
	 $scope.apagarMapa = function(listMapa){
		$scope.dto.mapas = listMapa.filter(function (mapa){
			if(!mapa.selecionado) return mapa;
		}); 
	 };
	 
    // adiciona marcação
	$scope.addMarker = function(myLocal){
		$scope.marker = new google.maps.Marker({map: $scope.map,position: myLocal,});
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
	} else {
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