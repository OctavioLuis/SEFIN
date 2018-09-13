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
<spring:url value="/pdf/save" var="urlForm"></spring:url>
<spring:url value="/pdf/lista" var="urlListar"></spring:url>

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
				<span class="label label-success">Datos de los documentos recibidos</span>
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
			enctype="multipart/form-data" modelAttribute="documentoPdf">
			<div class="row"></div>



			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="titulo">Folio/Oficio</label>
						<form:hidden path="idDucumento" />
						<form:input type="text" class="form-control" path="folio"
							id="folio" required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="nombreEmisor">Nombre  emisor</label>
						<form:input type="text" class="form-control" path="nombreEmisor"
							id="nombreEmisor" required="required" />
					</div>
				</div>
				
<!-- 				<div class="col-sm-3"> -->
<!-- 					<div class="form-group"> -->
<!-- 						<label for="dependenciaEmisor">Dependencia  emisora</label> -->
<%-- 						<form:input type="search" class="form-control" path="dependenciaEmisor" --%>
<%--  							id="dependenciaEmisor" required="required" />  --%>
<!-- 					</div> -->
<!-- 				</div> -->


			<div class="col-sm-3">
					<div class="form-group">
						<label for="dependenciaEmisor" class="control-label">Dependencia  emisora</label>
						<form:select id="dependenciaEmisor" path="dependenciaEmisor"	class="form-control" 
 						items="${dependencia}" itemLabel="nombre" itemValue="idDependencia" /> 
					</div>
				</div>
				
				<div class="col-sm-3">
					<div class="form-group">
						<label for="fechaEntrada">Fecha de emisión</label> <form:input type="text"
							class="form-control" path="fechaEntrada" id="fechaEntrada"
							required="required" />
					</div>
				</div>
				
					
				
				
			</div>

			<div class="row">
			<div class="col-sm-3">
					<div class="form-group">
						<label for="fechaRecibida">Fecha de recibido</label> <form:input type="text"
							class="form-control" path="fechaRecibida" id="fechaRecibida"
							required="required" />
					</div>
				</div>
				
				
				
				<div class="col-sm-3">
					<div class="form-group">
						<label for="idEncargado" class="control-label">Quien recibió</label>
						<form:select id="idEncargado" path="idEncargado"	class="form-control" 
						items="${usuario}" itemLabel="nombreCompleto" itemValue="idUsuario" />
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">
						<label for="fechaModificacion">Fecha de modificación/Turnado</label> <form:input type="text"
							class="form-control" path="fechaModificacion" id="fechaEstreno"	/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="tipo">Tipo de documento</label>
						<form:input type="text" class="form-control" path="tipo"
							id="tipo"  />
					</div>
				</div>
				

			</div>

			<div class="row">

<!-- 				<div class="col-sm-3"> -->
<!-- 					<div class="form-group"> -->
<!-- 						<label for="idEncargado">idEncargado</label> -->
<%-- 						<form:input type="text" class="form-control" path="idEncargado" --%>
<%-- 							id="idEncargado" required="required" /> --%>
<!-- 					</div> -->
<!-- 				</div> -->

				
				
				
				
				<div class="col-sm-3">
					<div class="form-group">
						<label for="quienModifico" class="control-label">Quien modifico</label>
						<form:select id="quienModifico" path="quienModifico"	class="form-control" 
						items="${usuario}" itemLabel="NombreCompleto" itemValue="idUsuario" />
					</div>
				</div>
				
				<div class="col-sm-3">
					<div class="form-group">
						<label for="file">Archivo</label>
<%-- 												<form:hidden path="content" /> --%>
						<input type="file" name="file" id="file" ></input>
						<p class="help-block">Documento a guardar</p>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="asunto">Asunto</label>
						<form:textarea class="form-control" rows="5"
							path="asunto" id="asunto"></form:textarea>
					</div>
				</div>
			</div>

			<button type="submit" class="btn btn-success">Guardar</button>
			<a href="${urlListar}" class="btn btn-danger" role="button"
			title="Nueva Pelicula">Cancelar</a><br> <br>
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
		
		
		$(function() {
			$("#fechaEntrada").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
		
		$(function() {
			$("#fechaRecibida").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
		
		
		 $(document).ready(function() {
				$("#dependenciaEmisor")
						.autocomplete(
								{
									source : '${pageContext.request.contextPath }/dependencia/search'
								});
			});
		
		
	</script>
</body>
</html>
