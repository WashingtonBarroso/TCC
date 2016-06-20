<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt" ng-app="app" ng-controller="EventoFormController"
	ng-init='setDTO(${dto}); setListOrganizadores(${listOrganizador}); setListTipoOrganizadores(${listTpOrganizador}); setListTpProgramacao(${listTpProgramacao}); setListPalestrante(${listPalestrante});'>

<head>
<jsp:include page="/WEB-INF/jsp/template/head.jsp" />
<link href="assets/global/bootstrap-table/bootstrap-table.css"
	rel="stylesheet" type="text/css" />
<link href="assets/pages/css/global.css" rel="stylesheet"
	type="text/css" />
<link href="assets/global/bootstrap-wizard/bootstrap.min.css"
	rel="stylesheet" />
<link href="assets/global/bootstrap-wizard/prettify.css"
	rel="stylesheet" />
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
					<pre>
					{{dto | json}}
					</pre>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<div id="div_alert"></div>
								<div id="rootwizard">
									<div class="navbar">
										<div class="navbar-inner">
											<div class="container-right">
												<ul class="nav nav-pills">
													<li><a href="#tab1" data-toggle="tab">Dado do
															Evento</a></li>
													<li><a href="#tab2" data-toggle="tab">Mapa</a></li>
													<li><a href="#tab3" data-toggle="tab">Organização</a></li>
													<li><a href="#tab4" data-toggle="tab">Programação</a></li>
													<li><a href="#tab5" data-toggle="tab">Imagem</a></li>
												</ul>
											</div>
										</div>
									</div>
									<form id="form" name="form" role="form" novalidate>
										<!-- enctype="multipart/form-data" -->
										<div class="tab-content">
											<!-- Init tab1 -->
											<div class="tab-pane fade tab-margin" id="tab1">
												<div class="form-group"
													ng-class="{'has-error':form.nome.$invalid ,'has-success':form.nome.$valid}">
													<label class="control-label"> Evento: <span
														class="required"> * </span>
													</label>
													<div class="input-icon right">
														<input class="form-control" type="text" name="nome"
															placeholder="Digite a nome do evento" ng-model="dto.nome"
															required ng-maxlength="200"> <span
															class="help-block" ng-show="form.nome.$error.required">
															<i class="fa fa-warning"></i> Favor inserir o dado
															requerido.
														</span> <span class="help-block"
															ng-show="form.nome.$error.maxlength"> <i
															class="fa fa-warning"></i> O dado informado é muito
															grande.
														</span>
													</div>
												</div>
												<div class="form-group" ng-class="{'has-error':form.localEvento.$invalid ,'has-success':form.localEvento.$valid}">
													<label class="control-label">Local <span class="required">*</span>
													</label> <input class="form-control" type="text" name="localEvento" placeholder="Digite o local do evento" ng-model="dto.local" required ng-maxlength="200">
													<span class="help-block" ng-show="form.localEvento.$error.required"> 
														<i class="fa fa-warning"></i> Favor inserir o dado requerido.</span> 
													<span class="help-block" ng-show="form.localEvento.$error.maxlength">
														<i class="fa fa-warning"></i> O dado informado é muito grande.</span>
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
													ng-class="{'has-error':form.cep.$invalid ,'has-success':form.cep.$valid}">
													<label class="control-label">Cep <span
														class="required">*</span>
													</label> <input class="form-control" type="text" name="cep"
														placeholder="Digite o cep do evento"
														ng-model="dto.endereco.cep" required ng-maxlength="200">
													<span class="help-block" ng-show="form.cep.$error.required">
														<i class="fa fa-warning"></i> Favor inserir o dado
														requerido.
													</span> <span class="help-block"
														ng-show="form.cep.$error.maxlength"> <i
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
											
											<!-- Exit tab1 -->

											<!-- Init tab2 -->
											<div class="tab-pane fade tab-margin" id="tab2">
												<div class="form-group">
													<div
														ng-class="{'has-error':form.descricao.$invalid ,'has-success':form.descricao.$valid}">
														<label class="control-label"> Descrição: <span
															class="required"> * </span>
														</label>
														<div class="row">
															<div class="col-md-4">
																<input class="form-control" name="descricao" type="text"
																	ng-model="mapa.descricao" 
																	required ng-maxlength="11"> <span
																	class="help-block"
																	ng-show="form.descricao.$error.required"> <i
																	class="fa fa-warning"></i> Favor inserir o dado
																	requerido.
																</span> <span class="help-block"
																	ng-show="form.descricao.$error.maxlength"> <i
																	class="fa fa-warning"></i> O dado informado é muito
																	grande.
																</span>
															</div>
														</div>
													</div>
												</div>
												<p>{{mapa | json}}</p>
												<!-- Mapa -->
												
												<div id="map" class="img-responsive"
													style="width: 500px; height: 380px; margin-bottom: 1cm;"
													ng-init="initialize()"></div>
					
												<!-- Fim mapa -->
											
											<button class="btn btn-success" type="button" ng-click="adicionarMapa(mapa)">Adicionar</button>
										    <button class="btn btn-danger" type="button" ng-click="apagarMapa(listMapa)">Remover</button>
										   <br>
                                                    <!-- /.row -->
												<div class="row">
													<div class="col-lg-12">
														<div class="panel-body">
															<div class="table-responsive">
																<table
																	class="table table-striped table-bordered table-hover"
																	id="dataTablesMapa" ng-show="dto.mapas.length>0">
																	<thead>
																		<tr>
																		    <th></th>
																			<th>Descrição</th>
																			<th>Latitude</th>
																			<th>Longitude</th>
																		</tr>
																	</thead>
																	<tbody>
																		<tr ng-repeat="mapa in dto.mapas track by $index">
																			<td><input type="checkbox" ng-model="mapa.selecionado"></td>
																			<td>{{mapa.descricao}}</td>
																			<td>{{mapa.lat}}</td>
																			<td>{{mapa.lng}}</td>
																		</tr>
																	</tbody>
																</table>
															</div>
															<!-- /.table-responsive -->
														</div>
														<!-- /.panel-body -->
													</div>
													<!-- /.col-lg-12 -->
												</div>
												<!-- /.row -->							
                                          
                                            </div>
											<!-- Exit tab2 -->

                                            
											<!-- Init tab3 -->
											<div class="tab-pane fade tab-margin" id="tab3">

												<select class="form-control"
													ng-model="organizadorEvento.organizador"
													ng-options="organizador as organizador.nome for organizador in organizadores"
													name="organizador" class="form-control">
													<option value="">Selecione</option>
												</select> <br> <select class="form-control"
													ng-model="organizadorEvento.tipoOrganizador"
													ng-options="tipoOrganizador as tipoOrganizador.descricao for tipoOrganizador in tipoOrganizadores"
													name="organizador" class="form-control">
													<option value="">Selecione</option>
												</select> <br>
												<button class="btn btn-success" type="button"
													ng-click="adicionarOrganizador(organizadorEvento)">Adicionar</button>
												<button class="btn btn-danger" type="button"
													ng-click="apagarOrganizador(listOrganizador)">Remover</button>

												<!-- /.row -->
