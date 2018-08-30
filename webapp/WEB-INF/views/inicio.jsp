<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Subir archivo</title>

<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/" var="urlRoot"></spring:url>
<spring:url value="/pdf/lista" var="urlDocPdf" />
<spring:url value="/usuario/edit" var="urlDocComp" />
<spring:url value="/usuario/lista" var="urlUsuario" />

<spring:url value="/pdf/lista2" var="urlListarById"></spring:url>

<spring:url value="/pdf/lista3" var="urlListarByIdUsModifica"></spring:url>

<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>

<body>

	<!-- Fixed navbar -->
	<jsp:include page="includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<div class="page-header">
			<h3 class="blog-title">
				<!-- 				<span class="label label-success">Datos</span> -->
			</h3>
		</div>
		<div class="row">
			<!--inicio del row 1 -->
			<div class="col-md-6 ">
				<%--inicio del form --%>
				<form:form action="${urlListarById}" method="post"
					modelAttribute="documentoPdf">
					<div class="row"></div>
					<div class="row">
						<div class="col-sm-3">
							<div class="form-group">
								<label for="idEncargado" class="control-label">Documentos
									recibidos por:</label>
								<form:select id="idEncargado" path="idEncargado"
									class="form-control" items="${usuario}"
									itemLabel="nombreCompleto" itemValue="idUsuario" />
							</div>
						</div>
					</div>

					<button type="submit" class="btn btn-primary">Aceptar</button>
				</form:form>
				<!-- 			fin del form -->
			</div>
			<div class="col-md-6 ">
				<%--inicio del form2 --%>
				<form:form action="${urlListarByIdUsModifica}" method="post"
					modelAttribute="documentoPdf">
					<div class="row"></div>
					<div class="row">
						<div class="col-sm-3">
							<div class="form-group">
								<label for="idEncargado" class="control-label">Documentos
									modificados por por:</label>
								<form:select id="idEncargado" path="idEncargado"
									class="form-control" items="${usuario}"
									itemLabel="nombreCompleto" itemValue="idUsuario" />
							</div>
						</div>
					</div>

					<button type="submit" class="btn btn-primary">Aceptar</button>
				</form:form>
				<!-- 			fin del form2 -->
			</div>
		</div>
		<!--fin del row 1 -->


		<br> <br>
		<br>
		<div class="row">
			<div class="col-md-4 ">
				<a href="${urlDocPdf}" class="btn btn-success " role="button"
					title="Nueva Pelicula">Documentos pdf</a><br> <br>
			</div>
			<div class="col-md-4">
				<a href="${urlCreate}" class="btn btn-success" role="button"
					title="Nueva Pelicula">Documentos compartidos</a><br> <br>
			</div>
			<div class="col-md-4">
				<a href="${urlUsuario}" class="btn btn-success" role="button"
					title="Nueva Pelicula">Trabajadores</a><br> <br>
			</div>
		</div>

		<hr class="featurette-divider">

		<!-- FOOTER -->
		<jsp:include page="includes/footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#fechaEstreno").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});

		$(function() {
			$("#fechaEntrada").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
		fechaRecibida
		$(function() {
			$("#fechaRecibida").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>
</body>
</html>
