package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestVaciar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Maquina nueva = new Maquina("Pilsener","cerveza fria", 0.02,"1234");
		Negocio negocio1 = new Negocio("Pilsener",nueva);
		nueva.llenarMaquina();
		nueva.imprimir();
		nueva.servirCerveza(200);
		nueva.imprimir();
		nueva.vaciarMaquina();
		nueva.imprimir();
	}

}
