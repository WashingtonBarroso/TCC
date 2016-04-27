app.controller('NoticiaFormController', function($compile, $scope, $http, $window, $resource, Noticia, globalService){
    
     /**
	 *Variables
	 */    
    $scope.url = 'noticia';
    $scope.dto = new Noticia();
    
    /**
	 *Functions
	 */  
    
    $scope.setDTO = function(dto){
    	if (dto != "")
    		$scope.dto = dto;
    }
    
    $scope.newForm = function(){
    	$scope.dto = new Noticia();
    }
    
    $scope.save = function(){    
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
    		$scope.dto = new Noticia();
    	}, function error(response){    		
    		console.log(response);
    	});
    	$scope.save();
    }
    
    $scope.cancel = function(){
    	$window.location.href = $scope.url+"/list";
    }
    
});   
    