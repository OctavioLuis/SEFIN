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
<spring:url value="/" var="urlCreate" />
<spring:url value="/edit" var="urlEdit" />
<spring:url value="/delete" var="urlDelete" />

<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

	<!-- Fixed navbar -->
	<jsp:include page="../includes/menu.jsp"></jsp:include>
	<div class="container theme-showcase" role="main">

		<h3>Listado de Peliculas</h3>
		<c:if test="${msg!=null }">
			<div class='alert alert-success' role="alert">${ msg }</div>
		</c:if>
		
		<a href="${urlCreate}" class="btn btn-success" role="button"
			title="Nueva Pelicula">Nueva</a><br>
		<br>

		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>folio</th>
					<th>nombreEmisor</th>
					<th>fechaEntrada</th>
					<th>quienModifico</th>
					<th>fechaModificacion</th>
					<th>asunto</th>
					<th>tipo</th>
					<th>idEncargado</th>
					<th>Opciones</th>
				</tr>
				<c:forEach items="${documentoPdf}" var="pdf">
					<tr>
						<td>${pdf.folio}</td>
						<td>${pdf.content}</td>
						<td>${pdf.nombreEmisor}</td>
						<td><fmt:formatDate value="${pdf.fechaEntrada}"
								pattern="dd-MM-yyyy" /></td>												
						<td>${pdf.quienModifico}</td>						
						<td><fmt:formatDate value="${pdf.fechaModificacion}"
								pattern="dd-MM-yyyy" /></td>
						<td>${pdf.asunto}</td>
						<td>${pdf.tipo}</td>
						<td>${pdf.idEncargado}</td>						
						<td>
						<a href="${urlEdit}/${pdf.idDucumento}" class="btn btn-success btn-sm" role="button" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
						<a href="${urlDelete}/${pdf.idDucumento}" onclick="return confirm('¿Esta seguro?')" class="btn btn-danger btn-sm" role="button"	title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
						<a href="${pageContext.request.contextPath}/download/${pdf.idDucumento}">
						<img src="${urlPublic}/images/save_icon.gif" border="0" title="Download this document"/> </a> 
						
						</td>
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
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
