app.controller('EventoFormController', function($compile, $scope, $http, $window, $resource, Evento, Endereco, globalService, Upload, $timeout){

	/**
	 *Variables
	 */    
    $scope.url = 'evento';
    $scope.dto = new Evento();
    $scope.organizacoes = [{id: 1, nome:'fulano'},{id: 2, nome: 'beltrano'}];
    
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
    
    /**
     *Init
     */
      
});