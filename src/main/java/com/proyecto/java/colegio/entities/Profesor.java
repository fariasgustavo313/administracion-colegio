package com.proyecto.java.colegio.entities;

public class Profesor {
	
	private int id;
	private String nombre;
	private String apellido;
	private int id_curso;
	
	public Profesor() {}

	public Profesor(String nombre, String apellido, int id_curso) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.id_curso = id_curso;
	}

	public Profesor(int id, String nombre, String apellido, int id_curso) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.id_curso = id_curso;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

}
