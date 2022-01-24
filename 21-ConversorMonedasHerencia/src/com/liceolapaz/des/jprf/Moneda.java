package com.liceolapaz.des.jprf;

public abstract class Moneda {
	protected double cantidad;
	private double tasaConversion;
	
	public Moneda(double cantidad, double tasaConversion) {
		super();
		this.cantidad = cantidad;
		this.tasaConversion = tasaConversion;
	}
	
	public double cantidadEnEuros() {
		return cantidad * tasaConversion;
	}
}
