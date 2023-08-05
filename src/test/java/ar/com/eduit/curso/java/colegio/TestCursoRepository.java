package ar.com.eduit.curso.java.colegio;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.java.colegio.Irepository.I_CursoRepository;
import com.proyecto.java.colegio.connectors.Connector;
import com.proyecto.java.colegio.entities.Curso;
import com.proyecto.java.colegio.enums.Dia;
import com.proyecto.java.colegio.enums.Turno;
import com.proyecto.java.colegio.repository.CursoRepository;

@SpringBootTest
public class TestCursoRepository {
    
    private I_CursoRepository cursoRepository=new CursoRepository(Connector.getConnection());
    
    @Test
    void testSave1(){
        int cantidadInicial=cursoRepository.getAll().size();
        Curso curso=new Curso("Maquillaje",Dia.MARTES,Turno.MAÑANA);
        cursoRepository.save(curso);
        int cantidadFinal=cursoRepository.getAll().size();
        assertEquals(curso.getId()>0,true);
    }

    @Test
    void testSave2(){
        int cantidadInicial=cursoRepository.getAll().size();
        Curso curso=new Curso("Maquillaje",Dia.MARTES,Turno.MAÑANA);
        cursoRepository.save(curso);
        int cantidadFinal=cursoRepository.getAll().size();
        assertEquals(cantidadInicial+1, cantidadFinal);
    }
}
