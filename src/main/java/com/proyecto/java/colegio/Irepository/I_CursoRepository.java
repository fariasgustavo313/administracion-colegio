package com.proyecto.java.colegio.Irepository;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.java.colegio.entities.Curso;
import com.proyecto.java.colegio.enums.Dia;
import com.proyecto.java.colegio.enums.Turno;

public interface I_CursoRepository {
	void save(Curso curso);
	void remove(Curso curso);
	void update(Curso curso);
	Curso getById(int id);
	List<Curso>getAll();
	List<Curso>getLikeTitulo(String titulo);
//    default List<Curso>getLikeTitulo(String titulo){    //select * from cursos where titulo like '%titulo%';
//        if(titulo==null) return new ArrayList();
//        return getAll()
//                    .stream()
//                    .filter(curso->curso.getTitulo()!=null)
//                    .filter(curso->curso.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
//                    .toList();          //JDK 16 o sup  - Inumutable List
//    }
	
	default List<Curso>getLikeTituloDiaTurno(String titulo, Dia dia, Turno turno) {
		if(titulo == null || dia == null || turno == null) return new ArrayList();
		return getAll()
						.stream()
						.filter(curso -> curso.getTitulo() != null)
						.filter(curso -> curso.getDia() != null)
						.filter(curso -> curso.getTurno() != null)
						.filter(curso -> curso.getTitulo().toLowerCase().contains(titulo))
						.filter(curso -> curso.getDia() == dia)
						.filter(curso -> curso.getTurno() == turno)
						.toList();
	}
	
	
}
