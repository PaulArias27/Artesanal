package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class NegocioMejoradoTest {
	
	 @Test
	    void testGenerarCodigo() {

	        NegocioMejorado negocio =
	                new NegocioMejorado();

	        String codigo =
	                negocio.generarCodigo();

	        assertNotNull(codigo);

	        assertTrue(
	                codigo.startsWith("M-"));
	    }
	 
	 @Test
	    void testAgregarMaquina() {

	        NegocioMejorado negocio =
	                new NegocioMejorado();

	        boolean resultado =
	                negocio.agregarMaquina(
	                        "IPA",
	                        "Artesanal",
	                        0.10);

	        assertTrue(resultado);

	        assertEquals(
	                1,
	                negocio.getMaquinas().size());
	    }

	    @Test
	    void testRecuperarMaquina() {

	        NegocioMejorado negocio =
	                new NegocioMejorado();

	        negocio.agregarMaquina(
	                "Pilsener",
	                "Rubia",
	                0.05);

	        Maquina maquina =
	                negocio.getMaquinas().get(0);

	        Maquina encontrada =
	                negocio.recuperarMaquina(
	                        maquina.getCodigo());

	        assertNotNull(encontrada);
	    }
}
