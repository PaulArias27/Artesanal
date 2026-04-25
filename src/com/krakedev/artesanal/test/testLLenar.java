package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class testLLenar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maquina rubia = new Maquina("pilsener", "cerveza fria", 0.02,8000,"1234");
		
		rubia.imprimir();
		rubia.llenarMaquina();
		rubia.imprimir();
		
		Maquina negra = new Maquina("club","cerveza buena", 0.03, "1234");
		negra.imprimir();
		negra.llenarMaquina();
		negra.imprimir();
	}

}
