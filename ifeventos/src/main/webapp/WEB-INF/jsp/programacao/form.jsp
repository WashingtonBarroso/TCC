<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt" ng-app="app" ng-controller="ProgramacaoFormController"
	ng-init='setDTO(${dto}); setListTpProgramacao(${listTpProgramacao});'>
<head>
<jsp:include page="/WEB-INF/jsp/template/head.jsp" />
<link href="assets/global/bootstrap-table/bootstrap-table.css"
	rel="stylesheet" type="text/css" />
<link href="assets/pages/css/global.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet"
	href="assets/global/bootstrap/css/bootstrap.min.css" />
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
		<!-- /.navbar-static-side --> </nav>

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Palestras</h1>
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
								<form id="form" name="form" role="form" novalidate>
									<div class="form-group">
										<div
											ng-class="{'has-error':form.local.$invalid ,'has-success':form.local.$valid}">
											<label class="control-label"> Local: <span
												class="required"> * </span>
											</label>
											<div class="input-icon right">
												<input class="form-control" placeholder="Digite o local"
													name="local" type="text" ng-model="dto.local" required
													ng-maxlength="20"> 
											    <span class="help-block"
													ng-show="form.local.$error.required"> 
													<i class="fa fa-warning"></i> Favor inserir o dado requerido.
												</span> 
												<span class="help-block" ng-show="form.local.$error.maxlength">
												  	<i class="fa fa-warning"></i> O dado informado é muito grande.
												</span>
											</div>
										</div>
									</div>
                                   
                                    <div class="form-group">
                                    	<div ng-class="{'has-error':form.data.$invalid ,'has-success':form.data.$valid}">
											<label class="control-label"> Data: <span
												class="required"> * </span>
											</label>
											<input type="date" name="data" class="form-control" ng-model="dto.data.value" value="{{dto.data.value}}" required>
								    	     <span class="help-block"
													ng-show="form.data.$error.required"> 
													<i class="fa fa-warning"></i> Favor inserir o dado requerido.
											</span> 
								    	</div>
								    </div>
								    
								    <div class="form-group">
										<div ng-class="{'has-error':form.hora.$invalid ,'has-success':form.hora.$valid}">
											<label class="control-label"> Hora: <span
												class="required"> * </span> </label>
											<input type="time" name="hora" class="form-control" ng-model="dto.hora.value" value="{{dto.hora.value}}" required>
											 <span class="help-block"
													ng-show="form.hora.$error.required"> 
													<i class="fa fa-warning"></i> Favor inserir o dado requerido.
											</span> 		
				                    	</div>
				                    </div>
				                  	
									<div class="form-group"> 
										<label class="control-label"> Tipo Palestra: <span
											class="required"> * </span>
										</label>
										<div class="input-icon right">
											<select class="form-control" name="tipoPalestraid"
												ng-model="tipoPalestraId">
												<option ng-repeat="tipo in tiposPalestras" value="{{tipo.id}}">{{tipo.descricao}}</option>
										   </select>
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

	<!-- Page Controller -->
	<script type="text/javascript"
		src="assets/pages/js/factory/programacao-factory.js"></script>
	<script type="text/javascript"
		src="assets/pages/js/factory/tipo-programacao-factory.js"></script>
	<script type="text/javascript"
		src="assets/pages/js/controller/programacao-form-controller.js"></script>

</body>

</html>