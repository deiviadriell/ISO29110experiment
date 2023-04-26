<%@ page contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1" language="java" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="mensajeError" scope="request" value="${mensajeError}"/>
<c:set var="mensajeExito" scope="request" value="${mensajeExito}"/>
<html>
<head>
    <c:choose>
    <c:when test="${(empty sessionScope.usuario) || ( not sessionScope.tipo.equals('usuario')) }">
    <meta http-equiv="refresh" content="0; url=index.jsp"/>
</head>

</c:when>
<c:otherwise>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Registrar Denuncia</title>
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
    <div class="d-flex flex-column justify-content-center">
        <form method="post" class="container col-lg-7 col-md-11" action="registroDenunciaController">
            <h1 class="mt-3 mb-4">Registrar Denuncia</h1>
            <div class="form-floating mt-5 mb-3">
                <select class="form-select" id="tipoDenuncia" name="tipoDenuncia">
                    <option value="Acoso">Acoso</option>
                    <option value="Maltrato">Maltrato</option>
                </select>
                <label for="tipoDenuncia">Tipo de denuncia</label>
            </div>

            <div class="form-floating mb-3">
                <input type="date" class="form-control" id="fechaRegistro" name="fechaRegistro" value="${fecha}"/>
                <label class="form-label" for="fechaRegistro">Fecha de ingreso de denuncia </label>
            </div>


            <div class="form-group">
                <label for="descripcion">Descripción de la denuncia</label>
                <textarea class="form-control" id="descripcion"  rows="5" name="descripcion">${descripcion}</textarea>
            </div>


            <div class="col-12 mt-4">
                <button type="submit" class="btn btn-primary">Registrar Denuncia</button>
                <div class="text-danger">${mensajeError}</div>
                <div class="text-success">${mensajeExito}</div>
            </div>

        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    </body>
</c:otherwise>
</c:choose>
</html>
