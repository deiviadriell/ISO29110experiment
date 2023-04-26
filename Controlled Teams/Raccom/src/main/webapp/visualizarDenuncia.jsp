<%@ page contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="listaDenuncia" scope="request" value="${listaDenuncia}" />
<!DOCTYPE html>

<html>

<head>
	<c:choose>
	<c:when test="${(empty sessionScope.usuario) || (not sessionScope.tipo.equals('administrador')) }">
	<meta http-equiv="refresh" content="0; url=index.jsp"/>
</head>

</c:when>
<c:otherwise>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<title>Visualizar Denuncias</title>
	<link rel="stylesheet" href="css/estiloRegistro.css"/>
	</head>


	<body class="container">
	<nav class="navbar navbar-expand-lg navbar-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Poli-Colaboration</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
						<a class="nav-link active" aria-current="page" href="cerrarSesionController">Cerrar Sesión</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class=" d-flex flex-column justify-content-center">
		<form method="post" class="container col-lg-7 col-md-11">
			<h1 class="mt-3 mb-4">Visualizar Denuncias</h1>
			<table class="table table-striped ">
				<thead class="text-light bg-primary">
				<tr>
					<th>ID</th>
					<th>Tipo</th>
					<th>Estado</th>
					<th>Fecha</th>
				</tr>
				</thead>
				<tbody>
				<c:choose>
				<c:when test="${listaDenuncias==null}">
				</tbody>
			</table>
			<div class="row mx-auto mb-4">No hay elementos para mostrar.</div>
			</c:when>
			<c:when test="${listaDenuncias!=null}">
				<c:forEach var="d" items="${listaDenuncias}">
					<tr>
						<td>${d.id}</td>
						<td>${d.tipo}</td>
						<td>${d.estado}</td>
						<c:set var="diaSemana">${d.fecha.toString().split(" ")[0]}</c:set>
						<c:set var="mes">${d.fecha.toString().split(" ")[1]}</c:set>
						<c:set var="numeroDia">${d.fecha.toString().split(" ")[2]}</c:set>
						<c:set var="anio">${d.fecha.toString().split(" ")[5]}</c:set>
						<c:set var="dia">${diaSemana.concat(" ").concat(numeroDia).concat(" ").concat(mes).concat(" ").concat(anio)}</c:set>
						<td>${dia}</td>
					</tr>
				</c:forEach>
				</tbody>
				</table>

			</c:when>
			</c:choose>
		</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	</body>
</c:otherwise>
</c:choose>
</html>
