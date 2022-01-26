package com.liceolapaz.des.jprf;

public abstract class CuentaBancaria {
	protected double saldo;

	public CuentaBancaria(double saldo) {
		super();
		this.saldo = saldo;
	}
	
	protected abstract void ingresarDinero(double cantidad);
	
	protected abstract void retirarDinero(double cantidad);
	
	protected abstract double verSaldo();
}
