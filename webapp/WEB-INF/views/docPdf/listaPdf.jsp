<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Listado de Docuemnto</title>

<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/" var="urlRoot"></spring:url>
<spring:url value="/pdf/crear" var="urlCreate" />
<spring:url value="/pdf/edit" var="urlEdit" />
<spring:url value="/pdf/lista" var="urllistar" />
<spring:url value="/pdf/delete" var="urlDelete" />

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
		<div class="table-responsive">
			<div class="row">
				<div class="col-sm-3">


					<form class="form-inline" action="${urlRoot}pdf/searchByFolio"
						method="post">


						<div class="form-group">
							<label for="folio">Buscar por folio</label> <input type="text"
								class="form-control" name="folio" id="folio" required="required" />
						</div>




						<button type="submit" class="btn btn-primary">Filtrar</button>
					</form>
				</div>

				<div class="col-sm-3">
					<form class="form-inline" action="${urlRoot}pdf/searchByDateEmisio"
						method="post">


						<label for="fechaBusqueda">Busqueda por fecha de emisión</label>

						<div class="form-group">
							<label for="fechaBusqueda">de</label> <input type="text"
								class="form-control" name="fechaBusqueda" id="fechaBusqueda"
								required="required" />
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="fechaBusqueda2">A</label> <input type="text"
									class="form-control" name="fechaBusqueda2" id="fechaBusqueda2"
									required="required" />
							</div>

							<button type="submit" class="btn btn-primary">Filtrar</button>
						</div>


						<!-- 				<button type="submit" class="btn btn-primary">Filtrar</button> -->
					</form>
				</div>
				
				


				<div class="col-sm-3">

					<a href="${urllistar}" class="btn btn-success" role="button"
						title="Nueva Pelicula">Ver todos los documentos</a><br> <br>
				</div>
			</div>



			<h3>Listado de documentos</h3>
			<c:if test="${msg!=null }">
				<div class='alert alert-success' role="alert">${ msg }</div>
			</c:if>

			<a href="${urlCreate}" class="btn btn-success" role="button"
				title="Nueva Pelicula">Nuevo documento</a><br> <br>





			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Folio/Oficio</th>
					<th>Nombre del emisor</th>
					<th>Dependencia emisora</th>
					<th>Fecha de emisión</th>
					<th>Fecha de recibido</th>
					<th>Quien recibió</th>
					<th>Fecha de modificación/Turnado</th>
					<th>Quien modifico</th>
					<th>Tipo de documento</th>
					<th>Asunto</th>



					<th>Archivo</th>
					<th>Opciones</th>
					<th>Ver</th>
				</tr>
				<c:forEach items="${documentoPdf}" var="pdf">
					<tr>
						<td>${pdf.folio}</td>
						<td>${pdf.nombreEmisor}</td>
						<td>${pdf.dependenciaEmisor}</td>

						<td><fmt:formatDate value="${pdf.fechaEntrada}"
								pattern="dd-MM-yyyy" /></td>

						<td><fmt:formatDate value="${pdf.fechaRecibida}"
								pattern="dd-MM-yyyy" /></td>

						<c:forEach items="${usuario}" var="us">
							<c:if test="${us.idUsuario==pdf.idEncargado}">
								<td>${us.nombreCompleto}</td>
							</c:if>
						</c:forEach>

						<td><fmt:formatDate value="${pdf.fechaModificacion}"
								pattern="dd-MM-yyyy" /></td>
						

						<c:forEach items="${usuario}" var="us">
							<c:if test="${us.idUsuario==pdf.quienModifico}">
								<td>${us.nombreCompleto}</td>
							</c:if>
						</c:forEach>
						<td>${pdf.tipo}</td>
						<td>${pdf.asunto}</td>
						<td>${pdf.content}</td>
						<td><a href="${urlEdit}/${pdf.idDucumento}"
							class="btn btn-success btn-sm" role="button" title="Edit"><span
								class="glyphicon glyphicon-pencil"></span></a> <a
							href="${urlDelete}/${pdf.idDucumento}"
							onclick="return confirm('¿Esta seguro de eliminar el documento?')"
							class="btn btn-danger btn-sm" role="button" title="Eliminar"><span
								class="glyphicon glyphicon-trash"></span></a></td>
						<td><a
							href="${pageContext.request.contextPath}/pdf/download/${pdf.idDucumento}">
								<img src="${urlPublic}/images/save_icon.gif" border="0"
								title="Download this document" />
						</a></td>
					</tr>
				</c:forEach>

			</table>
		</div>

		<hr class="featurette-divider">

		<!-- FOOTER -->
		<jsp:include page="../includes/footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!--   ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#fechaBusqueda").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});

		$(function() {
			$("#fechaEntrada").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});

		$(function() {
			$("#fechaBusqueda2").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>
</body>
</html>
