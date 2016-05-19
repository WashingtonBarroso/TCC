app.controller('ProgramacaoFormController', function($compile, $scope, $http, $window, $resource, Programacao, TipoProgramacao, globalService){
    
     /**
	 *Variables
	 */    
    $scope.url = 'programacao';
    $scope.dto = new Programacao();
    $scope.tiposProgramacaos = [];  
    $scope.tipoProgramacaoId;
    $scope.hora = {value: new Date()};
    $scope.dto.data = {value: new Date()};
    
    /**
	 *Functions
	 */  
    
    $scope.setDTO = function(dto){
    	if (dto != "")
    		$scope.dto = dto;
    }
    
    $scope.setTpProgramacao = function(listTpProgramacao){
    		$scope.tiposProgramacaos = listTpProgramacao;
    }
    
    $scope.newForm = function(){
    	$scope.dto = new Programacao();
    }
    
    $scope.fillForm = function(){
    	$scope.dto.tipoProgramacao = new TipoProgramacao();
    	$scope.dto.tipoProgramacao.descricao = "a";
    	$scope.dto.tipoProgramacao.id = $scope.tipoProgramacaoId; 
    };
   
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
    		$scope.dto = new Programacao();
    	}, function error(response){    		
    		console.log(response);
    	});
    	$scope.save();
    }
    
    $scope.cancel = function(){
    	$window.location.href = $scope.url+"/list";
    }
    
});   
    