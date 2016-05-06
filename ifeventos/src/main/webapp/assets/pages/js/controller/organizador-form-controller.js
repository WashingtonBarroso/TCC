app.controller('OrganizadorFormController', function($compile, $scope, $http, $window, $resource, Organizador, TipoOrganizador, globalService){
    
     /**
	 *Variables 
	 */    
    
	$scope.url = 'organizador';
    $scope.dto = new Organizador();
    $scope.tiposOrganizadores = []; 
    $scope.tipoOrganizadorId;
    
    /**
	 *Functions
	 */  
    
    $scope.setDTO = function(dto){
    	if (dto != "")
    		$scope.dto = dto; 
   
    }
    
   
    $scope.setForm = function(form){
    		$scope.tiposOrganizadores = form;
    }
    
    $scope.newForm = function(){
    	$scope.dto = new Organizador();
    }
    
    $scope.fillForm = function(){
    	$scope.dto.tipoOrganizador = new TipoOrganizador();
    	$scope.dto.tipoOrganizador.descricao = "a";
    	$scope.dto.tipoOrganizador.id = $scope.tipoOrganizadorId;
    	console.log($scope.dto);
    }
    
    $scope.save = function(){    
    	$scope.fillForm();
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
    		$scope.dto = new Organizador();
    	}, function error(response){    		
    		console.log(response);
    	});
    	$scope.save();
    }
    
    $scope.cancel = function(){
    	$window.location.href = $scope.url+"/list";
    }
    
});   
    