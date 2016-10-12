<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt" ng-app="app" ng-controller="OrganizadorFormController"
	ng-init='setDTO(${dto});'>
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
					<h1 class="page-header">Organizador</h1>
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
											ng-class="{'has-error':form.nome.$invalid ,'has-success':form.nome.$valid}">
											<label class="control-label"> Nome: <span
												class="required"> * </span>
											</label>
											<div class="input-icon right">
												<input class="form-control" placeholder="Digite o nome"
													name="nome" type="text" ng-model="dto.nome" required
													maxlength="100">
												<div class="validation-messages help-block"
													ng-messages="form.nome.$error">
													<div ng-message="required">
														<i class="fa fa-warning"></i> Esse campo é obrigatório!
													</div>
												</div>
											</div>
										</div>

										<div
											ng-class="{'has-error':form.cargo.$invalid ,'has-success':form.cargo.$valid}">
											<label class="control-label"> Cargo: <span
												class="required"> * </span>
											</label>
											<div class="input-icon right">
												<input class="form-control"
													placeholder="Digite o cargo do organizador" name="cargo"
													type="text" ng-model="dto.cargo" required maxlength="20">
												<div class="validation-messages help-block"
													ng-messages="form.cargo.$error">
													<div ng-message="required">
														<i class="fa fa-warning"></i> Esse campo é obrigatório!
													</div>
												</div>
											</div>
										</div>

										<div
											ng-class="{'has-error':form.area.$invalid ,'has-success':form.area.$valid}">
											<label class="control-label"> Área: <span
												class="required"> * </span>
											</label>
											<div class="input-icon right">
												<input class="form-control" placeholder="Digite a área"
													name="area" type="text" ng-model="dto.area" required
													maxlength="50">
												<div class="validation-messages help-block"
													ng-messages="form.area.$error">
													<div ng-message="required">
														<i class="fa fa-warning"></i> Esse campo é obrigatório!
													</div>
												</div>
											</div>
										</div>

										<div>
											<label class="control-label"> Site: </label>
											<div class="input-icon right">
												<input class="form-control" placeholder="Digite a url"
													name="url" type="text" ng-model="dto.url" maxlength="50">
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
											ng-class="{'ng-hide' : dto.id==null}" ng-click="remove()">
											<i class="fa fa-times"></i> Remover
										</div>
										<div id="cancelButton" class="btn btn-outline btn-default"
											ng-click="cancel()">
											<i class="fa fa-reply"></i> Voltar
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
		src="assets/pages/js/factory/id-factory.js"></script>
	<script type="text/javascript"
		src="assets/pages/js/factory/organizador-factory.js"></script>
	<script type="text/javascript"
		src="assets/pages/js/controller/organizador-form-controller.js"></script>

</body>

</html>
