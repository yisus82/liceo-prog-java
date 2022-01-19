package com.liceolapaz.des.jprf;

public class Racional implements Numero {
	private int numerador;
	private int denominador;

	public Racional(int numerador, int denominador) {
		super();
		this.numerador = numerador;
		this.denominador = denominador;
	}

	@Override
	public Numero sumar(Numero operando) {
		if (operando instanceof Racional) {
			Racional op = (Racional)operando;
			Numero resultado = null;
			int nuevoNumerador = this.numerador * op.denominador + op.numerador * this.denominador;
			int nuevoDenominador = this.denominador * op.denominador;
			resultado = new Racional(nuevoNumerador, nuevoDenominador);
			return resultado;
		} else {
			System.out.println("El operando no es un número racional");
		}
		return null;
	}

	@Override
	public Numero restar(Numero operando) {
		if (operando instanceof Racional) {
			Racional op = (Racional)operando;
			Numero resultado = null;
			int nuevoNumerador = this.numerador * op.denominador - op.numerador * this.denominador;
			int nuevoDenominador = this.denominador * op.denominador;
			resultado = new Racional(nuevoNumerador, nuevoDenominador);
			return resultado;
		} else {
			System.out.println("El operando no es un número racional");
		}
		return null;
	}

	@Override
	public Numero multiplicar(Numero operando) {
		if (operando instanceof Racional) {
			Racional op = (Racional)operando;
			Numero resultado = null;
			int nuevoNumerador = this.numerador * op.numerador;
			int nuevoDenominador = this.denominador * op.denominador;
			resultado = new Racional(nuevoNumerador, nuevoDenominador);
			return resultado;
		} else {
			System.out.println("El operando no es un número racional");
		}
		return null;
	}

	@Override
	public Numero dividir(Numero operando) {
		if (operando instanceof Racional) {
			Racional op = (Racional)operando;
			Numero resultado = null;
			int nuevoNumerador = this.numerador * op.denominador;
			int nuevoDenominador = this.denominador * op.numerador;
			resultado = new Racional(nuevoNumerador, nuevoDenominador);
			return resultado;
		} else {
			System.out.println("El operando no es un número racional");
		}
		return null;
	}

	@Override
	public String mostrar() {
		return this.numerador + " / " + this.denominador;
	}

}
