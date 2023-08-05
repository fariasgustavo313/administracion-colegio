package com.proyecto.java.colegio.test;

import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDateTime;

import com.proyecto.java.colegio.connectors.Connector;

public class TestConnector {
	
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	public static void main(String[] args) {
		LocalDateTime ldtInicio=LocalDateTime.now();
		try (ResultSet rs=Connector
									.getConnection()
									.createStatement()
									.executeQuery("select version()")){
			if(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(ANSI_GREEN+"Se pudo conectar a la BD");
			}else {
				System.out.println(ANSI_RED+"No se pudo conectar a la BD");
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(ANSI_RED+"No se pudo conectar a la BD");
		}
		LocalDateTime ldtFinal=LocalDateTime.now();
		
		Duration duration=Duration.between(ldtInicio, ldtFinal);
		
		if(duration.toSeconds()<=2) {
			System.out.println(ANSI_GREEN+"Tiempo de respuesta: "+duration.toMillis()+" ms, ACEPTABLE");
		}else {
			System.out.println(ANSI_RED+"Tiempo de respuesta: "+duration.toMillis()+" ms, MUY LENTO");
		}
		System.out.print(ANSI_RESET);
	}
}
