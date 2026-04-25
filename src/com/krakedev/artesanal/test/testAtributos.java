package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class testAtributos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Maquina rubia = new Maquina("pilsener","cerveza rubia",0.02,100000,"1234");
		rubia.imprimir();
		
		rubia.setNombreCerveza("golden");
		rubia.setDescripcion("cerveza con aroma mas intenso");
		rubia.imprimir();
	}

}
