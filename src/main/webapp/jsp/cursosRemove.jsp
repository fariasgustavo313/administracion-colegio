<%@page import="com.proyecto.java.colegio.repository.AlumnoRepository"%>
<%@page import="com.proyecto.java.colegio.Irepository.I_AlumnoRepository"%>
<%@ page import="com.proyecto.java.colegio.repository.CursoRepository"%>
<%@ page import="com.proyecto.java.colegio.Irepository.I_CursoRepository"%>
<%@ page import="ch.qos.logback.core.recovery.ResilientSyslogOutputStream"%>
<%@ page import="com.proyecto.java.colegio.connectors.Connector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	try {
		I_CursoRepository cursoRepository = new CursoRepository(Connector.getConnection());
		cursoRepository.remove(cursoRepository.getById(Integer.parseInt(request.getParameter("idCurso"))));
		response.sendRedirect("../cursos.jsp");
	} catch (Exception e) {
		System.out.println(e);
	}
	
%>