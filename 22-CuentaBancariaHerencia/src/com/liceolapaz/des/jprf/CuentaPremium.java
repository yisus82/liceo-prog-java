package com.liceolapaz.des.jprf;

public class CuentaPremium extends CuentaBancaria {

	public CuentaPremium(double saldo) {
		super(saldo);
	}

	@Override
	protected void ingresarDinero(double cantidad) {
		if (cantidad <= 0) {
			System.out.println("La cantidad a ingresar debe ser positiva");
		} else {
			this.saldo += cantidad;
		}
	}

	@Override
	protected void retirarDinero(double cantidad) {
		if (cantidad <= 0) {
			System.out.println("La cantidad a retirar debe ser positiva");
		} else {
			this.saldo -= cantidad;
		}
	}

	@Override
	protected double verSaldo() {
		return this.saldo;
	}

}
