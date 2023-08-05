<%@ page import="ch.qos.logback.core.recovery.ResilientSyslogOutputStream"%>
<%@ page import="com.proyecto.java.colegio.connectors.Connector"%>
<%@ page import="com.proyecto.java.colegio.repository.AlumnoRepository"%>
<%@ page import="com.proyecto.java.colegio.Irepository.I_AlumnoRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	try {
		I_AlumnoRepository alumnoRepository = new AlumnoRepository(Connector.getConnection());
		alumnoRepository.remove(alumnoRepository.getById(Integer.parseInt(request.getParameter("idAlumno"))));
		response.sendRedirect("../alumnos.jsp");
	} catch (Exception e) {
		System.out.println(e);
	}
	
%>