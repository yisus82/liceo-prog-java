package com.liceolapaz.des.jprf;

public class Yen extends Moneda {
	private static final double YEN_A_EURO = 0.0075;

	public Yen(double cantidad) {
		super(cantidad, YEN_A_EURO);
	}
}
