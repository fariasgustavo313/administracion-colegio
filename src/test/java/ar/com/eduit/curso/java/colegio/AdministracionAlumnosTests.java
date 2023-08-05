package ar.com.eduit.curso.java.colegio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdministracionAlumnosTests {

	@Test
	void contextLoads() {
	}

	//Pruebas Unitarias
	@Test 
	void prueba1(){
		assertEquals(true,false);		//Rojo
	}
	
	@Test 
	void prueba2(){
		assertEquals(true,true);		//Verde
	}
	
	@Test 
	void prueba3(){
		assertEquals(2+2, 4);					//Verde
	}
	
	@Test 
	void prueba4(){
		assertEquals(2+2, 5);					//Rojo
	}
	
}
