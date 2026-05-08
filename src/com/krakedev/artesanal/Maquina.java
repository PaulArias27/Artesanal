package com.krakedev.artesanal;

public class Maquina {
	private String nombreCerveza;
	private String descripcion;
	private double precioPorMl;
	private double capacidadMxima;
	private double cantidadActual;
	private String codigo;
	private double cantidadDesperdiciada;
	
	public Maquina(String nombreCerveza, String descripcion, double precioPorMl,
			double capacidadMaxima, String codigo) {
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl  = precioPorMl;
		this.capacidadMxima = capacidadMaxima;
		this.cantidadActual = 0;
		this.codigo = codigo;
	}
	public Maquina(String nombreCerveza, String descripcion, double precioPorMl, String codigo) {
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl  = precioPorMl;
		this.capacidadMxima = 10000;
		this.cantidadActual = 0;
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public String getNombreCerveza() {
		return nombreCerveza;
	}

	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioPorMl() {
		return precioPorMl;
	}

	public void setPrecioPorMl(double precioPorMl) {
		this.precioPorMl = precioPorMl;
	}

	public double getCapacidadMxima() {
		return capacidadMxima;
	}

	public double getCantidadActual() {
		return cantidadActual;
	}
	

	public double getCantidadDesperdiciada() {
		return cantidadDesperdiciada;
	}
	public void setCantidadDesperdiciada(double cantidadDesperdiciada) {
		this.cantidadDesperdiciada = cantidadDesperdiciada;
	}
	
	public void imprimir() {
		String mensaje;
		mensaje = "Nombre cerveza: " + nombreCerveza + ", Descripcion: " + descripcion + ", Precio por Ml: "
				+ precioPorMl + ", Capacidad maxima: " + capacidadMxima + ", Cantidad actual: " + cantidadActual +
				",Codigo: " + codigo +  ", Cantidad Desperdicio: " + cantidadDesperdiciada;
		System.out.println(mensaje);

	}
	public void llenarMaquina() {
		this.cantidadActual = this.capacidadMxima - 100;
	}
	
	public boolean recargarCerveza(double cantidad) {
		double limitePermitido;
		limitePermitido = capacidadMxima - 100;
		
		if(cantidadActual + cantidad <= limitePermitido) {
			cantidadActual = cantidadActual + cantidad;
			return true;
			
		}else {
			return false;
		}
	}
	
	public double servirCerveza(double cantidad) {
		if(cantidadActual >= cantidad) {
			cantidadActual = cantidadActual - cantidad ;
			
			double valor;
			valor = cantidad * precioPorMl;
			return valor;
		}else {
			return 0;
		}
		
	}
	
	public void vaciarMaquina() {
		this.cantidadDesperdiciada = this.getCantidadActual();
		this.cantidadActual = 0;
	}
	
}
