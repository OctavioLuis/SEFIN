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
<spring:url value="/dependencia/save" var="urlForm"></spring:url>
<spring:url value="/dependencia/lista" var="urlListar"></spring:url>

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
				<span class="label label-success">Datos de la dependencia</span>
			</h3>
		</div>

		<c:if test="${msg!=null }">
			<div class='alert alert-success' role="alert">${ msg }</div>
		</c:if>
		<spring:hasBindErrors name="documentoPdf">
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
			enctype="multipart/form-data" modelAttribute="dependencia">
			<div class="row"></div>



			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<form:hidden path="idDependencia" />

					</div>
				</div>


				<div class="col-sm-3">
					<div class="form-group">
						<label for="nombre">Nombre de la dependencia</label>
						<form:input type="text" class="form-control" path="nombre"
							id="nombre" />
					</div>
				</div>

<!-- 				Search Product <input type="search" id="productName" name="productName" autocomplete="on" /> -->




			</div>







			<button type="submit" class="btn btn-success">Guardar</button>
			<a href="${urlListar}" class="btn btn-danger" role="button"
				title="Nueva Pelicula">Cancelar</a>
			<br>
			<br>
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
	
	

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<script type="text/javascript">
		$(function() {
			$("#fechaEstreno").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});

 	</script> 
</body>
</html>
