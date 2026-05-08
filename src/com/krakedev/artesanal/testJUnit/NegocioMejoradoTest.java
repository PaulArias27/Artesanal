package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
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
	    
	    @Test
	    void testRecuperarMaquinaNoExiste() {

	        NegocioMejorado negocio =
	                new NegocioMejorado();

	        Maquina maquina =
	                negocio.recuperarMaquina(
	                        "M-999");

	        assertNull(maquina);
	    }

	    @Test
	    void testRegistrarCliente() {

	        NegocioMejorado negocio =
	                new NegocioMejorado();

	        negocio.registrarCliente(
	                "Paul",
	                "17223344");

	        assertEquals(
	                1,
	                negocio.getClientes().size());
	    }

	    @Test
	    void testBuscarClientePorCedula() {

	        NegocioMejorado negocio =
	                new NegocioMejorado();

	        negocio.registrarCliente(
	                "Paul",
	                "17223344");

	        Cliente cliente =
	                negocio.buscarClientePorCedula(
	                        "17223344");

	        assertNotNull(cliente);
	    }

	    @Test
	    void testBuscarClientePorCodigo() {

	        NegocioMejorado negocio =
	                new NegocioMejorado();

	        negocio.registrarCliente(
	                "Paul",
	                "17223344");

	        Cliente cliente =
	                negocio.buscarClientePorCodigo(
	                        100);

	        assertNotNull(cliente);
	    }

	    @Test
	    void testConsumirCerveza() {

	        NegocioMejorado negocio =
	                new NegocioMejorado();

	        negocio.agregarMaquina(
	                "IPA",
	                "Artesanal",
	                0.10);

	        negocio.cargarMaquinas();

	        negocio.registrarCliente(
	                "Paul",
	                "17223344");

	        Cliente cliente =
	                negocio.getClientes().get(0);

	        Maquina maquina =
	                negocio.getMaquinas().get(0);

	        double cantidadAntes =
	                maquina.getCantidadActual();

	        negocio.consumirCerveza(
	                cliente.getCodigo(),
	                maquina.getCodigo(),
	                100);

	        assertTrue(
	                cliente.getTotalConsumido() > 0);

	        assertTrue(
	                maquina.getCantidadActual()
	                < cantidadAntes);
	    }
	    
	    @Test
	    void testConsultarValorVendido() {

	        NegocioMejorado negocio =
	                new NegocioMejorado();

	        negocio.agregarMaquina(
	                "IPA",
	                "Artesanal",
	                0.10);

	        negocio.cargarMaquinas();

	        negocio.registrarCliente(
	                "Paul",
	                "17223344");

	        Cliente cliente =
	                negocio.getClientes().get(0);

	        Maquina maquina =
	                negocio.getMaquinas().get(0);

	        negocio.consumirCerveza(
	                cliente.getCodigo(),
	                maquina.getCodigo(),
	                100);

	        double total =
	                negocio.consultarValorVendido();

	        assertEquals(10, total);
	    }

	    @Test
	    void testAcumularConsumo() {

	        NegocioMejorado negocio =
	                new NegocioMejorado();

	        negocio.agregarMaquina(
	                "IPA",
	                "Artesanal",
	                0.10);

	        negocio.cargarMaquinas();

	        negocio.registrarCliente(
	                "Paul",
	                "17223344");

	        Cliente cliente =
	                negocio.getClientes().get(0);

	        Maquina maquina =
	                negocio.getMaquinas().get(0);

	        negocio.consumirCerveza(
	                cliente.getCodigo(),
	                maquina.getCodigo(),
	                100);

	        negocio.consumirCerveza(
	                cliente.getCodigo(),
	                maquina.getCodigo(),
	                100);

	        assertEquals(
	                20,
	                cliente.getTotalConsumido());
	    }
}
