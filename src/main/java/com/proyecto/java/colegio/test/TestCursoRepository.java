package com.proyecto.java.colegio.test;

import com.proyecto.java.colegio.Irepository.I_CursoRepository;
import com.proyecto.java.colegio.connectors.Connector;
import com.proyecto.java.colegio.entities.Curso;
import com.proyecto.java.colegio.enums.Dia;
import com.proyecto.java.colegio.enums.Turno;
import com.proyecto.java.colegio.repository.CursoRepository;

public class TestCursoRepository {
	public static void main(String[] args) {
		I_CursoRepository cursoRepository=new CursoRepository(Connector.getConnection());
		
		//método .save()
		System.out.println("* .save() *********************************************************");
		Curso curso=new Curso("HTML",Dia.MIERCOLES,Turno.TARDE);
		cursoRepository.save(curso);
		System.out.println(curso);
		
		//método .getById()
		System.out.println("* .getById() *********************************************************");
		System.out.println(cursoRepository.getById(12));			//Curso existente
		System.out.println(cursoRepository.getById(12000));			//Curso inexistente
		
		//método .remove()
		System.out.println("* .remove() *********************************************************");
		cursoRepository.remove(cursoRepository.getById(18));
		
		//método .update()
		System.out.println("* .update() *********************************************************");
		curso=cursoRepository.getById(20);
		if(curso!=null && curso.getId()!=0) {
			curso.setTitulo("JavaScript");
			cursoRepository.update(curso);
		}
		
		// método .getAll()
		System.out.println("* .getAll() *********************************************************");
		cursoRepository.getAll().forEach(System.out::println);
		
		
	}
}
