package com.proyecto.java.colegio.entities;

import com.proyecto.java.colegio.enums.Dia;
import com.proyecto.java.colegio.enums.Turno;

public class Curso {
	
	private int id;
	private String titulo;
	private Dia dia;
	private Turno turno;

	public Curso() {}

	public Curso(String titulo, Dia dia, Turno turno) {
		super();
		this.titulo = titulo;
		this.dia = dia;
		this.turno = turno;
	}

	public Curso(int id, String titulo, Dia dia, Turno turno) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.dia = dia;
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", titulo=" + titulo + ", dia=" + dia + ", turno=" + turno + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

}
