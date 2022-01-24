package com.liceolapaz.des.jprf;

public class Dolar extends Moneda {
	private static final double DOLAR_A_EURO = 0.86;

	public Dolar(double cantidad) {
		super(cantidad, DOLAR_A_EURO);
	}
}
