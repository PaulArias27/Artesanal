package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	
	private String nombre;
	
	private ArrayList<Maquina> maquinas = new ArrayList<>();
	
	private ArrayList<Cliente> clientes = new ArrayList<>();
	
	public ArrayList<Cliente> getClientes(){
		return clientes;
	}
	
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	private int ultimoCodigo = 100;
	
	

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}
	
	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}
	
	
	
	public NegocioMejorado() {}
	
	public NegocioMejorado(String nombre) {
		this.nombre = nombre;
	}

	

	
	//parte 1
	public String generarCodigo() {
		int numero;
		numero = (int)(Math.random()*100)+1;
		return "M-" + numero;
	}
	
	public boolean agregarMaquina(String nombreCerveza, String descripcion,double precioPorMl) {
		
		String codigo = generarCodigo();
		if(recuperarMaquina(codigo) != null) {
			codigo = generarCodigo();
		}
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
	
	//parte 2
	
	public void registrarCliente(String nombre, String cedula) {
		
		Cliente c = new Cliente(nombre,cedula);
		c.setCodigo(ultimoCodigo);
		ultimoCodigo ++;
		clientes.add(c);
	}
	
	public Cliente buscarClientePorCedula(String cedula) {
		for(int i = 0; i < clientes.size(); i ++) {
			Cliente cliente = clientes.get(i);
			
			if(cliente.getCedula().equals(cedula)) {
				return cliente;
			}
		}
		return null;
	}
	
	public Cliente buscarClientePorCodigo(int codigo) {
		for(int i = 0;  i < clientes.size(); i ++) {
			Cliente cliente = clientes.get(i);
			
			if(cliente.getCodigo() == codigo) {
				return cliente;
			}
		}
		return null;
	}
	
	//parte 3
	
	public void consumirCerveza(int codigoCliente, String codigoMaquina, double cantidad) {
		
		Maquina maquinaRecuperada = recuperarMaquina(codigoMaquina);
		
		Cliente recuperarCliente = buscarClientePorCodigo(codigoCliente);
		
		double valor = maquinaRecuperada.servirCerveza(cantidad);
		
		registrarConsumo(recuperarCliente,valor);
		
	}
	
	public void registrarConsumo(Cliente cliente, double valor) {
		cliente.setTotalConsumido(cliente.getTotalConsumido() + valor);
	}
	
	public double consultarValorVendido() {
		double total = 0;
		for(int i = 0; i < clientes.size(); i ++) {
			Cliente c = clientes.get(i);
			
			total += c.getTotalConsumido();
		}
		return total;
	}
	
	
	
	
	
	
}
