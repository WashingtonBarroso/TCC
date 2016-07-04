app.controller('PalestranteFormController', function($scope, $http, $window,Id, Palestrante, globalService){

	/**
	 *Variables
	 */    
    $scope.url = 'palestrante';
    $scope.dto = new Palestrante();
    $scope.palestrante = [];
    /**
     *Functions
     */
    
    $scope.setDTO = function(dto){
    	if (dto != undefined)
    		$scope.dto = dto;
    }
    
    $scope.newForm = function(){
    	$scope.dto = new Palestrante();
    }
    
    $scope.save = function(){
    	if ($scope.form.$valid){
	    	$http.post($scope.url+"/save", $scope.dto)
	    		.then(function success(response){
	    			if (response.data.message != "")
	    				globalService.showMensage('div_alert',response.data.message,'danger');
	    			else{
	    				$scope.dto = response.data.dto;
	    				globalService.showMensage('div_alert','Registro salvo com sucesso!','success');
	    			}
	    		}, function error(response){
	    			globalService.showMensage('div_alert',"Falha ao tentar salvar o registro.",'danger');
	    		});
    	}
    }
    
    $scope.remove = function(){
    	var id = new Id($scope.dto.id);
    	$http.post($scope.url+"/delete", id)
    	.then(function success(response){
    		if (response.data.message != "")
    			globalService.showMensage('div_alert',response.data.message,'danger');
    		else {
    			$scope.newForm();
    			globalService.showMensage('div_alert','Registro removido com sucesso!','success');
    		}
    	}, function error(response){    		
    		globalService.showMensage('div_alert',"Falha ao tentar remover o registro.",'danger');
    	});
    }
    
    $scope.cancel = function(){
    	$window.location.href = $scope.url+"/list";
    }
    
    /**
     *Init
     */
      
});