<%@ page import="com.proyecto.java.colegio.connectors.Connector"%>
<%@ page import="com.proyecto.java.colegio.repository.ProfesorRepository"%>
<%@ page import="com.proyecto.java.colegio.Irepository.I_ProfesorRepository"%>
<%@ page import="com.proyecto.java.colegio.entities.Profesor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	out.println("<input type='text' value='Ingrese un nuevo profesor' class='form-control' readonly>");
	try {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int id_curso = Integer.parseInt(request.getParameter("id_curso"));
		
		if (nombre != null && apellido != null && 
				nombre.length() >= 3 && nombre.length() <= 25 && 
				apellido.length() >= 3 && apellido.length() <= 25) {
			
			Profesor profesor = new Profesor(nombre, apellido, id_curso);
			I_ProfesorRepository profesorRepository = new ProfesorRepository(Connector.getConnection());
			profesorRepository.save(profesor);
			if (profesor.getId() >= 0) {
				out.println("<input type='text' value='Se guardo el profesor ID: " + profesor.getId() + "' class='form-control' readonly>");
			} else {
				out.println("<input type='text' value='No se pudo guardar el profesor' class='form-control' readonly>");
			}
		} else {
			out.println("<input type='text' value='Debe ingresar correctamente los parametros' class='form-control' readonly>");
		}
	} catch (Exception e) {
		out.println("<input type='text' value='Ocurrio un error!' class='form-control' readonly>");
	}
%>