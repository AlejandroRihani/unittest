package com.fca.calidad.unittest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class CalculadoraTest {
	public Calculadora calculadora;

	@Before
	public void setUp() throws Exception {
		calculadora = new Calculadora();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Este es el teardown");
	}

	@Test
	public void sumaPositivosTest() {
		
		//Ejercicio, llamada del código que vamos a probar
		double resultado = calculadora.suma(10, 5);
		double resultadoEsperado = 15;
		
		//Verificación. Comparar el resultado de ejecucuón vs ejecución esperada
		assertThat(resultado, is(resultadoEsperado));
	}
	
	@Test
	public void sumaNegativosTest() {
		
		//Ejercicio, llamada del código que vamos a probar
		double resultado = calculadora.suma(-10, -5);
		double resultadoEsperado = -15;
		
		//Verificación. Comparar el resultado de ejecucuón vs ejecución esperada
		assertThat(resultado, is(resultadoEsperado));
	}
	
	@Test
	public void sumaCeroTest() {
		
		//Ejercicio, llamada del código que vamos a probar
		double resultado = calculadora.suma(-10, 0);
		double resultadoEsperado = -10;
		
		//Verificación. Comparar el resultado de ejecucuón vs ejecución esperada
		assertThat(resultado, is(resultadoEsperado));
	}
	
	@Test
	public void restaTest() {
		double resultado = calculadora.resta(10, 5);
		double resultadoEsperado = 5;
		
		//Verificación. Comparar el resultado de ejecucuón vs ejecución esperada
		assertThat(resultado, is(resultadoEsperado));
	}
	
	@Test
	public void divisionPositivosTest() {
		double resultado = calculadora.division(10, 5);
		double resultadoEsperado = 2;
		
		//Verificación. Comparar el resultado de ejecucuón vs ejecución esperada
		assertThat(resultado, is(resultadoEsperado));
	}
	
	@Test(expected = ArithmeticException.class)
	public void divisionCeroTest() {
		double resultado = calculadora.division(10, 0);
		
	}
	
	@Test
	public void multiplicacionTest() {
		double resultado = calculadora.multiplicacion(10, 5);
		double resultadoEsperado = 50;
		
		//Verificación. Comparar el resultado de ejecucuón vs ejecución esperada
		assertThat(resultado, is(resultadoEsperado));
	}
	


}
