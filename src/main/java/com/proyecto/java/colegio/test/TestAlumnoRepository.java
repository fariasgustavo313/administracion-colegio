package com.proyecto.java.colegio.test;

import com.proyecto.java.colegio.Irepository.I_AlumnoRepository;
import com.proyecto.java.colegio.connectors.Connector;
import com.proyecto.java.colegio.entities.Alumno;
import com.proyecto.java.colegio.entities.Curso;
import com.proyecto.java.colegio.enums.Dia;
import com.proyecto.java.colegio.enums.Turno;
import com.proyecto.java.colegio.repository.AlumnoRepository;

public class TestAlumnoRepository {
	public static void main(String[] args) {
		I_AlumnoRepository alumnoRepository=new AlumnoRepository(Connector.getConnection());
		
		//método .save()
		System.out.println("* .save() *********************************************************");
		Alumno alumno=new Alumno("Katty","Mencuerna",38,2);
		alumnoRepository.save(alumno);
		System.out.println(alumno);
		
		//método .getById()
		System.out.println("* .getById() *********************************************************");
		System.out.println(alumnoRepository.getById(4));
		System.out.println(alumnoRepository.getById(4000));
		
		//método .remove()
		System.out.println("* .remove() *********************************************************");
		alumnoRepository.remove(alumnoRepository.getById(40));
		
		//método .update()
		System.out.println("* .update() *********************************************************");
		alumno=alumnoRepository.getById(41);
		if(alumno!=null && alumno.getId()!=0) {
			alumno.setApellido("Gorrity");
			alumnoRepository.update(alumno);
		}
		
		// método .getAll()
		System.out.println("* .getAll() *********************************************************");
		alumnoRepository.getAll().forEach(System.out::println);
	
	}
}
