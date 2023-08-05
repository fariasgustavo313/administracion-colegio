<%@ page import="com.proyecto.java.colegio.connectors.Connector"%>
<%@ page import="com.proyecto.java.colegio.repository.AlumnoRepository"%>
<%@ page import="com.proyecto.java.colegio.Irepository.I_AlumnoRepository"%>
<%@ page import="com.proyecto.java.colegio.entities.Alumno"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	out.println("<input type='text' value='Ingrese un nuevo alumno' class='form-control' readonly>");
	try {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int edad = Integer.parseInt(request.getParameter("edad"));
		int id_curso = Integer.parseInt(request.getParameter("id_curso"));
		
		if (nombre != null && apellido != null && 
				nombre.length() >= 3 && nombre.length() <= 25 && 
				apellido.length() >= 3 && apellido.length() <= 25 && 
				edad >= 18 && edad <= 120) {
			
			Alumno alumno = new Alumno(nombre, apellido, edad, id_curso);
			I_AlumnoRepository alumnoRepository = new AlumnoRepository(Connector.getConnection());
			alumnoRepository.save(alumno);
			if (alumno.getId() >= 0) {
				out.println("<input type='text' value='Se guardo el alumno ID: " + alumno.getId() + "' class='form-control' readonly>");
			} else {
				out.println("<input type='text' value='No se pudo guardar el alumno' class='form-control' readonly>");
			}
		} else {
			out.println("<input type='text' value='Debe ingresar correctamente los parametros' class='form-control' readonly>");
		}
	} catch (Exception e) {
		out.println("<input type='text' value='Ocurrio un error!' class='form-control' readonly>");
	}
%>