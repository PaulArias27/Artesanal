package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class testLlenarJUnit {
	
	@Test
	public void testLlenarMaquina() {
		
		Maquina rubia = new Maquina("pilsener" , "cerveza", 0.02, 8000,"1234" );
		rubia.llenarMaquina();
		assertEquals(7800,rubia.getCantidadActual(),0.0001);
	}
}
