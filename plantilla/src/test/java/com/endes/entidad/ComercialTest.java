package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.DisplayName;

class ComercialTest {

	/*
	 * Crea una nueva rama llamada prueba/comercial.
	 *● Implementar pruebas unitarias para los siguientes métodos en Comercial:
	 *○ getVentas()
	 *○ setVentas(double ventas) (Debe lanzar una excepción si el valor es negativo).
	 *○ calcularExtra()
	 *○ getSueldo() (Debe comprobarse con diferentes valores de ventas).
	 *● Súbelo a GitHub en la rama ‘prueba/comercial’.
	 * */
	protected Comercial c;
	
	@BeforeEach
	void setUp() throws Exception {
		c = new Comercial("11111111H", "Sergio", "Campos Delgado", 1000.00, 10.00);
		assertNotNull(c, "No se puede crear el objeto principal");
	}
	
	@Test
	@DisplayName ("Debe lanzar IllegalArgumentExcaption si las ventas son negativas")
	void testContructorExcepcionVentas() {
		
		double ventasNegativas = -3.20;
		Exception exception_ventas = assertThrows(IllegalArgumentException.class, ()->new  Comercial("11111111H", "Sergio", "Campos Delgado", 1000.00, ventasNegativas));
		String mensajeEsperado_ventas = "Las ventas no pueden ser negativas";
		
		assertNotNull(exception_ventas,  "No ha saltado una excepcion");
		assertEquals(mensajeEsperado_ventas, exception_ventas.getMessage(), "No coinciden los mensajes de excepciones");
		
	}

	@DisplayName("Test del metodo getVentas()")
	@Test
	void testGetVentas() {
		double ventasEsperadas = 10.00;
		double ventasObtenidas = c.getVentas();
		
		assertEquals(ventasEsperadas, ventasObtenidas, "Las ventas no coinciden");
	}
	
	@ParameterizedTest
	@CsvSource({"699,99" , "229,40" ,"100.00" })
	@DisplayName ("Test del metodo setVentas()")
	void testSetVentas ( double ventas) {
		c.setVentas(ventas);
		
		assertEquals(c.getVentas(), ventas);
	}
	
	@ParameterizedTest
	@CsvSource({"-699,99" , "-229,40" ,"-100.00" })
	@DisplayName ("Debe crear excepciones al intentar poner ventas negativas")
	void testSetVentasNegativas ( double ventas) {
		double ventasEsperadas = 10.00;

		Exception exception_ventas = assertThrows(IllegalArgumentException.class, ()->c.setVentas(ventas) );
		String mensajeEsperado_ventas = "Las ventas no pueden ser negativas";
		
		double ventasObtenidas = c.getVentas();
		
		assertEquals(ventasObtenidas, ventasEsperadas);
		assertEquals(mensajeEsperado_ventas, exception_ventas.getMessage());
	}
	@DisplayName("Test del metodo calcularExtra()")
	@Test
	void testCalcularExtra() {
		double extraEsperado = 10.00 * 0.10;
		double extraObtenido = c.calcularExtra();
		
		assertEquals(extraEsperado, extraObtenido, "Los extras no coinciden");
		assertEquals(extraEsperado, extraObtenido, "Los extras no coinciden");
	}
	
	@DisplayName("Test del metodo setSueldo()")
	@Test
	void testSetSueldo() {
		double extra = c.calcularExtra();
		
		double sueldoEsperado = 1000.00 + extra;
		double sueldoObtenido = c.getSueldo();
		
		assertEquals(sueldoEsperado, sueldoObtenido, "Los sueldos no coinciden");
	}
	

}
