app.controller('OrganizadorFormController', function($scope, $http, $window, Id, Organizador, globalService){

	/**
	 *Variables
	 */    
    $scope.url = 'organizador';
    $scope.dto = new Organizador();
    $scope.organizador = [];
    $scope.imagem = null;
	$scope.savedImage = 'img/not_found.gif';
	
    /**
     *Functions
     */
    
    $scope.setDTO = function(dto){
    	if (dto != undefined){
    		$scope.dto = dto;
    		$scope.savedImage = ($scope.dto.imagem != "") ? 'img/organizador/'+$scope.dto.imagem : $scope.savedImage;
    	}
    }
    
    $scope.newForm = function(){
    	$scope.dto = new Organizador();
    }
    
    $scope.save = function(){
    	if ($scope.form.$valid){
	    	$http.post($scope.url+"/save", $scope.dto)
	    		.then(function success(response){
	    			if (response.data.message != "")
	    				globalService.showMensage('div_alert',response.data.message,'danger');
	    			else{
	    				$scope.dto = response.data.dto;
	    				if ($scope.imagem == null)
	    					globalService.showMensage('div_alert','Registro salvo com sucesso!','success');
	    				else
	    					$scope.uploadImage();
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
    
    $scope.clearImage = function(){
		$scope.imagem = null;
		$scope.dto.imagem = null;
		$scope.savedImage = 'img/not_found.gif';
	}
	
	$scope.uploadImage = function(){
		var formData = new FormData();		
		var re = /(?:\.([^.]+))?$/;
		var ext = re.exec($scope.imagem.$ngfName)[1];		
		formData.append('imagem', $scope.imagem);
		formData.append('id', $scope.dto.id);
		formData.append('filename', $scope.dto.id+"."+ext);
        $http.post($scope.url+"/uploadimage", formData, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(function success(response){
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
    
    /**
     *Init
     */
      
});