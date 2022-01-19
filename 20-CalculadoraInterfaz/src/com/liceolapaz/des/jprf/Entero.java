package com.liceolapaz.des.jprf;

public class Entero implements Numero {
	private int valor;

	public Entero(int valor) {
		super();
		this.valor = valor;
	}

	@Override
	public Numero sumar(Numero operando) {
		if (operando instanceof Entero) {
			Entero op = (Entero)operando;
			Numero resultado = null;
			resultado = new Entero(this.valor + op.valor);
			return resultado;
		} else {
			System.out.println("El operando no es un número entero");
		}
		return null;
	}

	@Override
	public Numero restar(Numero operando) {
		if (operando instanceof Entero) {
			Entero op = (Entero)operando;
			Numero resultado = null;
			resultado = new Entero(this.valor - op.valor);
			return resultado;
		} else {
			System.out.println("El operando no es un número entero");
		}
		return null;
	}

	@Override
	public Numero multiplicar(Numero operando) {
		if (operando instanceof Entero) {
			Entero op = (Entero)operando;
			Numero resultado = null;
			resultado = new Entero(this.valor * op.valor);
			return resultado;
		} else {
			System.out.println("El operando no es un número entero");
		}
		return null;
	}

	@Override
	public Numero dividir(Numero operando) {
		if (operando instanceof Entero) {
			Entero op = (Entero)operando;
			Numero resultado = null;
			if (op.valor == 0) {
				System.out.println("ERROR: División entre cero");
				return null;
			}
			resultado = new Entero(this.valor / op.valor);
			return resultado;
		} else {
			System.out.println("El operando no es un número entero");
		}
		return null;
	}

	@Override
	public String mostrar() {
		String texto = "";
		texto += this.valor;
		return texto;
	}

}
