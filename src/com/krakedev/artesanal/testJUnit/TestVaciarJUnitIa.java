package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestVaciarJUnitIa{

    private Maquina maquina;

    @BeforeEach
    public void setUp() {
        maquina = new Maquina(
                "IPA Artesanal",
                "Cerveza fuerte y amarga",
                0.08,
                5000,
                "CER002"
        );

        // Cargamos cerveza disponible para la prueba
        maquina.recargarCerveza(2500);
    }

    @Test
    public void testVaciarMaquinaDebeGuardarCantidadDesperdiciada() {
        // Ejecutamos el método
        maquina.vaciarMaquina();

        // La cantidad desperdiciada debe ser igual a la cantidad actual que tenía antes
        assertEquals(2500, maquina.getCantidadDesperdiciada(), 0.01);

        // Después de vaciar, la cantidad actual debe quedar en 0
        assertEquals(0, maquina.getCantidadActual(), 0.01);
    }
}