package com.liceolapaz.des.jprf;

public class CuentaNormal extends CuentaBancaria {

	public CuentaNormal(double saldo) {
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
		} else if (cantidad > this.saldo) {
			System.out.println("Las cuentas normales no pueden quedar con saldo negativo");
		} else {
			this.saldo -= cantidad;
		}
	}

	@Override
	protected double verSaldo() {
		return this.saldo;
	}

}
