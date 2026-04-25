package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaAI {
	 // Tolerancia para comparar valores double
    private static final double DELTA = 0.0001;

    /**
     * Valida que si la máquina tiene suficiente cerveza,
     * sirve correctamente, descuenta la cantidad actual
     * y retorna el valor a pagar.
     * 
     * Se usa el constructor con capacidad máxima.
     */
    @Test
    public void testServirCervezaConCantidadSuficiente() {
        Maquina maquina = new Maquina(
                "Pilsener",
                "Cerveza rubia",
                0.05,
                5000,
                "1234"
        );

        // Se llena la máquina hasta capacidad máxima - 100
        maquina.llenarMaquina();

        // Se sirven 1000 ml
        double valorRetornado = maquina.servirCerveza(1000);

        // Validar valor a pagar: 1000 * 0.05 = 50
        assertEquals(50.0, valorRetornado, DELTA);

        // Validar que la cantidad actual disminuyó correctamente
        // cantidad inicial = 4900
        // cantidad final = 3900
        assertEquals(3800.0, maquina.getCantidadActual(), DELTA);
    }

    /**
     * Valida que si no hay suficiente cerveza,
     * no se sirve nada, no cambia la cantidad actual
     * y retorna cero.
     * 
     * Se usa el constructor con capacidad máxima.
     */
    @Test
    public void testNoServirPorCantidadInsuficiente() {
        Maquina maquina = new Maquina(
                "Corona",
                "Cerveza ligera",
                0.04,
                3000,
                "1234"
        );

        // Se llena la máquina: 2900 ml disponibles
        maquina.llenarMaquina();

        // Se intenta servir más de lo disponible
        double valorRetornado = maquina.servirCerveza(3500);

        // Debe retornar 0 porque no alcanza cerveza
        assertEquals(0.0, valorRetornado, DELTA);

        // La cantidad actual no debe modificarse
        assertEquals(2800.0, maquina.getCantidadActual(), DELTA);
    }

    /**
     * Valida que si se sirve exactamente
     * la cantidad disponible, la máquina queda en cero
     * y retorna el valor correcto.
     * 
     * Se usa el constructor sin capacidad máxima explícita.
     */
    @Test
    public void testServirCantidadExactaDisponible() {
        Maquina maquina = new Maquina(
                "Heineken",
                "Cerveza premium",
                0.10,
                "1234"
        );

        // Constructor 2 => capacidad máxima = 10000
        // llenarMaquina() => cantidad actual = 9900
        maquina.llenarMaquina();

        double valorRetornado = maquina.servirCerveza(9800);

        // Validar valor a pagar: 9900 * 0.10 = 990
        assertEquals(980.0, valorRetornado, DELTA);

        // Debe quedar en cero
        assertEquals(0.0, maquina.getCantidadActual(), DELTA);
    }

    /**
     * Valida que si se intenta servir cuando la máquina está vacía,
     * no se sirve nada, no cambia la cantidad actual
     * y retorna cero.
     * 
     * Se usa el constructor sin capacidad máxima explícita.
     */
    @Test
    public void testNoServirCuandoMaquinaEstaVacia() {
        Maquina maquina = new Maquina(
                "Club",
                "Cerveza negra",
                0.08,
                "1234"
        );

        // La máquina inicia con cantidadActual = 0

        double valorRetornado = maquina.servirCerveza(500);

        // No debe servir nada
        assertEquals(0.0, valorRetornado, DELTA);

        // La cantidad actual debe seguir en cero
        assertEquals(0.0, maquina.getCantidadActual(), DELTA);
    }

}
