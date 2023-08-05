<%@page import="com.proyecto.java.colegio.entities.Curso"%>
<%@page import="com.proyecto.java.colegio.repository.CursoRepository"%>
<%@ page import="com.proyecto.java.colegio.entities.Profesor"%>
<%@ page import="com.proyecto.java.colegio.connectors.Connector"%>
<%@ page
	import="com.proyecto.java.colegio.repository.ProfesorRepository"%>
<%@ page
	import="com.proyecto.java.colegio.Irepository.I_ProfesorRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<table class="table table table-striped-columns table-hover">
	<thead>
		<tr>
			<th scope="col">ID</th>
			<th scope="col">NOMBRE</th>
			<th scope="col">APELLIDO</th>
			<th scope="col">ID CURSO</th>
			<th scope="col">TITULO</th>
			<th scope="col">DIA</th>
			<th scope="col">TURNO</th>
			<th scope="col">ELIMINAR</th>
		</tr>
	</thead>
	<tbody>
	<%
		I_ProfesorRepository profesorRepository = new ProfesorRepository(Connector.getConnection());
		String buscar = request.getParameter("buscar");
		if (buscar == null)	buscar = "";
		Curso curso;
		for (Profesor profesor : profesorRepository.getLikeApellido(buscar)) {
			curso = new CursoRepository(Connector.getConnection()).getById(profesor.getId_curso());
			out.println("<tr>");
			out.println("<th scope='row'>" + profesor.getId() + "</th>");
			out.println("<th scope='row'>" + profesor.getNombre() + "</th>");
			out.println("<th scope='row'>" + profesor.getApellido() + "</th>");
			out.println("<th scope='row'>" + curso.getId() + "</th>");
			out.println("<th scope='row'>" + curso.getTitulo() + "</th>");
			out.println("<th scope='row'>" + curso.getDia() + "</th>");
			out.println("<th scope='row'>" + curso.getTurno() + "</th>");
			out.println("<td >");
	%>
		<form action="jsp/profesoresRemove.jsp" onsubmit="return confirmarEliminacion()">
			<input type="text" name="idProfesor"
				value="<%out.println(profesor.getId());%>" hidden=true>
			<button type="submit" class="btn btn-outline-danger">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
			  				<path
						d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z" />
			  				<path
						d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z" />
						</svg>
			</button>
		</form>
	<%
			out.println("</td>");
			out.println("</tr>");
		}
	%>
	</tbody>
</table>