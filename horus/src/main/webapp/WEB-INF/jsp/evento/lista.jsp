<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Simple Sidebar - Start Bootstrap Template</title>

<!-- Bootstrap Core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/simple-sidebar.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="nav nav-pills nav-stacked">
				<li class="active"><a href="#">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Evento<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="/horus/evento/form">Cadastrar</a></li>
						<li><a href="/horus/evento/lista">Listar</a></li>
						<li><a href="#">Excluir</a></li>
					</ul></li>
				<li><a href="#">Menu 2</a></li>
				<li><a href="#">Menu 3</a></li>
			</ul>


		</div>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">

						<!--Table-->

						<table id="example" class="table table-striped table-bordered"
							cellspacing="0" width="100%">
							<thead>
								<tr>
									<th></th>
									<th>Nome</th>
									<th>Local</th>
									<th>Cidade</th>
									<th>Estado</th>
									<th>Site</th>
								</tr>
							</thead>

							<tfoot>
								<tr>
									<th></th>
									<th>Nome</th>
									<th>Local</th>
									<th>Cidade</th>
									<th>Estado</th>
									<th>Site</th>
								</tr>
							</tfoot>
							<tbody>
								<c:forEach items="${list}" var="evento">
									<tr>
										<td>${evento.id}</td>
										<td>${evento.nome}</td>
										<td>${evento.local}</td>
										<td>${evento.cidade}</td>
										<td>${evento.estado}</td>
										<td>${evento.site}</td>
									</tr>
									<td>
										<form action="<c:url value="/evento"/> method="post">
											<input name="dto.evento.id" value="${dto.evento.id}" type="hidden" />
											<button class="link" name="_method" value="DELETE">remover</button>
										</form>
									</td>
								</c:forEach>
							</tbody>
						</table>

						<!--Table-->

					</div>
				</div>
			</div>
			<!-- /#page-content-wrapper -->

		</div>
	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="../js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../js/bootstrap.min.js"></script>


	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>
</body>

</html>
