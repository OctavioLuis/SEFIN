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
<title>Paguina inicial</title>

<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/" var="urlRoot"></spring:url>
<spring:url value="/pdf/lista" var="urlDocPdf" />
<spring:url value="/usuario/edit" var="urlDocComp" />
<spring:url value="/usuario/lista" var="urlUsuario" />

<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

	<!-- Fixed navbar -->
	<jsp:include page="includes/menu.jsp"></jsp:include>
	<div class="container theme-showcase" role="main">
	
	<div class="row" >
		<div class="col-md-4 "><a href="${urlDocPdf}" class="btn btn-success " role="button"
			title="Nueva Pelicula">Documentos pdf</a><br> <br></div>
		<div class="col-md-4"><a href="${urlCreate}" class="btn btn-success" role="button"
			title="Nueva Pelicula">Documentos compartidos</a><br> <br></div>
		<div class="col-md-4"><a href="${urlUsuario}" class="btn btn-success" role="button"
			title="Nueva Pelicula">Trabajadores</a><br> <br></div>			
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
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
