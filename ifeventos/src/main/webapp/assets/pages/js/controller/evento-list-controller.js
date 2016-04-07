app.controller('EventoListController', function($compile, $scope, $http, $window, $resource, globalService, Evento){

	/**
	 *Variables
	 */    
    $scope.url = 'evento';
    $scope.table = jQuery('#table');
    
    /**
     *Functions
     */   
    
    $scope.newForm = function(){
    	$window.location.href = $scope.url+'/form';
    }
    
    $scope.edit = function(id){
    	$window.location.href = $scope.url+'/form/'+id;
    }
    
    $scope.removeValidate = function(id){
    	bootbox.confirm("Tem certeza que deseja remover esse registro?", function(result) {
    		if (result)
    			$scope.remove(id);
    	});
    }
    
    $scope.remove = function(id){
//    	TODO AS LINHAS COMENTADAS FUNCIONAM, ENTRETANTO TRAFEGAM LIXO ENTRE AS REQUISIÇÕES.
//    	
//    	var dto = new Evento();
//    	dto.id = id;
//    	$http.post($scope.url+"/delete", dto)
    	$http.post($scope.url+"/delete", id)
    	.then(function success(response){
    		if (response.data == true){
    			$scope.table.bootstrapTable('load');
    			console.log("carregou");
    		}
    		else
    			alert('Error');
    	}, function error(response){
    		console.log(response);
    		alert('Error');
    	});
    }
    
    /**
     *Init
     */   
       
    globalService.setBootstrapTableEvent('table', 'onClickRow', function(e, row, element){
//    	$scope.edit(row.id);
    });
    
    globalService.setBootstrapTableEvent('table', 'onClickCell', function(e, field, value, row, $element){
    	if (field != 'state'){    		
    		if (field == 'removeButton')
    			$scope.removeValidate(row.id);
    		else
    			$scope.edit(row.id);
    	}
    });
      
});

function imagemFormatter(value, row, index) {
	if (value)
		return '<img src="img/evento/'+value+'" class="thumb" />';
	else
		return '<img src="img/evento/not_found.jpg" class="thumb" />';
}

function removeFormatter(value, row, index) {	
	return '<div id="removeButton" class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i></div>'
}