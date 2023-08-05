package com.proyecto.java.colegio.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.java.colegio.Irepository.I_CursoRepository;
import com.proyecto.java.colegio.entities.Curso;
import com.proyecto.java.colegio.enums.Dia;
import com.proyecto.java.colegio.enums.Turno;

public class CursoRepository implements I_CursoRepository {
	
	private Connection conn;

	public CursoRepository(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void save(Curso curso) {
		if(curso==null) return;
		try (PreparedStatement ps=conn.prepareStatement(
				"insert into cursos (titulo, dia, turno) values (?,?,?)",
				PreparedStatement.RETURN_GENERATED_KEYS
			)){
			ps.setString(1, curso.getTitulo());
			ps.setString(2, curso.getDia().toString());
			ps.setString(3, curso.getTurno().toString());
			ps.execute();
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next()) curso.setId(rs.getInt(1));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void remove(Curso curso) {
		if(curso==null) return;
		try (PreparedStatement ps=conn.prepareStatement("delete from cursos where id=?")){
			ps.setInt(1, curso.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void update(Curso curso) {
		if(curso==null) return;
		try (PreparedStatement ps=conn.prepareStatement(
				"update cursos set titulo=?, dia=?, turno=? where id=?"
			)){
			ps.setString(1, curso.getTitulo());
			ps.setString(2, curso.getDia().toString());
			ps.setString(3, curso.getTurno().toString());
			ps.setInt(4, curso.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Curso getById(int id) {
		Curso curso=new Curso();
		try (ResultSet rs=conn.createStatement().executeQuery("select * from cursos where id=" + id)){
			if(rs.next()) {
				curso=new Curso(
						rs.getInt("id"),						// id
						rs.getString("titulo"),					// titulo
						Dia.valueOf(rs.getString("dia")),		// dia
						Turno.valueOf(rs.getString("turno"))	// turno
				);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return curso;
	}

	@Override
	public List<Curso> getAll() {
		List<Curso>list=new ArrayList();
		try (ResultSet rs=conn.createStatement().executeQuery("select * from cursos")){
			while(rs.next()) {
				list.add(new Curso(
						rs.getInt("id"),						// id
						rs.getString("titulo"),					// titulo
						Dia.valueOf(rs.getString("dia")),		// dia
						Turno.valueOf(rs.getString("turno"))	// turno
				));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	@Override
	public List<Curso> getLikeTitulo(String titulo) {
		if (titulo == null) return new ArrayList();
		List<Curso>list=new ArrayList();
		try (ResultSet rs=conn.createStatement().executeQuery("select * from cursos where titulo like '%" + titulo + "%'")){
			while(rs.next()) {
				list.add(new Curso(
						rs.getInt("id"),						// id
						rs.getString("titulo"),					// titulo
						Dia.valueOf(rs.getString("dia")),		// dia
						Turno.valueOf(rs.getString("turno"))	// turno
				));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
}
