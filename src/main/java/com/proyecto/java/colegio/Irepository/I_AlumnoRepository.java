package com.proyecto.java.colegio.Irepository;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.java.colegio.entities.Alumno;
import com.proyecto.java.colegio.entities.Curso;

public interface I_AlumnoRepository {
	
	void save(Alumno alumno);
	void remove(Alumno alumno);
	void update(Alumno alumno);
	Alumno getById(int id);
	List<Alumno>getAll();
	default List<Alumno> getLikeApellido(String apellido){
        if(apellido==null) return new ArrayList();
        return getAll()
                .stream()
                .filter(alumno->alumno.getApellido()!=null)
                .filter(alumno->alumno.getApellido().toLowerCase().contains(apellido.toLowerCase()))
                .toList();
    }
	
	default Long getCantidadAlumnos(int id_curso) {
		return getAll()
						.stream()
						.filter(alumno -> alumno.getId_curso() == id_curso)
						.count();
	}
}
