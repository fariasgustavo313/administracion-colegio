package com.proyecto.java.colegio.Irepository;

import java.util.ArrayList;
import java.util.List;

import com.proyecto.java.colegio.entities.Profesor;

public interface I_ProfesorRepository {
	
	void save(Profesor profesor);
	void remove(Profesor profesor);
	void update(Profesor profesor);
	Profesor getById(int id);
	List<Profesor>getAll();
	default List<Profesor> getLikeApellido(String apellido){
        if(apellido==null) return new ArrayList();
        return getAll()
                .stream()
                .filter(profesor->profesor.getApellido()!=null)
                .filter(profesor->profesor.getApellido().toLowerCase().contains(apellido.toLowerCase()))
                .toList();
    }

}
