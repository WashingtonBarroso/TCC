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
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap theme -->
<link href="css/bootstrap-theme.css" rel="stylesheet">
<!--external css-->
<!-- font icon -->
<link href="css/elegant-icons-style.css" rel="stylesheet" />
<link href="css/font-awesome.min.css" rel="stylesheet" />
<!-- easy pie chart-->
<link href="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css"
	rel="stylesheet" type="text/css" media="screen" />
<!-- owl carousel -->
<link rel="stylesheet" href="css/owl.carousel.css" type="text/css">
<link href="css/jquery-jvectormap-1.2.2.css" rel="stylesheet">
<!-- Custom styles -->
<link rel="stylesheet" href="css/fullcalendar.css">
<link href="css/widgets.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/style-responsive.css" rel="stylesheet" />
<link href="css/jquery-ui-1.10.4.min.css" rel="stylesheet">
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

		<header class="header dark-bg">
			<div class="toggle-nav">
				<div class="icon-reorder tooltips" data-original-title="Ocultar"
					data-placement="bottom">
					<i class="icon_menu"></i>
				</div>
			</div>
			<!--logo start-->
			<a href="/ifeventos/" class="logo">IF<span class="lite">Eventos</span></a>
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
							<li><a class="" href="/ifeventos/evento/list">Consultar</a></li>
						</ul></li>

					<li class="sub-menu"><a href="javascript:;" class=""> <i
							class="icon_documents_alt"></i> <span>Not�cia</span> <span
							class="menu-arrow arrow_carrot-right"></span>
					</a>
						<ul class="sub">
							<li><a class="" href="/ifeventos/noticia/form">Cadastrar</a></li>
							<li><a class="" href="/ifeventos/noticia/list">Consultar</a></li>
						</ul></li>

					<li class="sub-menu"><a href="javascript:;" class=""> <i
							class="fa fa-users"></i> <span>Organizadores</span> <span
							class="menu-arrow arrow_carrot-right"></span>
					</a>
						<ul class="sub">
							<li><a class="" href="/ifeventos/organizador/form">Cadastrar</a></li>
							<li><a class="" href="/ifeventos/organizador/list">Consultar</a></li>
						</ul></li>

					<li class="sub-menu"><a href="javascript:;" class=""> <i
							class="icon_calendar"></i> <span>Programa��o</span> <span
							class="menu-arrow arrow_carrot-right"></span>
					</a>
						<ul class="sub">
							<li><a class="" href="/ifeventos/programacao/form">Cadastrar</a></li>
							<li><a class="" href="/ifeventos/programacao/list">Consultar</a></li>
						</ul></li>


					<li class="sub-menu"><a href="javascript:;" class=""> <i
							class="fa fa-user"></i> <span>Palestrantes</span> <span
							class="menu-arrow arrow_carrot-right"></span>
					</a>
						<ul class="sub">
							<li><a class="" href="/ifeventos/palestrante/form">Cadastrar</a></li>
							<li><a class="" href="/ifeventos/palestrante/list">Consultar</a></li>
						</ul></li>

					<!-- Menu tipo de organiza��o -->
					<li class="sub-menu"><a href="javascript:;" class=""><i class="fa fa-users"></i><span>Tp Organizador</span> <span class="menu-arrow arrow_carrot-right"></span></a>
						<ul class="sub">
							<li><a class="" href="/ifeventos/tipoOrganizador/form">Cadastrar</a></li>
							<li><a class="" href="/ifeventos/tipoOrganizador/list">Consultar</a></li>
						</ul></li>
					<!-- Fim submenu -->

					<!-- Menu tipo de programa��o  -->
					<li class="sub-menu"><a href="javascript:;" class=""><i class="icon_calendar"></i><span>Tp Programa��o</span> <span class="menu-arrow arrow_carrot-right"></span></a>
						<ul class="sub">
							<li><a class="" href="/ifeventos/tipoProgramacao/form">Cadastrar</a></li>
							<li><a class="" href="/ifeventos/tipoProgramacao/list">Consultar</a></li>
						</ul></li>
					<!-- Fim submenu -->

				</ul>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--sidebar end-->

		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<!--overview start-->
				<div class="row">
					<div class="col-lg-12">
						<h3 class="page-header">
							<i class="fa fa-home"></i> Home
						</h3>
						<ol class="breadcrumb">
							<li><i class="fa fa-home"></i><a href="/ifeventos/">Home</a></li>
						</ol>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
						<div class="info-box blue-bg">
							<a href="/ifeventos/evento/form"><i class="icon_document_alt"></i></a>
							<div class="title">Evento</div>
						</div>
						<!--/.info-box-->
					</div>
					<!--/.col-->

					<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
						<div class="info-box green-bg">
							<a href="/ifeventos/noticia/form"><i
								class="icon_documents_alt"></i></a>
							<div class="title">Not�cia</div>
						</div>
						<!--/.info-box-->
					</div>
					<!--/.col-->

					<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
						<div class="info-box dark-bg">
							<a href="/ifeventos/organizador/form"><i class="fa fa-users"></i></a>
							<div class="title">Organizadores</div>
						</div>
						<!--/.info-box-->
					</div>
					<!--/.col-->
					<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
						<div class="info-box yellow-bg">
							<a href="/ifeventos/tipoOrganizador/form"><i
								class="fa fa-users"></i></a>
							<div class="title">Tipo de Organizador</div>
						</div>
						<!--/.info-box-->
					</div>
					<!--/.col-->
				</div>
				<!--/.row-->

				<div class="row">
					<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
						<div class="info-box blue-bg">
							<a href="/ifeventos/programacao/form"><i
								class="icon_calendar"></i></a>
							<div class="title">Programa��o</div>
						</div>
						<!--/.info-box-->
					</div>
					<!--/.col-->

					<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
						<div class="info-box green-bg">
							<a href="/ifeventos/palestrante/form"><i class="fa fa-user"></i></a>
							<div class="title">Palestrante</div>
						</div>
						<!--/.info-box-->
					</div>
					<!--/.col-->

					<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
						<div class="info-box dark-bg">
							<a href="/ifeventos/mapa/form"><i
								class="fa fa-map-marker"></i></a>
							<div class="title">Mapa</div>
						</div>
						<!--/.info-box-->
					</div>
					<!--/.col-->

					<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
						<div class="info-box yellow-bg">
							<a href="/ifeventos/tipoProgramacao/form"><i
								class="icon_calendar"></i></a>
							<div class="title">Tipo de Programa��o</div>
						</div>
						<!--/.info-box-->
					</div>
					<!--/.col-->

				</div>
				<!--/.row-->

			</section>
		</section>
		<!--main content end-->
	</section>
	<!-- container section start -->

	<!-- javascripts -->
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui-1.10.4.min.js"></script>
	<script src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.min.js"></script>
	<!-- bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- nice scroll -->
	<script src="js/jquery.scrollTo.min.js"></script>
	<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
	<!-- charts scripts -->
	<script src="assets/jquery-knob/js/jquery.knob.js"></script>
	<script src="js/jquery.sparkline.js" type="text/javascript"></script>
	<script src="assets/jquery-easy-pie-chart/jquery.easy-pie-chart.js"></script>
	<script src="js/owl.carousel.js"></script>
	<!-- jQuery full calendar -->
	<script src="js/fullcalendar.min.js"></script>
	<!--script for this page only-->
	<script src="js/jquery.rateit.min.js"></script>
	<!-- custom select -->
	<script src="js/jquery.customSelect.min.js"></script>

	<!--custome script for all page-->
	<script src="js/scripts.js"></script>
	<!-- custom script for this page-->
	<script src="js/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="js/jquery-jvectormap-world-mill-en.js"></script>
	<script src="js/jquery.autosize.min.js"></script>
	<script src="js/jquery.placeholder.min.js"></script>
	<script src="js/gdp-data.js"></script>
	<script src="js/morris.min.js"></script>
	<script src="js/sparklines.js"></script>
	<script src="js/jquery.slimscroll.min.js"></script>
	<script>
		//knob
		$(function() {
			$(".knob").knob({
				'draw' : function() {
					$(this.i).val(this.cv + '%')
				}
			})
		});

		//carousel
		$(document).ready(function() {
			$("#owl-slider").owlCarousel({
				navigation : true,
				slideSpeed : 300,
				paginationSpeed : 400,
				singleItem : true

			});
		});

		//custom select box

		$(function() {
			$('select.styled').customSelect();
		});

		/* ---------- Map ---------- */
		$(function() {
			$('#map').vectorMap({
				map : 'world_mill_en',
				series : {
					regions : [ {
						values : gdpData,
						scale : [ '#000', '#000' ],
						normalizeFunction : 'polynomial'
					} ]
				},
				backgroundColor : '#eef3f7',
				onLabelShow : function(e, el, code) {
					el.html(el.html() + ' (GDP - ' + gdpData[code] + ')');
				}
			});
		});
	</script>

</body>
</html>
