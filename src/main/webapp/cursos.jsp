<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="jsp/head.jsp" %>
</head>
<body style="background-color: #e3f2fd;">
	<div class="container-lg bg-secondary-subtle">

		<!-- Barra de navegacion -->
		<%@ include file="jsp/navbar.jsp" %>

		<h1>Mantenimiento de Cursos</h1>

		<!-- Formulario alta Cursos--->

		<form>
			<div class="mb-3 row">
				<label for="titulo" class="col-sm-2 col-form-label">Titulo</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="titulo" name="titulo" maxlength=23 minlength=3>
				</div>
				<label for="dia" class="col-sm-2 col-form-label">Dia</label>
				<div class="col-sm-10">
					<select class="form-select" aria-label="Default select example"
						id="dia" name="dia">
						<option selected value="LUNES">Lunes</option>
						<option value="MARTES">Martes</option>
						<option value="MIERCOLES">Miercoles</option>
						<option value="JUEVES">Jueves</option>
						<option value="VIERNES">viernes</option>
					</select>
				</div>
				<label for="turno" class="col-sm-2 col-form-label">Turno</label>
				<div class="col-sm-10">
					<select class="form-select" aria-label="Default select example"
						id="turno" name="turno">
						<option selected value="MAÑANA">Mañana</option>
						<option value="TARDE">Tarde</option>
						<option value="NOCHE">Noche</option>
					</select>
				</div>
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary btn-sm">Guardar</button>
					<button type="reset" class="btn btn-secondary btn-sm">Limpiar</button>
				</div>
			</div>
			
		</form>
		<!-- Se guardan los cursos -->
		<%@ include file="jsp/cursosSave.jsp" %>
		
		<!-- Se traen los cursos -->
		<%@ include file="jsp/cursosList.jsp" %>
	</div>



</body>
</html>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
	crossorigin="anonymous"></script>
<script src="js/main.js" type="text/javascript"></script>