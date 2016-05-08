<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt" ng-app="app" ng-controller="NoticiaFormController"  ng-init='setDTO(${dto});'>
<head>
<jsp:include page="/WEB-INF/jsp/template/head.jsp" />
<link href="assets/global/bootstrap-table/bootstrap-table.css" rel="stylesheet" type="text/css" />
<link href="assets/pages/css/global.css" rel="stylesheet" type="text/css" />
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
					<h1 class="page-header">Notícia</h1>
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
									<div class="form-group" 
										ng-class="{'has-error':form.mensagem.$invalid ,'has-success':form.mensagem.$valid}">
										<label class="control-label">
									        Mensagem: <span
											class="required">*</span>
										</label>
										<div class="input-icon right">
											<textarea class="form-control" placeholder="Digite a mensagem"
												name="mensagem" ng-model="dto.mensagem"
												required ng-maxlength="120">	
											</textarea>												
											<span class="help-block"
												ng-show="form.mensagem.$error.required">
												<i class="fa fa-warning"></i>
												Favor inserir o dado requerido.</span> 
											<span class="help-block"												
												ng-show="form.mensagem.$error.maxlength">
												<i class="fa fa-warning"></i>
												O dado informado é muito grande.</span>
										</div>
									</div>
									<div class="form-group" style="float: right;">
										<div id="newButton" class="btn btn-primary"
											ng-click="newForm()">
											<i class="fa fa-file-o"></i> Limpar
										</div>
										<div id="saveButton" class="btn btn-success" 
											ng-click="save()"
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
		src="assets/pages/js/factory/noticia-factory.js"></script>
	<script type="text/javascript"
		src="assets/pages/js/controller/noticia-form-controller.js"></script>
</body>

</html>