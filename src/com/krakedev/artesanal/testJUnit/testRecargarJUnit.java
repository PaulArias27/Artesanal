package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class testRecargarJUnit {
	
	@Test
	public void testRecargaExitosa() {
		Maquina rubia = new Maquina("pilsener" , "cerveza", 0.02, 8000,"1234" );
		boolean resultado = rubia.recargarCerveza(1000);
		
		assertTrue(resultado);
		assertEquals(1000,rubia.getCantidadActual(),0.0001);
	}
	@Test
	public void testRecargaFallidaPorDesborde() {
		Maquina negra = new Maquina("club" , "cerveza fria", 0.03, 8000,"1234" );
		negra.recargarCerveza(7000);
		boolean resultado = negra.recargarCerveza(1000);
		
		assertTrue(resultado);
		assertEquals(7000,negra.getCantidadActual(),0.0001);
	}
}
