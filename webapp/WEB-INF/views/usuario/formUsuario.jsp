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
<title>Creacion de Peliculas</title>

<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/usuario/save" var="urlForm"></spring:url>
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>

<body>

	<!-- Fixed navbar -->
	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<div class="page-header">
			<h3 class="blog-title">
				<span class="label label-success">Datos del usuario</span>
			</h3>
		</div>

		<c:if test="${msg!=null }">
			<div class='alert alert-success' role="alert">${ msg }</div>
		</c:if>
		<spring:hasBindErrors name="usuario">
			<div class='alert alert-danger' role='alert'>
				Por favor corrija los siguientes errores:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>

		<%-- 		${documentoPdf } --%>
		<form:form action="${urlForm}" method="post"
			enctype="multipart/form-data" modelAttribute="usuario">
			<div class="row"></div>



			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="nombre">nombre</label>
						<form:hidden path="idUsuario" />
						<form:input type="text" class="form-control" path="nombre"
							id="nombre" required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="apellidoP">apellidoP</label>
						<form:input type="text" class="form-control" path="apellidoP"
							id="apellidoP" required="required" />
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">
						<label for="maternoM">maternoM</label>
						<form:input type="text" class="form-control" path="maternoM"
							id="maternoM" required="required" />
					</div>
				</div>


			</div>

			<div class="row">

				<div class="col-sm-3">
					<div class="form-group">
						<label for=cargo>cargo</label>
						<form:input type="text" class="form-control" path="cargo"
							id="cargo" required="required" />
					</div>
				</div>


				<div class="col-sm-3">
					<div class="form-group">
						<label for="usuario">usuario</label>
						<form:input type="text" class="form-control" path="usuario"
							id="usuario" required="required" />
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">
						<label for="pasw">pasw</label>
						<form:input type="text" class="form-control" path="pasw" id="pasw"
							required="required" />
					</div>
				</div>
			</div>

			<div class="row"></div>
			<button type="submit" class="btn btn-danger">Guardar</button>
		</form:form>

		<hr class="featurette-divider">

		<!-- FOOTER -->
		<jsp:include page="../includes/footer.jsp"></jsp:include>

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
	</script>
</body>
</html>
