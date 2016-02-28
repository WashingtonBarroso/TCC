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
<!-- date picker -->

<!-- color picker -->

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
				<div class="icon-reorder tooltips" data-original-title="Ocultar"
					data-placement="bottom">
					<i class="icon_menu"></i>
				</div>
			</div>

			<!--logo start-->
			<a href="/ifeventos/" class="logo">IFG <span class="lite">Eventos</span></a>
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
							<li class="eborder-top"><a href="/ifeventos/evento/list"><i
									class="icon_document_alt"></i>Eventos</a></li>
							<li><a href="/ifeventos/noticia/list"><i
									class="icon_documents_alt"></i>Not�cias</a></li>
							<li><a href="/ifeventos/organizador/list"><i
									class="fa fa-users"></i>Organizadores</a></li>
							<li><a href="/ifeventos/organizador/list"><i
									class="icon_profile"></i>Palestrantes</a></li>
							<li><a href="/ifeventos/programacao/list"><i
									class="icon_calendar"></i>Programa��o</a></li>
							<li><a href="/ifeventos/tipoOrganizador/list"><i
									class="fa fa-users"></i>Tipo de Organizadores</a></li>
							<li><a href="/ifeventos/tipoProgramacao/list"><i
									class="icon_calendar"></i>Tipo de Programa��o</a></li>
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
							class="icon_documents_alt"></i> <span>Not�cia</span> <span
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

							<!-- submenu tipo de organiza��o -->
							<li class="sub-menu"><a href="javascript:;" class=""> <span>Tipo
										de Organizador </span> <span class="menu-arrow arrow_carrot-right"></span></a>
								<ul class="sub">
									<li><a class="" href="/ifeventos/tipoOrganizador/form">Cadastrar</a></li>
									<li><a class="" href="/ifeventos/tipoOrganizador/list">Listar</a></li>
								</ul></li>
							<!-- Fim submenu -->

						</ul></li>


					<li class="sub-menu"><a href="javascript:;" class=""> <i
							class="icon_calendar"></i> <span>Programa��o</span> <span
							class="menu-arrow arrow_carrot-right"></span>
					</a>
						<ul class="sub">
							<li><a class="" href="/ifeventos/programacao/form">Cadastrar</a></li>
							<li><a class="" href="/ifeventos/programacao/list">Listar</a></li>

							<!-- submenu tipo de programa��o  -->
							<li class="sub-menu"><a href="javascript:;" class=""> <span>Tipo
										Programa��o</span> <span class="menu-arrow arrow_carrot-right"></span></a>
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
							<i class="fa fa-file-text-o"></i>Evento
						</h3>
						<ol class="breadcrumb">
							<li><i class="fa fa-home"></i><a href="/ifeventos/">Home</a></li>
							<li><i class="icon_document_alt"></i>Evento</li>
							<li><i class="fa fa-file-text-o"></i>Cadastro</li>
						</ol>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<section class="panel">
							<header class="panel-heading"> Cadastro Evento </header>
							<div class="panel-body">
								<div class="form">
									<form class="form-validate form-horizontal" id="feedback_form"
										action="/ifeventos/evento/save" method="post"
										enctype="multipart/form-data">
										<div class="form-group ">
											<label for="cname" class="control-label col-lg-2">Evento
												<span class="required">*</span>
											</label>
											<div class="col-lg-10">
												<input class="form-control" id="nome" name="dto.evento.nome"
													value="${dto.evento.nome}" minlength="5" type="text"
													required />
											</div>
										</div>
										<div class="form-group ">
											<label for="cemail" class="control-label col-lg-2">Local
												<span class="required">*</span>
											</label>
											<div class="col-lg-10">
												<input class="form-control " id="local"
													name="dto.evento.local" value="${dto.evento.local}"
													required />
											</div>
										</div>
										<div class="form-group ">
											<label for="curl" class="control-label col-lg-2">Website</label>
											<div class="col-lg-10">
												<input class="form-control " id="curl" type="url"
													name="dto.evento.site" value="${dto.evento.site}" />
											</div>
										</div>
										<div class="form-group ">
											<label for="ccidade" class="control-label col-lg-2">Cidade
												<span class="required">*</span>
											</label>
											<div class="col-lg-10">
												<input class="form-control " id="cidade"
													name="dto.evento.cidade" value="${dto.evento.cidade}"
													required />
											</div>
										</div>
										<div class="form-group ">
											<label for="cestado" class="control-label col-lg-2">Estado
												<span class="required">*</span>
											</label>
											<div class="col-lg-10">
												<input class="form-control " id="estado"
													name="dto.evento.estado" value="${dto.evento.estado}"
													required />
											</div>
										</div>

										<div class="form-group">
											<label for="cupload" class="control-label col-lg-2">Carregar
												foto</label>
											<div class="col-lg-10">
											 <input type="file"
													name="imagem" />
											</div>
										</div>

										<div class="form-group">
											<div class="col-lg-offset-2 col-lg-10">
												<input class="btn btn-success" type="submit" value="Salvar">
												<a href="/ifeventos/evento/form" class="btn btn-danger">Cancelar</a>
											</div>
										</div>
									</form>
								</div>
							</div>
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
	<!-- nice scroll -->
	<script src="../js/jquery.scrollTo.min.js"></script>
	<script src="../js/jquery.nicescroll.js" type="text/javascript"></script>

	<!-- jquery ui -->
	<script src="../js/jquery-ui-1.9.2.custom.min.js"></script>

	<!--custom checkbox & radio-->
	<script type="text/javascript" src="../js/ga.js"></script>
	<!--custom switch-->
	<script src="../js/bootstrap-switch.js"></script>
	<!--custom tagsinput-->
	<script src="../js/jquery.tagsinput.js"></script>

	<!-- colorpicker -->

	<!-- bootstrap-wysiwyg -->
	<script src="../js/jquery.hotkeys.js"></script>
	<script src="../js/bootstrap-wysiwyg.js"></script>
	<script src="../js/bootstrap-wysiwyg-custom.js"></script>
	<!-- ck editor -->
	<script type="text/javascript" src="../assets/ckeditor/ckeditor.js"></script>
	<!-- custom form component script for this page-->
	<script src="../js/form-component.js"></script>
	<!-- custome script for all page -->
	<script src="../js/scripts.js"></script>
	<!-- jquery validate js -->
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>

	<!-- custom form validation script for this page-->
	<script src="../js/form-validation-script.js"></script>

</body>
</html>
