<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt" ng-app="app" ng-controller="EventoFormController"
	ng-init='setDTO(${dto}); setOrganizadores(${listOrganizador}); setTiposDeOrganizadores(${listTpOrganizador}); setTiposDeProgramacao(${listTpProgramacao}); setPalestrantes(${listPalestrante});'>

<head>
<jsp:include page="/WEB-INF/jsp/template/head.jsp" />
<link href="assets/global/bootstrap-table/bootstrap-table.css"
	rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/">IF Eventos - Administrativo</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i> User
								Profile</a></li>
						<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
						</li>
						<li class="divider"></li>
						<li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i>
								Logout</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<jsp:include page="/WEB-INF/jsp/template/menu.jsp" />
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Evento</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">

						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<div id="div_alert"></div>
									<div class="navbar">
										<div class="navbar-inner">
											<div class="container-right">
												<ul class="nav nav-tabs">
													<li class="active"><a href="#tab1" data-toggle="tab">Dado
															do Evento</a></li>
													<li><a href="#tab2" data-toggle="tab">Organização</a></li>
													<li><a href="#tab3" data-toggle="tab"
														ng-click="initMapViewerWithDelay();">Mapa</a></li>
													<li><a href="#tab4" data-toggle="tab">Programação</a></li>
													<!-- 
													<li><a href="#tab5" data-toggle="tab">Imagem</a></li>
													 -->
												</ul>
											</div>
										</div>
									</div>
									<form id="form" name="form" role="form" novalidate>
										<!-- enctype="multipart/form-data" -->
										<div class="tab-content">
											<!-- Init tab1 -->
											<div class="tab-pane fade tab-margin active in" id="tab1">
												<div class="form-group"
													ng-class="{'has-error':form.nome.$invalid ,'has-success':form.nome.$valid}">
													<label class="control-label"> Evento: <span
														class="required"> * </span>
													</label>
													<div class="input-icon right">
														<input class="form-control" type="text" name="nome"
															placeholder="Digite a nome do evento" ng-model="dto.nome"
															required ng-maxlength="200">
														<div class="validation-messages help-block"
															ng-messages="form.nome.$error">
															<div ng-message="maxlength">
																<i class="fa fa-warning"></i> O dado informado é muito
																grande.
															</div>
															<div ng-message="required">
																<i class="fa fa-warning"></i> Favor inserir o dado
																requerido.
															</div>
														</div>
													</div>
												</div>
												<div class="form-inline">
													<div class="form-group">
														<div
															ng-class="{'has-error':form.dataInicio.$invalid ,'has-success':form.dataInicio.$valid}">
															<label for="dataInicio"> Data Início: </label>
															<div class="input-icon right">
																<div class="col-md-4">
																	<input id="dataInicio" type="datetime-local"
																		name="dataInicio" class="form-control"
																		ng-model="dto.dataInicio"
																		placeholder="dd/MM/yyyyTHH:mm"
																		min="2001-01-01T00:00:00" max="2999-12-31T00:00:00" />
																	<div class="validation-messages help-block"
																		ng-messages="form.dataInicio.$error">
																		<div ng-message="datetimeinicio">
																			<i class="fa fa-warning"></i> O data e horário
																			informado é inválido.
																		</div>
																		<div ng-message="min">
																			<i class="fa fa-warning"></i> O data é muito antiga.
																		</div>
																		<div ng-message="max">
																			<i class="fa fa-warning"></i> O data é muito
																			distante.
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>

													<div class="form-group">
														<div
															ng-class="{'has-error':form.dataFim.$invalid ,'has-success':form.dataFim.$valid}">

															<div class="input-icon right">
																<div class="col-md-4">
																	<label for="dataFim"> Data Fim: </label> <input
																		id="dataFim" type="datetime-local" name="dataFim"
																		class="form-control" ng-model="dto.dataFim"
																		placeholder="dd/MM/yyyyTHH:mm"
																		min="2001-01-01T00:00:00" max="2999-12-31T00:00:00" />
																	<div class="validation-messages help-block"
																		ng-messages="form.dataFim.$error">
																		<div ng-message="datetimelocal">
																			<i class="fa fa-warning"></i> O data e horário
																			informado é inválido.
																		</div>
																		<div ng-message="min">
																			<i class="fa fa-warning"></i> O data é muito antiga.
																		</div>
																		<div ng-message="max">
																			<i class="fa fa-warning"></i> O data é muito
																			distante.
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
												<!-- inline -->

												<div class="form-group"
													ng-class="{'has-error':form.localEvento.$invalid ,'has-success':form.localEvento.$valid}">
													<label class="control-label">Local <span
														class="required">*</span>
													</label> <input class="form-control" type="text" name="localEvento"
														placeholder="Digite o local do evento"
														ng-model="dto.local" required ng-maxlength="200">
													<div class="validation-messages help-block"
														ng-messages="form.localEvento.$error">
														<div ng-message="maxlength">
															<i class="fa fa-warning"></i> O dado informado é muito
															grande.
														</div>
														<div ng-message="required">
															<i class="fa fa-warning"></i> Favor inserir o dado
															requerido.
														</div>
													</div>
												</div>
												<div class="form-group"
													ng-class="{'has-error':form.cep.$invalid ,'has-success':form.cep.$valid}">
													<label class="control-label">Cep <span
														class="required">*</span>
													</label> <input class="form-control" type="text" name="cep"
														maxlength="10" placeholder="Digite o cep do evento"
														ng-model="dto.endereco.cep" required ng-maxlength="10"
														ng-keyup="cepFormatter($event)">
													<div class="validation-messages help-block"
														ng-messages="form.cep.$error">
														<div ng-message="maxlength">
															<i class="fa fa-warning"></i> O dado informado é muito
															grande.
														</div>
														<div ng-message="required">
															<i class="fa fa-warning"></i> Favor inserir o dado
															requerido.
														</div>
													</div>
												</div>
												<div class="form-group"
													ng-class="{'has-error':form.logradouro.$invalid ,'has-success':form.logradouro.$valid}">
													<label class="control-label">Logradouro <span
														class="required">*</span>
													</label> <input class="form-control" type="text" name="logradouro"
														placeholder="Digite o logradouro do evento"
														ng-model="dto.endereco.logradouro" required
														ng-maxlength="200"> <span class="help-block"
														ng-show="form.logradouro.$error.required"> <i
														class="fa fa-warning"></i> Favor inserir o dado requerido.
													</span> <span class="help-block"
														ng-show="form.logradouro.$error.maxlength"> <i
														class="fa fa-warning"></i> O dado informado é muito
														grande.
													</span>
												</div>
												<div class="form-group"
													ng-class="{'has-error':form.complemento.$invalid ,'has-success':form.complemento.$valid}">
													<label class="control-label">Complemento <span
														class="required">*</span>
													</label> <input class="form-control" type="text" name="complemento"
														placeholder="Digite o complemento do evento"
														ng-model="dto.endereco.complemento" required
														ng-maxlength="200"> <span class="help-block"
														ng-show="form.complemento.$error.required"> <i
														class="fa fa-warning"></i> Favor inserir o dado requerido.
													</span> <span class="help-block"
														ng-show="form.complemento.$error.maxlength"> <i
														class="fa fa-warning"></i> O dado informado é muito
														grande.
													</span>
												</div>
												<div class="form-group"
													ng-class="{'has-error':form.bairro.$invalid ,'has-success':form.bairro.$valid}">
													<label class="control-label">Bairro <span
														class="required">*</span>
													</label> <input class="form-control" type="text" name="bairro"
														placeholder="Digite o bairro do evento"
														ng-model="dto.endereco.bairro" required ng-maxlength="200">
													<span class="help-block"
														ng-show="form.bairro.$error.required"> <i
														class="fa fa-warning"></i> Favor inserir o dado requerido.
													</span> <span class="help-block"
														ng-show="form.bairro.$error.maxlength"> <i
														class="fa fa-warning"></i> O dado informado é muito
														grande.
													</span>
												</div>
												<div class="form-group"
													ng-class="{'has-error':form.cidade.$invalid ,'has-success':form.cidade.$valid}">
													<label class="control-label">Cidade <span
														class="required">*</span>
													</label> <input class="form-control" type="text" name="cidade"
														placeholder="Digite o cidade do evento"
														ng-model="dto.endereco.cidade" required ng-maxlength="200">
													<span class="help-block"
														ng-show="form.cidade.$error.required"> <i
														class="fa fa-warning"></i> Favor inserir o dado requerido.
													</span> <span class="help-block"
														ng-show="form.cidade.$error.maxlength"> <i
														class="fa fa-warning"></i> O dado informado é muito
														grande.
													</span>
												</div>
												<div class="form-group"
													ng-class="{'has-error':form.estado.$invalid ,'has-success':form.estado.$valid}">
													<label class="control-label">Estado <span
														class="required">*</span>
													</label> <input class="form-control" type="text" name="estado"
														placeholder="Digite o estado do evento"
														ng-model="dto.endereco.estado" required ng-maxlength="200">
													<span class="help-block"
														ng-show="form.estado.$error.required"> <i
														class="fa fa-warning"></i> Favor inserir o dado requerido.
													</span> <span class="help-block"
														ng-show="form.estado.$error.maxlength"> <i
														class="fa fa-warning"></i> O dado informado é muito
														grande.
													</span>
												</div>
												<div class="form-group"
													ng-class="{'has-error':form.site.$invalid ,'has-success':form.site.$valid}">
													<label class="control-label">Website</label> <input
														class="form-control" type="text" name="site"
														placeholder="Digite a url do Website do evento"
														ng-model="dto.site" required ng-maxlength="200"> <span
														class="help-block" ng-show="form.site.$error.maxlength">
														<i class="fa fa-warning"></i> O dado informado é muito
														grande.
													</span>
												</div>
											</div>
											<!-- End tab1 -->

											<!-- Init tab2 -->
											<div class="tab-pane fade tab-margin" id="tab2">
												<!-- /.row -->
												<div class="row">
													<div class="col-lg-12">
														<div class="panel-body">
															<div class="panel panel-default">
																<div class="panel-body">
																	<div id="div_organizacao_alert"></div>
																	<div class="form-group">
																		<label class="control-label"> Organizador: </label>
																		<div class="input-icon right">
																			<select class="form-control"
																				ng-model="organizadorEvento.organizador"
																				ng-options="organizador as organizador.nome for organizador in organizadores"
																				name="organizador" class="form-control">
																			</select>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="control-label"> Papel na
																			organização: </label>
																		<div class="input-icon right">
																			<select class="form-control"
																				ng-model="organizadorEvento.tipoOrganizador"
																				ng-options="tipoOrganizador as tipoOrganizador.descricao for tipoOrganizador in tiposDeOrganizadores"
																				name="tipoOrganizador" class="form-control">
																			</select>
																		</div>
																	</div>
																	<div class="form-group" style="float: right;">
																		<div id="newButton" class="btn btn-success"
																			ng-click="addOrganizador()">
																			<i class="fa fa-plus"></i> Adicionar
																		</div>
																	</div>
																</div>
															</div>
															<div class="dataTable_wrapper">
																<table id="organizacaoTable"
																	data-classes="table table-hover table-condensed"
																	data-striped="true" data-show-toggle="true"
																	data-show-columns="true" data-show-export="true"
																	data-pagination="true" data-toggle="table"
																	data-page-list="[5, 10, 20, 50, 100, 200]">
																	<thead>
																		<tr>
																			<th data-valign="middle"
																				data-field="organizador.nome" data-sortable="true">Nome</th>
																			<th data-valign="middle"
																				data-field="tipoOrganizador.descricao"
																				data-sortable="true">Papel na Organização</th>
																			<th data-valign="middle" class="col-xs-1"
																				data-field="removeButton" data-align="center"
																				data-formatter="removeFormatter">Remover</th>
																		</tr>
																	</thead>
																</table>
																<!-- 
																<div id="toolbarOrganizador" class="form-group" style="float: right;">
																    <button type="button" class="btn btn-default" ng-click="removeOrganizadorEvento()">
																        <i class="glyphicon glyphicon-trash"></i>
																    </button>
																</div>													
																 -->
															</div>
														</div>
													</div>
												</div>
												<!-- row -->
											</div>
											<!-- End tab2 -->


											<!-- Init tab3 -->
											<div class="tab-pane fade tab-margin" id="tab3">
												<!-- /.row -->
												<div class="row">
													<div class="col-lg-12">
														<div class="panel-body">
															<div class="panel panel-default">
																<div class="panel-body">
																	<div id="div_mapa_alert"></div>
																	<div class="form-group">
																		<label class="control-label"> Marque a
																			localização no mapa: </label>
																		<div id="mapViewer" class="img-responsive"
																			style="width: 100%; height: 300px; margin-bottom: 1cm;">
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="control-label"> Descrição do
																			local: </label>
																		<div class="input-icon right">
																			<input class="form-control" name="descricaoMapa"
																				type="text" ng-model="mapa.descricao"
																				maxlength="100"> <br> <label
																				class="control-label"> Latitude:
																				{{mapa.latitude}}</label> <br> <label
																				class="control-label"> Longitude:
																				{{mapa.longitude}}</label>
																		</div>
																	</div>
																	<div class="form-group" style="float: right;">
																		<div id="newButton" class="btn btn-success"
																			ng-click="addMapa()">
																			<i class="fa fa-plus"></i> Adicionar
																		</div>
																	</div>
																</div>
															</div>
															<div class="dataTable_wrapper">
																<table id="mapaTable"
																	data-classes="table table-hover table-condensed"
																	data-striped="true" data-show-toggle="true"
																	data-show-columns="true" data-show-export="true"
																	data-pagination="true" data-toggle="table"
																	data-page-list="[5, 10, 20, 50, 100, 200]">
																	<thead>
																		<tr>
																			<th data-valign="middle" data-field="descricao"
																				data-sortable="true">Descricao</th>
																			<th data-valign="middle" data-field="latitude"
																				data-sortable="true">Latitude</th>
																			<th data-valign="middle" data-field="longitude"
																				data-sortable="true">Longitude</th>
																			<th data-valign="middle" class="col-xs-1"
																				data-field="removeButton" data-align="center"
																				data-formatter="removeFormatter">Remover</th>
																		</tr>
																	</thead>
																</table>
															</div>
														</div>
													</div>
												</div>
												<!-- row -->
											</div>
											<!-- End tab3 -->


											<!-- Início tab4 -->
											<div class="tab-pane fade tab-margin" id="tab4">
												<!-- /.row -->
												<div class="row">
													<div class="col-lg-12">
														<div class="panel-body">
															<div class="panel panel-default">
																<div class="panel-body">
																	<div id="div_programacao_alert"></div>
																	<div class="form-group">
																		<div
																			ng-class="{'has-error':form.dataProgramacao.$invalid ,'has-success':form.dataProgramacao.$valid}">
																			<label class="control-label"> Início: </label>
																			<div class="input-icon right">
																				<input type="datetime-local" name="dataProgramacao"
																					class="form-control" ng-model="programacao.data"
																					placeholder="dd/MM/yyyyTHH:mm"
																					min="2001-01-01T00:00:00" max="2999-12-31T00:00:00" />
																				<div class="validation-messages help-block"
																					ng-messages="form.dataProgramacao.$error">
																					<div ng-message="datetimelocal">
																						<i class="fa fa-warning"></i> O data e horário
																						informado é inválido.
																					</div>
																					<div ng-message="min">
																						<i class="fa fa-warning"></i> O data é muito
																						antiga.
																					</div>
																					<div ng-message="max">
																						<i class="fa fa-warning"></i> O data é muito
																						distante.
																					</div>
																				</div>
																			</div>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="control-label"> Tipo da
																			Programação: </label>
																		<div class="input-icon right">
																			<select class="form-control"
																				ng-model="programacao.tipoProgramacao"
																				ng-options="tipoProgramacao as tipoProgramacao.descricao for tipoProgramacao in tiposDeProgramacao"
																				name="tipoProgramacao" class="form-control">
																			</select>
																		</div>
																	</div>

																	<div class="form-group">
																		<label class="control-label"> Palestrante: </label>
																		<div class="input-icon right">
																			<select class="form-control"
																				ng-model="programacao.palestrante"
																				ng-options="palestrante as palestrante.nome for palestrante in palestrantes"
																				name="palestrante" class="form-control">
																			</select>
																		</div>
																	</div>

																	<div class="form-group">
																		<label class="control-label"> Descrição: </label>
																		<div class="input-icon right">
																			<input class="form-control"
																				name="descricaoProgramacao" type="text"
																				maxlength="150" ng-model="programacao.descricao">
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="control-label"> Espaço: </label>
																		<div class="input-icon right">
																			<input class="form-control" name="localProgramacao"
																				type="text" maxlength="150"
																				ng-model="programacao.local">
																		</div>
																	</div>
																	<div class="form-group" style="float: right;">
																		<div id="newButton" class="btn btn-success"
																			ng-click="addProgramacao()">
																			<i class="fa fa-plus"></i> Adicionar
																		</div>
																	</div>
																</div>
															</div>
															<div class="dataTable_wrapper">
																<table id="programacaoTable"
																	data-classes="table table-hover table-condensed"
																	data-striped="true" data-show-toggle="true"
																	data-show-columns="true" data-show-export="true"
																	data-pagination="true" data-toggle="table"
																	data-page-list="[5, 10, 20, 50, 100, 200]">
																	<thead>
																		<tr>
																			<th data-valign="middle" class="col-xs-1"
																				data-field="temp" data-align="center"
																				data-formatter="dateFormatter">Data</th>
																			<th data-valign="middle"
																				data-field="tipoProgramacao.descricao"
																				data-sortable="true">Tipo da Programação</th>
																			<th data-valign="middle"
																				data-field="palestrante.nome" data-sortable="true">Palestrante</th>
																			<th data-valign="middle" data-field="descricao"
																				data-sortable="true">Descrição</th>
																			<th data-valign="middle" data-field="local"
																				data-sortable="true">Espaço</th>
																			<th data-valign="middle" class="col-xs-1"
																				data-field="removeButton" data-align="center"
																				data-formatter="removeFormatter">Remover</th>
																		</tr>
																	</thead>
																</table>
															</div>
														</div>
														<!-- /.col-lg-12 -->
													</div>
												</div>
												<!-- /.row -->
											</div>
											<!-- Exit tab4 -->


											<!-- Início tab 5  
											<div class="tab-pane fade tab-margin" id="tab5">	
												<div class="form-group"
													ng-class="{'has-error':form.imagem.$invalid ,'has-success':form.imagem.$valid}">
													<label class="control-label">Imagem</label> <input
														type="file" ngf-select ng-model="imagem" name="imagem"
														accept="image/*" ngf-max-size="2MB" required
														ngf-model-invalid="errorFile"> <span
														class="help-block" ng-show="form.imagem.$error.required">
														<i class="fa fa-warning"></i> Favor inserir o dado
														requerido.
													</span> <img ng-show="form.file.$valid" ngf-thumbnail="imagem"
														class="thumb">
													<div id="removeButton" class="btn btn-danger"
														ng-click="imagem = null" ng-show="imagem">
														<i class="fa fa-times"></i> Remover
													</div>
												</div>
											</div>
											 -->
											<!-- Fim tab 5 -->
									</form>
									<!-- Grup button  -->
									<div class="form-group" style="float: right;">
										<div id="newButton" class="btn btn-primary"
											ng-click="newForm()">
											<i class="fa fa-file-o"></i> Limpar
										</div>
										<div id="saveButton" class="btn btn-success" ng-click="save()"
											ng-disabled="form.$invalid">
											<i class="fa fa-check"></i> Salvar
										</div>
										<div id="removeButton" class="btn btn-danger"
											ng-class="{'ng-hide' : dto.id==null}" ng-click="remove()">
											<i class="fa fa-times"></i> Remover
										</div>
										<div id="cancelButton" class="btn btn-outline btn-default"
											ng-click="cancel()">
											<i class="fa fa-reply"></i> Voltar
										</div>
									</div>
									<!-- Fim button -->
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- /#wrapper -->

	<jsp:include page="/WEB-INF/jsp/template/scripts.jsp" />


	<!-- Bootstrap Table -->
	<script type="text/javascript"
		src="assets/global/angularjs-ui/ui-mask/mask.min.js"></script>

	<!-- Bootstrap Table -->
	<script type="text/javascript"
		src="assets/global/bootstrap-table/bootstrap-table.min.js"></script>
	<script type="text/javascript"
		src="assets/global/bootstrap-table/extensions/angular/bootstrap-table-angular.min.js"></script>
	<script type="text/javascript"
		src="assets/global/bootstrap-table/locale/bootstrap-table-pt-BR.min.js"></script>

	<!--  Google Maps -->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCQ9qJsigEeh1SXJS7IZqB2yRSrgy0jKis"></script>

	<!-- Factories  -->
	<script type="text/javascript"
		src="assets/pages/js/factory/evento-factory.js"></script>
	<script type="text/javascript"
		src="assets/pages/js/factory/endereco-factory.js"></script>
	<script type="text/javascript"
		src="assets/pages/js/factory/organizador-factory.js"></script>
	<script type="text/javascript"
		src="assets/pages/js/factory/tipo-organizador-factory.js"></script>
	<script type="text/javascript"
		src="assets/pages/js/factory/programacao-factory.js"></script>
	<script type="text/javascript"
		src="assets/pages/js/factory/tipo-programacao-factory.js"></script>
	<script type="text/javascript"
		src="assets/pages/js/factory/palestrante-factory.js"></script>
	<script type="text/javascript"
		src="assets/pages/js/factory/mapa-factory.js"></script>
	<script type="text/javascript"
		src="assets/pages/js/factory/organizador-evento-factory.js"></script>

	<!-- Page Controller -->
	<script type="text/javascript"
		src="assets/pages/js/controller/evento-form-controller.js"></script>
	<script type="text/javascript"
		src="assets/pages/js/factory/id-factory.js"></script>

	<!-- Filtros -->
	<script type="text/javascript"
		src="assets/pages/js/filter/cep-filter.js"></script>

</body>

</html>
