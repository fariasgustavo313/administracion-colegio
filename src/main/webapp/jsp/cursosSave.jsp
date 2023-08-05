<%@ page import="com.proyecto.java.colegio.Irepository.I_CursoRepository"%>
<%@ page import="com.proyecto.java.colegio.connectors.Connector"%>
<%@ page import="com.proyecto.java.colegio.repository.CursoRepository"%>
<%@ page import="com.proyecto.java.colegio.enums.Turno"%>
<%@ page import="com.proyecto.java.colegio.enums.Dia"%>
<%@ page import="com.proyecto.java.colegio.entities.Curso"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	out.println("<input type='text' value='Ingrese un nuevo curso' class='form-control' readonly>");
	try {
		String titulo = request.getParameter("titulo");
		String dia = request.getParameter("dia");
		String turno = request.getParameter("turno");
		
		if (titulo != null && titulo.length() >= 3 && 
				titulo.length() <= 25) {
			
			Curso curso = new Curso(titulo, Dia.valueOf(dia), Turno.valueOf(turno));
			I_CursoRepository cursoRepository = new CursoRepository(Connector.getConnection());
			cursoRepository.save(curso);
			if (curso.getId() >= 0) {
				out.println("<input type='text' value='Se guardo el curso ID: " + curso.getId() + "' class='form-control' readonly>");
			} else {
				out.println("<input type='text' value='No se pudo guardar el curso' class='form-control' readonly>");
			}
		} else {
			out.println("<input type='text' value='Debe ingresar correctamente los parametros' class='form-control' readonly>");
		}
	} catch (Exception e) {
		out.println("<input type='text' value='Ocurrio un error!' class='form-control' readonly>");
	}
%>