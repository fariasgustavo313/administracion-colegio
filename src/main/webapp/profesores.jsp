<%@ page import="com.proyecto.java.colegio.entities.Curso"%>
<%@ page import="com.proyecto.java.colegio.repository.CursoRepository"%>
<%@ page import="com.proyecto.java.colegio.Irepository.I_CursoRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="jsp/head.jsp"%>
</head>
<body style="background-color: #e3f2fd;">

	<div class="container-lg bg-secondary-subtle">

		<!-- Barra de navegacion -->
		<%@ include file="jsp/navbar.jsp"%>

		<h1>Mantenimiento de Profesores</h1>

		<!-- Formulario de profesores -->
		<form>
			<div class="mb-3 row">
				<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="nombre" name="nombre"
						maxlength=23 minlength=3>
				</div>
				<label for="apellido" class="col-sm-2 col-form-label">Apellido</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="apellido"
						name="apellido" maxlength=23 minlength=3>
				</div>
				<label for="id_curso" class="col-sm-2 col-form-label">Curso</label>
				<div class="col-sm-10">
					<select class="form-select" aria-label="Default select example"
						id="id_curso" name="id_curso">
						<%
							I_CursoRepository cursoRepository = new CursoRepository(Connector.getConnection());
							for (Curso curso : cursoRepository.getAll()) {
								out.println("<option value='" + curso.getId() + "'>" + 
											curso.getId() + ", " + curso.getTitulo() + 
											", " + curso.getDia() + ", " + curso.getTurno() + "</option>");
							}
						%>
					</select>
				</div>
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary btn-sm">Guardar</button>
					<button type="reset" class="btn btn-secondary btn-sm">Limpiar</button>
				</div>
			</div>
		</form>
		<!-- Se guardan los profesores -->
		<%@ include file="jsp/profesoresSave.jsp"%>

		<!-- Se traen los profesores -->
		<%@ include file="jsp/profesoresList.jsp"%>
	</div>
</body>
</html>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
	crossorigin="anonymous">
	
</script>
<script src="js/main.js" type="text/javascript"></script>