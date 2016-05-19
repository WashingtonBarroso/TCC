<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt" ng-app="app" ng-controller="EventoFormController"
	ng-init='setDTO(${dto}); setListOrganizador(${listOrganizador}); setListProgramacao(${listProgramacao});'>
<head>
<jsp:include page="/WEB-INF/jsp/template/head.jsp" />
<link href="assets/global/bootstrap-table/bootstrap-table.css"
	rel="stylesheet" type="text/css" />
<link href="assets/pages/css/global.css" rel="stylesheet"
	type="text/css" />
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
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<div id="div_alert"></div>
								<ul class="nav nav-tabs">
									<li class="active"><a href="#tab1" data-toggle="tab">Dados
											do Evento</a></li>
									<li><a href="#tab2" data-toggle="tab">Imagem</a></li>
									<li><a href="#tab4" data-toggle="tab">Mapa</a></li>
									<li><a href="#tab5" data-toggle="tab">Organização</a></li>
									<li><a href="#tab6" data-toggle="tab">Programação</a></li>
								</ul>
								<form id="form" name="form" role="form"
									enctype="multipart/form-data" novalidate>
									<div class="tab-content">
										<div class="tab-pane fade tab-margin active in" id="tab1">
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
											<div class="form-group"
												ng-class="{'has-error':form.local.$invalid ,'has-success':form.local.$valid}">
												<label class="control-label">Local <span
													class="required">*</span>
												</label> <input class="form-control" type="text" name="local"
													placeholder="Digite o local do evento" ng-model="dto.local"
													required ng-maxlength="200"> <span
													class="help-block" ng-show="form.local.$error.required">
													<i class="fa fa-warning"></i> Favor inserir o dado
													requerido.
												</span> <span class="help-block"
													ng-show="form.local.$error.maxlength"> <i
													class="fa fa-warning"></i> O dado informado é muito grande.
												</span>
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
													class="fa fa-warning"></i> O dado informado é muito grande.
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
													class="fa fa-warning"></i> O dado informado é muito grande.
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
													class="fa fa-warning"></i> O dado informado é muito grande.
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
													class="fa fa-warning"></i> O dado informado é muito grande.
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
													class="fa fa-warning"></i> O dado informado é muito grande.
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
													class="fa fa-warning"></i> O dado informado é muito grande.
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
										<div class="tab-pane fade tab-margin" id="tab2">
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
										<div class="tab-pane fade tab-margin" id="tab4">
											<p>Insira o mapa do Google e com a função para inserir
												marcador e capturar a latitute e longitude para salvar no
												banco.</p>
										</div>
										<div class="tab-pane fade tab-margin" id="tab5">
											<div class="form-group input-group">
												<select ng-model="organizadorSelect" ng-options="organizador as organizador.nome for organizador in organizadores" name="organizadoresSelect" class="form-control">
												</select> <span class="input-group-btn">
													<button class="btn btn-default" type="button">
														<i class="fa fa-plus" ng-click="adicionarOrganizador(organizadorSelect)"></i>
													</button>
												</span>
											</div>
										</div>
										<div class="tab-pane fade tab-margin" id="tab6">
												<div class="form-group input-group">
												<select ng-model="programacaoSelect" ng-options="programacao as programacao.local for programacao in programacoes" name="programacaoSelect" class="form-control">
												</select> <span class="input-group-btn">
													<button class="btn btn-default" type="button">
														<i class="fa fa-plus" ng-click="adicionarProgramacao(programacaoSelect)"></i>
													</button>
												</span>
											</div>
										</div>
									</div>
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
											ng-click="remove()">
											<i class="fa fa-times"></i> Remover
										</div>
										<div id="cancelButton" class="btn btn-outline btn-default"
											ng-click="cancel()">
											<i class="fa fa-times"></i> Desistir
										</div>
									</div>
								</form>
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
			
	<!-- Page Controller -->
	<script type="text/javascript"
		src="assets/pages/js/controller/evento-form-controller.js"></script>

</body>

</html>
