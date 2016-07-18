app.controller('TipoOrganizadorListController', function($scope, $http, $window, Id, globalService){

	/**
	 *Variables
	 */    
    $scope.url = 'tipoorganizador';
    $scope.table = jQuery('#table');
    
    /**
     *Functions
     */   
    
    $scope.newForm = function(){
    	console.log('newForm');
    	$window.location.href = $scope.url+'/form';
    }
    
    $scope.edit = function(id){
    	$window.location.href = $scope.url+'/form/'+id;
    }
    
    $scope.removeMapaEvento = function(){
		var mapas = $scope.mapaTable.bootstrapTable('getAllSelections');
	}
    
    $scope.remove = function(){
    	var rows = $scope.table.bootstrapTable('getAllSelections');
    	if (rows.length > 0){
    		var excluir = [];		
    		for(var i=0; i < rows.length; i++){
    			excluir.push(new Id(rows[i].id));
    		}		
    		$http.post($scope.url+"/deleteAllSelected", excluir)
    		.then(function success(response){
    			if (response.data.message != "")
        			globalService.showMensage('div_alert',response.data.message,'danger');
        		else {
        			$scope.table.bootstrapTable('refresh');
        			globalService.showMensage('div_alert','Registro(s) removido(s) com sucesso!','success');
        		}
        	}, function error(response){    		
        		globalService.showMensage('div_alert',"Falha ao tentar remover o registro.",'danger');
        	});
    	}
    }
    
    
    /**
     *Init
     */   
       
    globalService.setBootstrapTableEvent('table', 'onClickRow', function(e, row, element){
    	$scope.edit(row.id);
    });
    
    globalService.setBootstrapTableEvent('table', 'onClickCell', function(e, field, value, row, $element){
    	if (field = 'id')
    	$scope.edit(row.id);
    });
      
});