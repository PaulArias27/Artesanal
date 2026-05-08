package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	
	private ArrayList<Maquina> maquinas = new ArrayList<>();
	
	

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}
	
	public String generarCodigo() {
		int numero;
		numero = (int)(Math.random()*100)+1;
		return "M-" + numero;
	}
	
	public boolean agregarMaquina(String nombreCerveza, String descripcion,double precioPorMl) {
		
		String codigo = generarCodigo();
		Maquina nueva = new Maquina(nombreCerveza,descripcion,precioPorMl,codigo);
		
		maquinas.add(nueva);
		return true;
	}
	public void cargarMaquinas() {
		for(int i = 0; i < maquinas.size(); i ++) {
			maquinas.get(i).llenarMaquina();
		}
	}
	
	public Maquina recuperarMaquina(String codigo) {
		for(int i = 0; i < maquinas.size(); i ++) {
			Maquina maquina = maquinas.get(i);
			
			if(maquina.getCodigo().equals(codigo)) {
				return maquina;
			}
		}
		return null;
	}
	
}