<!-- 												<div class="row">
													<div class="col-lg-12">
														<div class="panel-body">
															<div class="table-responsive">
																<table data-toggle="table" data-toggle="table"
																	data-url=""
																	data-pagination="true" data-search="true"
																	data-height="300">
																<thead>
																		<tr>
																			<th></th>
																			<th data-field="nome">Nome</th>
																			<th data-field="cargo">Cargo</th>
																			<th data-field="area">Área</th>
																			<th data-field="tipoOrganizador">Tipo
																				Organizador</th>
																		</tr>
																	</thead>
																	<tbody>
																		<tr ng-repeat="organizador in organizadores">
																			<td><input type="checkbox"
																				ng-model="organizador.selecionado"></td>
																			<td>{{organizador.nome}}</td>
																			<td>{{organizador.cargo}}</td>
																			<td>{{organizador.area}}</td>
																			<td>{{organizador.tipoOrganizador.descricao}}</td>
																		</tr>
																	</tbody>
																</table>
															</div>
															/.table-responsive
														</div>
														/.panel-body
													</div>
													/.col-lg-12
												</div>
												/.row -->
												
											</div>
											<!-- Exit tab3 -->
											
											
											<!-- Início tab4 -->
											<div class="tab-pane fade tab-margin" id="tab4">
												<!-- /.row -->
												<div class="row">
													<div class="col-lg-12">
														<div class="panel-body">
															<div class="row">
																<div class="col-lg-12">
																	<div id="div_alert"></div>
																	<div class="form-group">
																		<div
																			ng-class="{'has-error':form.descricao.$invalid ,'has-success':form.descricao.$valid}">
																			<label class="control-label"> Descrição: <span
																				class="required"> * </span>
																			</label>
																			<div class="input-icon right">
																				<input class="form-control"
																					placeholder="Descreva a programação"
																					name="descricao" type="text"
																					ng-model="programacao.descricao" required
																					ng-maxlength="150"> <span
																					class="help-block"
																					ng-show="form.descricao.$error.required"> <i
																					class="fa fa-warning"></i> Favor inserir o dado
																					requerido.
																				</span> <span class="help-block"
																					ng-show="form.descricao.$error.maxlength"> <i
																					class="fa fa-warning"></i> O dado informado é muito
																					grande.
																				</span>
																			</div>
																		</div>
																	</div>

																	<div class="form-group">
																		<div
																			ng-class="{'has-error':form.localProgramacao.$invalid ,'has-success':form.localProgramacao.$valid}">
																			<label class="control-label"> Local: <span
																				class="required"> * </span>
																			</label>
																			<div class="input-icon right">
																				<input class="form-control"
																					placeholder="Digite o local"
																					name="localProgramacao" type="text"
																					ng-model="programacao.local" required
																					ng-maxlength="20"> <span class="help-block"
																					ng-show="form.localProgramacao.$error.required">
																					<i class="fa fa-warning"></i> Favor inserir o dado
																					requerido.
																				</span> <span class="help-block"
																					ng-show="form.localProgramacao.$error.maxlength">
																					<i class="fa fa-warning"></i> O dado informado é
																					muito grande.
																				</span>
																			</div>
																		</div>
																	</div>

																	<div class="form-group">
																		<div
																			ng-class="{'has-error':form.data.$invalid ,'has-success':form.data.$valid}">
																			<label class="control-label"> Data: <span
																				class="required"> * </span>
																			</label> <input type="text" name="data" class="form-control"
																				ng-model="programacao.data"
																				value="{{programacao.data}}" required> <span
																				class="help-block"
																				ng-show="form.data.$error.required"> <i
																				class="fa fa-warning"></i> Favor inserir o dado
																				requerido.
																			</span>
																		</div>
																	</div>

																	<div class="form-group">
																		<div
																			ng-class="{'has-error':form.hora.$invalid ,'has-success':form.hora.$valid}">
																			<label class="control-label"> Hora: <span
																				class="required"> * </span>
																			</label> <input type="text" name="hora" class="form-control"
																				ng-model="programacao.hora"
																				value="{{programacao.hora}}" required> <span
																				class="help-block"
																				ng-show="form.hora.$error.required"> <i
																				class="fa fa-warning"></i> Favor inserir o dado
																				requerido.
																			</span>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="control-label"> Palestrante: <span
																			class="required"> * </span>
																		</label>
																		<div class="input-icon right">
																			<select class="form-control" name="palestrante"
																				ng-model="programacao.palestrante"
																				ng-options="palestrante as palestrante.nome for palestrante in palestrantes">
																				<option value="">Selecione</option>
																			</select>
																		</div>
																	</div>
																	<div class="form-group">
																		<label class="control-label"> Tipo
																			Programação: <span class="required"> * </span>
																		</label>
																		<div class="input-icon right">
																			<select class="form-control" name="tipoProgramacao"
																				ng-model="programacao.tipoProgramacao"
																				ng-options="tipoProgramacao as tipoProgramacao.descricao for tipoProgramacao in tiposProgramacao">
																				<option value="">Selecione</option>
																			</select>
																		</div>
																	</div>
																	<button class="btn btn-success" type="button"
																		ng-click="adicionarProgramacao(programacao)">Adicionar</button>
																	<button class="btn btn-danger" type="button"
																		ng-click="apagarProgramacao(listProgramacao)">Remover</button>
																	<br>
																</div>

															</div>
														</div>
														<!-- /.col-lg-12 -->
													</div>
												</div>
												<!-- /.row -->
												<!-- /.row -->
												<div class="row">
													<div class="col-lg-12">
														<div class="panel-body">
															<div class="table-responsive">
																<table
																	class="table table-striped table-bordered table-hover"
																	id="dataTablesProgramacao"
																	ng-show="programacoes.length>0">
																	<thead>
																		<tr>
																			<th></th>
																			<th>Descrição</th>
																			<th>Data</th>
																			<th>Hora</th>
																			<th>Local</th>
																			<th>Palestrante</th>
																			<th>Tipo Programação</th>
																		</tr>
																	</thead>
																	<tbody>
																		<tr
																			ng-repeat="programacao in programacoes track by $index">
																			<td><input type="checkbox"
																				ng-model="programacao.selecionado"></td>
																			<td>{{programacao.descricao}}</td>
																			<td>{{programacao.data.value | date: 'dd.MM.y'}}</td>
																			<td>{{programacao.hora.value | date: 'h:mm'}}</td>
																			<td>{{programacao.local}}</td>
																			<td>{{programacao.palestrante.nome}}</td>
																			<td>{{programacao.tipoProgramacao.descricao}}</td>
																		</tr>
																	</tbody>
																</table>
															</div>
															<!-- /.table-responsive -->
														</div>
														<!-- /.panel-body -->
													</div>
													<!-- /.col-lg-12 -->
												</div>
												<!-- /.row -->

											</div>
											<!-- Exit tab4 -->
															
										
											<!-- Início tab 5  -->
											<div class="tab-pane fade tab-margin" id="tab5">
													
											<!-- 	<div class="form-group"
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
											 -->	
                                                <!-- Grup button  -->
												<div class="form-group" style="float: right;">
													<div id="newButton" class="btn btn-primary"
														ng-click="newForm()">
														<i class="fa fa-file-o"></i> Limpar
													</div>
													<div id="saveButton" class="btn btn-success"
														ng-click="save()"> <!-- ng-disabled="form.$invalid" -->
														<i class="fa fa-check"></i> Salvar
													</div>
													<div id="removeButton" class="btn btn-danger"
														ng-click="remove()">
														<i class="fa fa-times"></i> Remover
													</div>
													<div id="cancelButton" class="btn btn-outline btn-default"
														ng-click="cancel()">
														<i class="fa fa-times"></i> Desistir
													</div>
												</div>
												<!-- Fim button -->
											</div>
											<!-- Fim tab 5 -->
							              </form>
							              				
											<!-- Steps wizard -->
											<ul class="pager wizard">
												<li class="previous first" style="display: none;"><a
													href="#">First</a></li>
												<li class="previous"><a href="#">Previous</a></li>
												<li class="next last" style="display: none;"><a
													href="#">Last</a></li>
												<li class="next"><a href="#">Next</a></li>
											</ul>
											<!-- Fim wizard -->
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
		src="assets/global/bootstrap-table/bootstrap-table.min.js"></script>
	<script type="text/javascript"
		src="assets/global/bootstrap-table/extensions/angular/bootstrap-table-angular.min.js"></script>
	<script type="text/javascript"
		src="assets/global/bootstrap-table/locale/bootstrap-table-pt-BR.min.js"></script>
    <script> $(function (){
    	$('#dataTablesOrganizador').bootstrapTable({
    	data:listOrganizadores
    });
    });
    </script>

	<!--  Google Maps -->
	<script src="http://maps.googleapis.com/maps/api/js"></script>

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
		src="assets/pages/js/controller/programacao-form-controller.js"></script>

	<!-- Boostraps Wizard  -->
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="assets/global/bootstrap-wizard/bootstrap.min.js"> </script>
	<script
		src="assets/global/bootstrap-wizard/jquery.bootstrap.wizard.min.js"> </script>
	<script src="assets/global/bootstrap-wizard/prettify.js"> </script>

	<script>
	$(document).ready(function() {
	  	$('#rootwizard').bootstrapWizard();
	});
	</script>
</body>

</html>