package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class testRecargar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean resultado;
		Maquina rubia = new Maquina("pilsener", "cerveza fria", 0.02,8000,"1234");
		
		System.out.println("*********Estado inicial************");
		rubia.imprimir();
		
		System.out.println("*********Recarga 1 *************");
		
		resultado = rubia.recargarCerveza(3000);
		System.out.println("se recargo correctamente " + resultado);
		rubia.imprimir();
		
		System.out.println("*********Recarga 2 **********");
		
		resultado = rubia.recargarCerveza(2000);
		System.out.println("se recargo correctamente " + resultado);
		rubia.imprimir();
		
		System.out.println("*********Recarga 3 **********");
		
		resultado = rubia.recargarCerveza(3000);
		System.out.println("se recargo correctamente " + resultado);
		rubia.imprimir();
	}

}
