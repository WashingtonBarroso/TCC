<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Creative - Bootstrap 3 Responsive Admin Template">
<meta name="author" content="GeeksLabs">
<meta name="keyword"
	content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
<link rel="shortcut icon" href="img/favicon.png">

<title></title>

<!-- Bootstrap CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap theme -->
<link href="../css/bootstrap-theme.css" rel="stylesheet">
<!--external css-->
<!-- font icon -->
<link href="../css/elegant-icons-style.css" rel="stylesheet" />
<link href="../css/font-awesome.min.css" rel="stylesheet" />
<!-- Custom styles -->
<link href="../css/style.css" rel="stylesheet">
<link href="../css/style-responsive.css" rel="stylesheet" />

<!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
      <script src="js/lte-ie7.js"></script>
    <![endif]-->
</head>

<body>
	<!-- container section start -->
	<section id="container" class="">
		<!--header start-->
		<header class="header dark-bg">
		<div class="toggle-nav">
                <div class="icon-reorder tooltips" data-original-title="Ocultar" data-placement="bottom"><i class="icon_menu"></i></div>
            </div>

			<!--logo start-->
			<a href="index.html" class="logo">IFG <span class="lite">Eventos</span></a>
			<!--logo end-->

			<div class="nav search-row" id="top_menu">
				<!--  search form start -->
				<ul class="nav top-menu">
					<li>
						<form class="navbar-form">
							<input class="form-control" placeholder="Search" type="text">
						</form>
					</li>
				</ul>
				<!--  search form end -->
			</div>

			<div class="top-nav notification-row">
				<!-- notificatoin dropdown start-->
				<ul class="nav pull-right top-menu">
								
					<!-- user login dropdown start-->
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <span class="profile-ava">
								<img alt="" src="img/avatar1_small.jpg">
						</span> <span class="username">IFG</span> <b class="caret"></b>
					</a>
						<ul class="dropdown-menu extended logout">
							<div class="log-arrow-up"></div>
							<li class="eborder-top"><a href="/ifeventos/evento/list"><i class="icon_document_alt"></i>Eventos</a></li>
							<li><a href="/ifeventos/noticia/list"><i class="icon_documents_alt"></i>Notícias</a></li>
							<li><a href="/ifeventos/organizador/list"><i class="fa fa-users"></i>Organizadores</a>
							</li>
							<li><a href="/ifeventos/organizador/list"><i class="icon_profile"></i>Palestrantes</a></li>
							<li><a href="/ifeventos/programacao/list"><i class="icon_calendar"></i>Programação</a></li>
							<li><a href="/ifeventos/tipoOrganizador/list"><i class="fa fa-users"></i>Tipo de Organizadores</a></li>
							<li><a href="/ifeventos/tipoProgramacao/list"><i class="icon_calendar"></i>Tipo de Programação</a></li>
							<li></li>
						</ul></li>
					<!-- user login dropdown end -->
				</ul>
				<!-- notificatoin dropdown end-->
			</div>
		</header>
		<!--header end-->

		<!--sidebar start-->
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu">
					<li class="active"><a class="" href="/ifeventos/"> <i
							class="icon_house_alt"></i> <span>Home</span>
					</a></li>
					<li class="sub-menu"><a href="javascript:;" class=""> <i
							class="icon_document_alt"></i> <span>Evento</span> <span
							class="menu-arrow arrow_carrot-right"></span>
					</a>
						<ul class="sub">
							<li><a class="" href="/ifeventos/evento/form">Cadastrar</a></li>
							<li><a class="" href="/ifeventos/evento/list">Listar</a></li>
						</ul></li>

					<li class="sub-menu"><a href="javascript:;" class=""> <i
							class="icon_documents_alt"></i> <span>Notícia</span> <span
							class="menu-arrow arrow_carrot-right"></span>
					</a>
						<ul class="sub">
							<li><a class="" href="/ifeventos/noticia/form">Cadastrar</a></li>
							<li><a class="" href="/ifeventos/noticia/list">Listar</a></li>
						</ul></li>

					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-map-marker"></i> <span>Mapa</span><span
							class="menu-arrow arrow_carrot-right"></span>
					</a>
						<ul class="sub">
							<li><a class="" href="/ifeventos/mapa/form">Cadastrar</a></li>
							<li><a class="" href="/ifeventos/mapa/list">Listar</a></li>
						</ul></li>
					<li class="sub-menu"><a href="javascript:;" class=""> <i
							class="fa fa-users"></i> <span>Organizadores</span> <span
							class="menu-arrow arrow_carrot-right"></span>
					</a>
						<ul class="sub">
							<li><a class="" href="/ifeventos/organizador/form">Cadastrar</a></li>
							<li><a class="" href="/ifeventos/organizador/list">Listar</a></li>

							<!-- submenu tipo de organização -->
							<li class="sub-menu"><a href="javascript:;" class=""> <span>Tipo
										de Organizador </span> <span class="menu-arrow arrow_carrot-right"></span></a>
								<ul class="sub">
									<li><a class="" href="/ifeventos/tipoOrganizador/form">Cadastrar</a></li>
									<li><a class="" href="/ifeventos/tipoOrganizador/list">Listar</a></li>
								</ul></li>
							<!-- Fim submenu -->

						</ul></li>


					<li class="sub-menu"><a href="javascript:;" class=""> <i
							class="icon_calendar"></i> <span>Programação</span> <span
							class="menu-arrow arrow_carrot-right"></span>
					</a>
						<ul class="sub">
							<li><a class="" href="/ifeventos/programacao/form">Cadastrar</a></li>
							<li><a class="" href="/ifeventos/programacao/list">Listar</a></li>

							<!-- submenu tipo de programação  -->
							<li class="sub-menu"><a href="javascript:;" class=""> <span>Tipo
										Programação</span> <span class="menu-arrow arrow_carrot-right"></span></a>
								<ul class="sub">
									<li><a class="" href="/ifeventos/tipoProgramacao/form">Cadastrar</a></li>
									<li><a class="" href="/ifeventos/tipoProgramacao/list">Listar</a></li>
								</ul></li>
							<!-- Fim submenu -->
						</ul></li>
					<li class="sub-menu"><a href="javascript:;" class=""> <i
							class="fa fa-user"></i> <span>Palestrantes</span> <span
							class="menu-arrow arrow_carrot-right"></span>
					</a>
						<ul class="sub">
							<li><a class="" href="/ifeventos/palestrante/form">Cadastrar</a></li>
							<li><a class="" href="/ifeventos/palestrante/list">Listar</a></li>
						</ul></li>

				</ul>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--sidebar end-->
		
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<div class="row">
					<div class="col-lg-12">
						<h3 class="page-header">
							<i class="fa fa-user"></i>Palestrante
						</h3>
						<ol class="breadcrumb">
							<li><i class="fa fa-home"></i><a href="/ifeventos/">Home</a></li>
							<li><i class="fa fa-user"></i>Palestrante</li>
							<li><i class="fa fa-search"></i>Consultar</li>
						</ol>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-12">
						<section class="panel">
							<header class="panel-heading"> Lista de Palestrantes </header>

							<table class="table table-striped table-advance table-hover">
								<tbody>
									<tr>
										<th><i class="fa fa-sort-numeric-asc"></i> Nº</th>
										<th><i class=""></i>Nome</th>
										<th><i class=""></i>Título</th>
										<th><i class=""></i>Resumo</th>
										<th><i class=""></i>Editar</th>
										<th><i class=""></i>Excluir</th>
									</tr>
									<c:forEach items="${list}" var="palestrante">
										<tr>
											<td>${palestrante.id}</td>
											<td>${palestrante.nome}</td>
											<td>${palestrante.titulo}</td>
											<td>${palestrante.resumo}</td>
											<td>
												<div class="btn-group">
													<form action="<c:url value="/palestrante/edit"/>" method="post">
														<input name="id" value="${palestrante.id}" type="hidden" />
														<button class="btn btn-info">
															<i class="fa fa-pencil-square-o"></i>
														</button>
													</form>
												</div>
											</td>
											<td>
												<div class="btn-group">
													<form action="<c:url value="/palestrante"/>" method="post">
														<input name="id" value="${palestrante.id}" type="hidden" />
														<button class="btn btn-danger" name="_method"
															value="DELETE">
															<i class="icon_close_alt2"></i>
														</button>
													</form>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</section>
					</div>
				</div>
				<!-- page end-->
			</section>
		</section>
		<!--main content end-->
	</section>
	<!-- container section end -->
	<!-- javascripts -->
	<script src="../js/jquery.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<!-- nicescroll -->
	<script src="../js/jquery.scrollTo.min.js"></script>
	<script src="../js/jquery.nicescroll.js" type="text/javascript"></script>
	<!--custome script for all page-->
	<script src="../js/scripts.js"></script>


</body>
</html>
