<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<spring:url value="/docenviado/crear" var="urlCreate" />
<spring:url value="/docenviado/edit" var="urlEdit" />
<spring:url value="/docenviado/lista" var="urllistar" />
<spring:url value="/docenviado/delete" var="urlDelete" />

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
					<form class="form-inline" action="${urlRoot}docenviado/searchByFolio"
						method="post">
						<div class="form-group">
							<label for="folio">Buscar por folio</label> <input type="text"
								class="form-control" name="folio" id="folio" required="required" />
						</div>
						<button type="submit" class="btn btn-primary">Filtrar</button>
					</form>
				</div>
				
				<div class="col-sm-3">
					<form class="form-inline" action="${urlRoot}docenviado/searchByDateEmisio"
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
					<form class="form-inline" action="${urlRoot}docenviado/searchByDateSalida"
						method="post">
						<label for="fechaBusqueda">Busqueda por fecha de recibido</label>
						<div class="form-group">
							<label for="fechaBusquedaS">de</label> <input type="text"
								class="form-control" name="fechaBusquedaS" id="fechaBusquedaS"
								required="required" />
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="fechaBusquedaS2">A</label> <input type="text"
									class="form-control" name="fechaBusquedaS2" id="fechaBusquedaS2"
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

<%-- 		<c:forEach items="${usuarioconectado}" var="uC"> --%>
<%-- 		<h1>${uC}</h1> --%>
<!-- 		<input type="text" class="form-control" name="IdTem" -->
<%-- 							id="IdTem" value="${uC}"> --%>
<%-- 		</c:forEach> --%>



			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Folio/Oficio</th>
					<th>Nombre del emisor</th>
					<th>Quien elaboro</th>
					<th>Fecha de emisión</th>
					<th>Fecha de salida</th>
					<th>Fecha de resepcion</th>
					<th>Dependencia receptora</th>					
					<th>Tipo de documento</th>
					<th>Asunto</th>



					<th>Archivo</th>
					<th>Opciones</th>
					<th>Ver</th>
				</tr>
				<c:forEach items="${documentoEnviado}" var="docEnviado">
					<tr>
						<td>${docEnviado.folio}</td>
						<c:forEach items="${usuario}" var="us">
							<c:if test="${us.idUsuario==docEnviado.nombreEmisor}">
								<td>${us.nombreCompleto}</td>
							</c:if>
						</c:forEach>
						
						<c:forEach items="${usuario}" var="us">
							<c:if test="${us.idUsuario==docEnviado.quienElaboro}">
								<td>${us.nombreCompleto}</td>
							</c:if>
						</c:forEach>
						
						

						<td><fmt:formatDate value="${docEnviado.fechaEmision}"
								pattern="dd-MM-yyyy" /></td>

						<td><fmt:formatDate value="${docEnviado.fechaSalida}"
								pattern="dd-MM-yyyy" /></td>
								
								<td><fmt:formatDate value="${docEnviado.fechaRecepcion}"
								pattern="dd-MM-yyyy" /></td>
								
								<td>${docEnviado.dependenciaReceptora}</td>

<!-- 
						<c:forEach items="${usuario}" var="us">
							<c:if test="${us.idUsuario==pdf.idEncargado}">
								<td>${us.nombreCompleto}</td>
							</c:if>
						</c:forEach>

						
						

						<c:forEach items="${usuario}" var="us">
							<c:if test="${us.idUsuario==pdf.quienModifico}">
								<td>${us.nombreCompleto}</td>
							</c:if>
						</c:forEach>
	 -->					
						<td>${docEnviado.tipo}</td>
						<td>${docEnviado.asunto}</td>
						<td>${docEnviado.content}</td>
						<td><a href="${urlEdit}/${docEnviado.idDucumento}"
							class="btn btn-success btn-sm" role="button" title="Edit"><span
								class="glyphicon glyphicon-pencil"></span></a> <a
							href="${urlDelete}/${docEnviado.idDucumento}"
							onclick="return confirm('¿Esta seguro de eliminar el documento?')"
							class="btn btn-danger btn-sm" role="button" title="Eliminar"><span
								class="glyphicon glyphicon-trash"></span></a></td>
						<td><a
							href="${pageContext.request.contextPath}/docenviado/download/${docEnviado.idDucumento}">
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
		
		$(function() {
			$("#fechaBusquedaS").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
		
		$(function() {
			$("#fechaBusquedaS2").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>
</body>
</html>
