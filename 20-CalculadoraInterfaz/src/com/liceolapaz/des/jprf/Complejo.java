package com.liceolapaz.des.jprf;

public class Complejo implements Numero {
	private int real;
	private int imaginaria;

	public Complejo(int real, int imaginaria) {
		super();
		this.real = real;
		this.imaginaria = imaginaria;
	}

	@Override
	public Numero sumar(Numero operando) {
		if (operando instanceof Complejo) {
			Complejo op = (Complejo)operando;
			Numero resultado = null;
			int parteReal = this.real + op.real;
			int parteImaginaria = this.imaginaria + op.imaginaria;
			resultado = new Complejo(parteReal, parteImaginaria);
			return resultado;
		}
		return null;
	}

	@Override
	public Numero restar(Numero operando) {
		if (operando instanceof Complejo) {
			Complejo op = (Complejo)operando;
			Numero resultado = null;
			int parteReal = this.real - op.real;
			int parteImaginaria = this.imaginaria - op.imaginaria;
			resultado = new Complejo(parteReal, parteImaginaria);
			return resultado;
		}
		return null;
	}

	@Override
	public Numero multiplicar(Numero operando) {
		if (operando instanceof Complejo) {
			Complejo op = (Complejo)operando;
			Numero resultado = null;
			int parteReal = this.real * op.real - this.imaginaria * op.imaginaria;
			int parteImaginaria = this.real * op.imaginaria + this.imaginaria * op.real;
			resultado = new Complejo(parteReal, parteImaginaria);
			return resultado;
		}
		return null;
	}

	@Override
	public Numero dividir(Numero operando) {
		if (operando instanceof Complejo) {
			Complejo op = (Complejo)operando;
			Numero resultado = null;
			int parteReal = (this.real * op.real + this.imaginaria * op.imaginaria) / ((int)Math.pow(op.real, 2) + (int)Math.pow(op.imaginaria, 2));
			int parteImaginaria = (this.imaginaria * op.real - this.real * op.imaginaria) / ((int)Math.pow(op.real, 2) + (int)Math.pow(op.imaginaria, 2));
			resultado = new Complejo(parteReal, parteImaginaria);
			return resultado;
		}
		return null;
	}

	@Override
	public String mostrar() {
		if (this.imaginaria > 0) {
			return this.real + "+" + this.imaginaria + "i";
		} else if (this.imaginaria < 0) {
			return this.real + "" + this.imaginaria + "i";
		} else {
			return this.real + "";
		}
	}

}
