<%@ page import="com.proyecto.java.colegio.repository.ProfesorRepository"%>
<%@ page import="com.proyecto.java.colegio.Irepository.I_ProfesorRepository"%>
<%@ page import="ch.qos.logback.core.recovery.ResilientSyslogOutputStream"%>
<%@ page import="com.proyecto.java.colegio.connectors.Connector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	try {
		I_ProfesorRepository profesorRepository = new ProfesorRepository(Connector.getConnection());
		profesorRepository.remove(profesorRepository.getById(Integer.parseInt(request.getParameter("idProfesor"))));
		response.sendRedirect("../profesores.jsp");
	} catch (Exception e) {
		System.out.println(e);
	}
	
%>