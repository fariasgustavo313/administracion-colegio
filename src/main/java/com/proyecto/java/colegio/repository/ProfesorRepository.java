package com.proyecto.java.colegio.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.java.colegio.Irepository.I_ProfesorRepository;
import com.proyecto.java.colegio.entities.Profesor;

public class ProfesorRepository implements I_ProfesorRepository {
	
	private Connection conn;

	public ProfesorRepository(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void save(Profesor profesor) {
		if(profesor==null) return;
		try (PreparedStatement ps=conn.prepareStatement(
				"insert into profesores (nombre, apellido, id_curso) values (?,?,?)",
				PreparedStatement.RETURN_GENERATED_KEYS
		)){
			ps.setString(1, profesor.getNombre());
			ps.setString(2, profesor.getApellido());
			ps.setInt(3, profesor.getId_curso());
			ps.execute();
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next()) profesor.setId(rs.getInt(1));
		} catch (Exception e) {
			System.out.println();
		}
	}

	@Override
	public void remove(Profesor profesor) {
		if(profesor==null) return;
		try (PreparedStatement ps=conn.prepareStatement("delete from profesores where id=?")){
			ps.setInt(1, profesor.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void update(Profesor profesor) {
		if(profesor==null) return;
		try (PreparedStatement ps=conn.prepareStatement(
				"update profesores set nombre=?, apellido=?, id_curso=? where id=?"
			)){
			ps.setString(1, profesor.getNombre());
			ps.setString(2, profesor.getApellido());
			ps.setInt(4, profesor.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Profesor getById(int id) {
		Profesor profesor=new Profesor();
		try (ResultSet rs=conn.createStatement().executeQuery("select * from profesores where id=" + id)){
			if(rs.next()) {
				profesor=new Profesor(
						rs.getInt("id"),						// id
						rs.getString("nombre"),					// nombre
						rs.getString("apellido"),				// apellido
						rs.getInt("id_curso") 					// id_curso
				);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return profesor;
	}

	@Override
	public List<Profesor> getAll() {
		List<Profesor>list=new ArrayList();
		try (ResultSet rs=conn.createStatement().executeQuery("select * from profesores")){
			while(rs.next()) {
				list.add(new Profesor(
						rs.getInt("id"),						// id
						rs.getString("nombre"),					// nombre
						rs.getString("apellido"),				// apellido
						rs.getInt("id_curso") 					// id_curso
				));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
