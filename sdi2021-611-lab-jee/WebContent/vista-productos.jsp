<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>

<head>
<title>Vista productos</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<!-- Contenido -->
	<div class="container" id="contenedor-principal">
		<h2>Vista-Productos</h2>
		<ul>
			<c:forEach var="producto" items="${productosTienda}">
				<tr>
					<li>${producto.nombre}-${producto.precio}</li>
				</tr>
			</c:forEach>
		</ul>
	</div>
	<a href="index.jsp">Volver</a>
</body>

</html>