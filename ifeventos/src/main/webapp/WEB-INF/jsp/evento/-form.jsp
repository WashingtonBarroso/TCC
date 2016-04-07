<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt">
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
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
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
                        <h1 class="page-header">Eventos</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">                    
							<ul class="nav nav-tabs">
								<li class="active">
									<a href="#tab1" data-toggle="tab">Dados do Evento</a>
								</li>
								<li>
									<a href="#tab2" data-toggle="tab">Mapa</a>
								</li>
								<li>
									<a href="#tab3" data-toggle="tab">Organização</a>
								</li>
								<li>
									<a href="#tab4" data-toggle="tab">Programação</a>
								</li>								
							</ul>
							<form id="form"
										action="/ifeventos/evento/save2" method="post"
										enctype="multipart/form-data">
								<div class="tab-content">
									<div class="tab-pane fade active in" id="tab1">
										<div class="form-group ">
											<div class="form-group">
	                                            <label>Evento: 
													<span class="required">*</span>
	                                            </label>
												<input class="form-control" id="nome" name="dto.evento.nome" value="${dto.evento.nome}" minlength="5" type="text" required />
	                                            <p class="help-block">Digite pelo menos 5 caracteres</p>
                                        	</div>											
										</div>
										<div class="form-group ">
											<label for="cemail" class="control-label">Local
												<span class="required">*</span>
											</label>
											<input class="form-control " id="local" name="dto.evento.local" value="${dto.evento.local}" required />
										</div>
										<div class="form-group ">
											<label for="curl" class="control-label">Website</label>											
											<input class="form-control " id="curl" type="url" name="dto.evento.site" value="${dto.evento.site}" />
										</div>
										<div class="form-group ">
											<label for="ccidade" class="control-label">Cidade
												<span class="required">*</span>
											</label>
											<input class="form-control " id="cidade" name="dto.evento.cidade" value="${dto.evento.cidade}" required />
										</div>
										<div class="form-group ">
											<label for="cestado" class="control-label">Estado
												<span class="required">*</span>
											</label>
											<input class="form-control " id="estado" name="dto.evento.estado" value="${dto.evento.estado}" required />
										</div>

										<div class="form-group">
											<label for="cupload" class="control-label">Carregar Imagem</label>
											 <input type="file" name="dto.imagem" />
										</div>

									</div>
									<div class="tab-pane fade" id="tab2">
										<p>
											 Insira o mapa do Google e com a função para inserir marcador e capturar a latitute e longitude para salvar no banco.
										</p>
									</div>
									<div class="tab-pane fade" id="tab3">
										<input id="teste" name="dto.teste" type="hidden" />
										
										<div class="col-lg-6">
						                    <div class="panel panel-default">
						                        <div class="panel-heading">
						                            Lista de Organizadores
						                        </div>
						                        <!-- /.panel-heading -->
						                        <div class="panel-body">
						                            <div class="dataTable_wrapper">
						                                <table class="table table-striped table-bordered table-hover" id="organizadoresTable">
						                                    <thead>
						                                        <tr>
						                                            <th>Nome</th>
						                                            <th>Ação</th>
						                                        </tr>
						                                    </thead>
						                                    <tbody>						                                        
						                                    </tbody>
						                                </table>
						                            </div>
						                        </div>
						                        <!-- /.panel-body -->
						                    </div>
						                    <!-- /.panel -->
						                </div>
						                <!-- /.col-lg-12 -->
										
										
										<div class="panel panel-default">
					                        <div class="panel-heading">
					                            Kitchen Sink
					                        </div>
					                        <!-- /.panel-heading -->
					                        <div class="panel-body">
					                            <div class="table-responsive">
					                                <table id="tableteste" class="table table-striped table-bordered table-hover">
					                                    <thead>
					                                        <tr>
					                                            <th>#</th>
					                                            <th>First Name</th>
					                                            <th>Last Name</th>
					                                            <th>Username</th>
					                                        </tr>
					                                    </thead>
					                                    <tbody>
					                                        <tr>
					                                            <td>1</td>
					                                            <td>Mark</td>
					                                            <td>Otto</td>
					                                            <td>@mdo</td>
					                                        </tr>
					                                        <tr>
					                                            <td>2</td>
					                                            <td>Jacob</td>
					                                            <td>Thornton</td>
					                                            <td>@fat</td>
					                                        </tr>
					                                        <tr>
					                                            <td>3</td>
					                                            <td>Larry</td>
					                                            <td>the Bird</td>
					                                            <td>@twitter</td>
					                                        </tr>
					                                    </tbody>
					                                </table>
					                            </div>
					                            <!-- /.table-responsive -->
					                        </div>
					                        <!-- /.panel-body -->
					                    </div>
									</div>
									<div class="tab-pane fade" id="tab4">
										<p>
											 Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party before they sold out master cleanse gluten-free squid scenester freegan cosby sweater. Fanny pack portland seitan DIY, art party locavore wolf cliche high life echo park Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table VHS viral locavore cosby sweater. Lomo wolf viral, mustache readymade thundercats keffiyeh craft beer marfa ethical. Wolf salvia freegan, sartorial keffiyeh echo park vegan.
										</p>
									</div>
								</div>
								<div class="form-group" style="float: right;">
										<div id="btn_save" class="btn btn-primary">
											<i class="fa fa-check"></i>
											Salvar
										</div>
										<div id="btn_cancel" class="btn btn-warning">
											<i class="fa fa-reply"></i>
											Voltar
										</div>
								</div>
							</form>
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

    <jsp:include page="/WEB-INF/jsp/template/scripts.jsp"/> 
    
    <!-- Bootstrap Table -->
    <script type="text/javascript" src="assets/global/bootstrap-table/bootstrap-table.min.js"></script>
	<script type="text/javascript" src="assets/global/bootstrap-table/extensions/angular/bootstrap-table-angular.min.js"></script>
	<script type="text/javascript" src="assets/global/bootstrap-table/locale/bootstrap-table-pt-BR.min.js"></script>
	

    <!-- Plugin JavaScript -->
    <script src="assets/js/jquery.tabletojson.min.js"></script>
    
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    
    </script>

</body>

</html>
