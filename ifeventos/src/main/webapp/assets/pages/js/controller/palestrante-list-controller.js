app.controller('PalestranteListController', function($compile, $scope, $http, $window, $resource, globalService){

	/**
	 *Variables
	 */    
    $scope.url = 'palestrante';
    
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
    
    $scope.remove = function(id){    	
    	$http.post($scope.url+"/delete", id)
    	.then(function success(response){
    		if (response.data == true)
    			$scope.array.splice(index, 1);
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
       
    globalService.setBootstrapTableEvent('table', 'clickRow', function(e, row, element){
    	$scope.edit(row.id);
    });
      
});