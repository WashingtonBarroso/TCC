app.controller('EventoFormController', function($scope, $filter, $http, $window, Id, Evento, Endereco, Organizador, Programacao, Mapa, Palestrante, OrganizadorEvento, globalService, Upload, $timeout){

	/**
	 *Variables
	 */    
	$scope.url = 'evento';
	$scope.dto = new Evento();
	$scope.organizadorEvento = new OrganizadorEvento();
	$scope.mapa = new Mapa();
	$scope.programacao = new Programacao();

	//listas para seletores
	$scope.organizadores = [];
	$scope.tiposDeOrganizadores = [];
	$scope.palestrantes = [];
	$scope.tiposDeProgramacao = [];  
	
	//tabelas
	$scope.organizacaoTable = jQuery('#organizacaoTable');
	$scope.mapaTable = jQuery('#mapaTable');
	$scope.programacaoTable = jQuery('#programacaoTable');
	
	/**
	 *Functions
	 */

	$scope.setDTO = function(dto){
		if (dto != undefined){			
			$scope.dto = dto;
			setTimeout(function(){ $scope.loadTables(); }, 1500);
		}
	}
	
	$scope.loadTables = function(){
		$scope.mapaTable.bootstrapTable('load', $scope.dto.mapas);
		$scope.organizacaoTable.bootstrapTable('load', $scope.dto.organizadores);
		$scope.programacaoTable.bootstrapTable('load', $scope.dto.programacao);
	}

	$scope.newForm = function(){
		$scope.dto = new Evento();
		$scope.mapaTable.bootstrapTable('removeAll');
		$scope.organizacaoTable.bootstrapTable('removeAll');
		$scope.programacaoTable.bootstrapTable('removeAll');
	}
	
	$scope.save = function(){
    	if ($scope.form.$valid){
    		$scope.getOrganizadoresEventoData();
			$scope.getMapasData();
			$scope.getProgramacaoData();
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
	 * Listas
	 */

	// Recebe uma lista de organizadores
	$scope.setOrganizadores = function(organizadores){
		$scope.organizadores = organizadores;
	}

	// Recebe uma lista de tipos de organizadores
	$scope.setTiposDeOrganizadores = function(tiposDeOrganizadores){
		$scope.tiposDeOrganizadores = tiposDeOrganizadores;
	}
	
	// Recebe uma lista de palestrantes
	$scope.setPalestrantes = function(palestrantes){
		$scope.palestrantes = palestrantes;
	}
	
	// Recebe uma lista de tipos de palestrantes
	$scope.setTiposDeProgramacao = function(tiposDeProgramacao){
		$scope.tiposDeProgramacao = tiposDeProgramacao;
	}
	
	
	/**
	 * Tab Dados do Evento
	 */	
		
	//máscara para o campo cep
	$scope.cepFormatter = function($event) {
		$scope.dto.endereco.cep = $filter('cep')($scope.dto.endereco.cep); 
		if ($event.keyCode == 13)
			$scope.getEnderecoByCep();
	};

	//obtendo cep por meio de webservice externo
	$scope.getEnderecoByCep = function(){
		var cep = $filter('clearCep')($scope.dto.endereco.cep);
		$http
        .get("http://viacep.com.br/ws/"+cep+"/json/")
        .success(function(data){
        	$scope.dto.endereco = new Endereco(null, $scope.dto.endereco.cep, data.logradouro, $scope.dto.endereco.complemento, data.bairro, data.localidade, data.uf);        	
        })
        .error(function(){
        });
	}
	
	
	/**
	 * Tab organização
	 */
	
	
	//organizador é do tipo OrganizadorEvento
	$scope.addOrganizador = function(){
		if ($scope.organizadorEvento.organizador.id > 0 && $scope.organizadorEvento.tipoOrganizador.id > 0){		
			
			/*
			 * Caso típico de acoplamento por imagem.
			 * Veja a quantidade de paramentros estão sendo enviados desnecessariamente via http.
			 */
			
			var organizadorEvento = new OrganizadorEvento();
			//organizadorEvento.evento = null; //para evitar enviar lixo via $http, comente essa linha e veja o por é importante elaborar DTOs.			
			organizadorEvento.organizador.id = $scope.organizadorEvento.organizador.id;
			organizadorEvento.organizador.nome = $scope.organizadorEvento.organizador.nome;
			organizadorEvento.tipoOrganizador.id = $scope.organizadorEvento.tipoOrganizador.id;
			organizadorEvento.tipoOrganizador.descricao = $scope.organizadorEvento.tipoOrganizador.descricao;		
			$scope.organizacaoTable.bootstrapTable('append', organizadorEvento);
			$scope.organizadorEvento = new OrganizadorEvento();
			$scope.getOrganizadoresEventoData();
		}
		else
			globalService.showMensage('div_organizacao_alert','Selecione o organizador e seu respectivo papel na organização deste evento!','warning');
	}
	
	$scope.getOrganizadoresEventoData = function(){
		$scope.dto.organizadores = $scope.organizacaoTable.bootstrapTable('getData');
	}
	
	//Usando o toolbar	
	$scope.removeOrganizadorEvento = function(){
		var organizadores = $scope.organizacaoTable.bootstrapTable('getAllSelections');
		var excluir = [];		
		for(var i=0; i < organizadores.length; i++){
			excluir.push(organizadores[i].organizador);
		}		
		$scope.organizacaoTable.bootstrapTable('remove',{field:'organizador', values:excluir});
	}
	
	globalService.setBootstrapTableEvent('organizacaoTable', 'onClickCell', function(e, field, value, row, $element){    	    		
    	if (field == 'removeButton'){
    		var excluir = [];
    		excluir.push(row.organizador);
    		$scope.organizacaoTable.bootstrapTable('remove',{field:'organizador', values:excluir});
    	}
    });
	
	
	/**
	 * Tab Mapa
	 */
	
	$scope.initMapViewerWithDelay = function(){
		setTimeout(function(){ $scope.initMapViewer(); }, 750);
	}
	
	$scope.mapViewerInitialized = false;
	$scope.initMapViewer = function(){
		if (!$scope.mapViewerInitialized){
			$scope.mapViewer = new google.maps.Map(document.getElementById('mapViewer'), {
				center: {lat: -16.243188643773316, lng: -47.96130895614624},
				scrollwheel: true,
				zoom: 15
			});
			
			// Adiciona as marker no map com click
			$scope.mapViewer.addListener('click', function(event){
				$scope.addMarker({
					descricao: $scope.mapa.descricao,
					lat: event.latLng.lat(),	
					lng: event.latLng.lng()
				});			
				$scope.mapa.latitude = event.latLng.lat();
				$scope.mapa.longitude = event.latLng.lng();
				
			});
			
			$scope.getGeolocation();			
			$scope.mapViewerInitialized = true;
		}		
	}
	
	$scope.getGeolocation = function(){
		var infoWindow = new google.maps.InfoWindow({map: $scope.mapViewer});
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				var pos = {
						lat: position.coords.latitude,
						lng: position.coords.longitude
				};
				infoWindow.setPosition(pos);
				infoWindow.setContent('Você está aqui!');
				$scope.mapViewer.setCenter(pos);
			}, function() {
				handleLocationError(true, infoWindow, $scope.mapViewer.getCenter());
			});
		} else {
			// Browser doesn't support Geolocation
			alert("Browser não suporta geolocalocation");
			handleLocationError(false, infoWindow, $scope.mapViewer.getCenter());
		}

		function handleLocationError(browserHasGeolocation, infoWindow, pos) {
			infoWindow.setPosition(pos);
			infoWindow.setContent(browserHasGeolocation ? 'Error: O serviço de location falhou.' : 'Error: Seu browser não suporta geolocation.');
		}
	}
	
	$scope.addMarker = function(myLocal){		
		var marker = new google.maps.Marker({
		    map: $scope.mapViewer,
		    position: myLocal,
		    title: $scope.mapa.descricao
		});
	}
	
	$scope.addMapa = function(){
		if ($scope.mapa.descricao.length > 0){
			$scope.mapaTable.bootstrapTable('append', $scope.mapa);			
			$scope.mapa = new Mapa();
		}
		else
			globalService.showMensage('div_mapa_alert','Informe a descrição do local selecionado!','warning');
	}
	
	$scope.getMapasData = function(){
		$scope.dto.mapas = $scope.mapaTable.bootstrapTable('getData');
	}
	
	$scope.removeMapaEvento = function(){
		var mapas = $scope.mapaTable.bootstrapTable('getAllSelections');
		var excluir = [];		
		for(var i=0; i < mapas.length; i++){
			excluir.push(mapas[i].descricao);
		}		
		$scope.mapaTable.bootstrapTable('remove',{field:'descricao', values:excluir});
	}
	
	globalService.setBootstrapTableEvent('mapaTable', 'onClickCell', function(e, field, value, row, $element){    	    		
    	if (field == 'removeButton'){
    		var excluir = [];
    		excluir.push(row.descricao);
    		$scope.mapaTable.bootstrapTable('remove',{field:'descricao', values:excluir});
    	}
    });

	
	/**
	 * Tab Programação
	 */
	
	$scope.addProgramacao = function(){
		if ($scope.programacao.data != "" > 0 && $scope.programacao.descricao.length > 0 && $scope.programacao.local.length > 0 && $scope.programacao.tipoProgramacao.descricao.length > 0 && $scope.programacao.palestrante.nome.length > 0){
			$scope.programacaoTable.bootstrapTable('append', $scope.programacao);			
			$scope.programacao = new Programacao();
		}
		else
			globalService.showMensage('div_programacao_alert','Verifique se todos os campos foram preenchidos!','warning');
	}
	
	$scope.getProgramacaoData = function(){
		$scope.dto.programacao = $scope.programacaoTable.bootstrapTable('getData');
	}
	
	globalService.setBootstrapTableEvent('programacaoTable', 'onClickCell', function(e, field, value, row, $element){    	    		
    	if (field == 'removeButton'){
    		var excluir = [];
    		excluir.push(row.descricao);
    		$scope.programacaoTable.bootstrapTable('remove',{field:'descricao', values:excluir});
    	}
    });
	
	
	
	/**
	 * Tab Imagem
	 */

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
//	url: $scope.url+"/save",
//	data: {
//	evento: $scope.dto, 
//	imagem: file
//	},
//	});

//	file.upload.then(function (response) {
//	$timeout(function () {
//	file.result = response.data;
//	});
//	}, function (response) {
//	if (response.status > 0)
//	$scope.errorMsg = response.status + ': ' + response.data;
//	}, function (evt) {
//	// Math.min is to fix IE which reports 200% sometimes
//	file.progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
//	});

});


function removeFormatter(value, row, index) {	
	return '<div id="removeButton" class="btn btn-danger"><i class="glyphicon glyphicon-trash"></i></div>'
}

function dateFormatter(value, row, index) {	
	var data = new Date(row.data);
	return data.getDate() + "/" + (data.getMonth() + 1) + "/" + data.getFullYear() + " " + data.getHours() + ":" + data.getMinutes();	 
}
