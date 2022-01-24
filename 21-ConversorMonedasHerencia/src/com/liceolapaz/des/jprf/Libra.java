package com.liceolapaz.des.jprf;

public class Libra extends Moneda {
	private static final double LIBRA_A_EURO = 1.19;

	public Libra(double cantidad) {
		super(cantidad, LIBRA_A_EURO);
	}
}
