<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt" ng-app="app" ng-controller="MapaListController">
<head>
	<jsp:include page="/WEB-INF/jsp/template/head.jsp"/>
	<link href="assets/global/bootstrap-table/bootstrap-table.css" rel="stylesheet" type="text/css"/>
</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">IF Eventos - Administrativo</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">                
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> Meus Dados</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <jsp:include page="/WEB-INF/jsp/template/menu.jsp"/>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Mapa</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                <!-- 
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           	<h4>Organizador</h4>
                        </div>
                 -->
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="dataTable_wrapper">                                
                                <table id="table"
										data-classes="table table-hover table-condensed"
										data-url="http://localhost:8080/ifeventos/{{url}}/search"
       									data-side-pagination="server"
										data-striped="true"
										data-search="true"
										data-click-to-select="true"
       									data-show-refresh="true"
									    data-show-toggle="true"
       									data-show-columns="true"
       									data-show-export="true"
       									data-toolbar="#toolbar"
       									data-pagination="true"
       									data-toggle="table"
       									data-page-list="[5, 10, 20, 50, 100, 200]"       									
										>
									    <thead>
									    <tr>
									    	<th data-field="state" data-checkbox="true"></th>
									        <th class="col-xs-1" data-field="id" data-sortable="true">Código</th>
									        <th data-field="latitude" data-sortable="true">Latitude</th>						        
									        <th data-field="longitude" data-sortable="true">Longitude<th>
									    </tr>
									    </thead>
									</table>
									<div id="toolbar" class="btn-group">
									    <button type="button" class="btn btn-default" ng-click="newForm()">
									        <i class="glyphicon glyphicon-plus"></i>
									    </button>
									    <button type="button" class="btn btn-default">
									        <i class="glyphicon glyphicon-trash"></i>
									    </button>
									</div>
                                
                            </div>
                           <!-- 
                        </div>
                            -->
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <jsp:include page="/WEB-INF/jsp/template/scripts.jsp"/> 
    
    <!-- Bootstrap Table -->
    <script type="text/javascript" src="assets/global/bootstrap-table/bootstrap-table.min.js"></script>
	<script type="text/javascript" src="assets/global/bootstrap-table/extensions/angular/bootstrap-table-angular.min.js"></script>
	<script type="text/javascript" src="assets/global/bootstrap-table/locale/bootstrap-table-pt-BR.min.js"></script>
	
    <!-- Page Controller -->
	<script type="text/javascript" src="assets/pages/js/controller/mapa-list-controller.js"></script>
	
</body>

</html>
