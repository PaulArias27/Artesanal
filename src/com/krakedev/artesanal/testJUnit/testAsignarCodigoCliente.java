package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Negocio;

public class testAsignarCodigoCliente {
	@Test
	public void asignarCodigo() {
		Negocio barDeMoe = new Negocio();
		
		Cliente mario = new Cliente("Mario","2000122727");
		Cliente Paul = new Cliente("Paul","2000122728");
		
		barDeMoe.asignarCodigoCliente(mario);
		barDeMoe.asignarCodigoCliente(Paul);
		
		assertEquals(100,mario.getCodigo());
		assertEquals(101,Paul.getCodigo());
		
	}

}
