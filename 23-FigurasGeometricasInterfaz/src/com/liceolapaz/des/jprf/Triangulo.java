package com.liceolapaz.des.jprf;

public class Triangulo implements FiguraGeometrica {
	
	private double lado1;
	private double lado2;
	private double lado3;
	private double altura;

	public Triangulo(double lado1, double lado2, double lado3, double altura) {
		super();
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
		this.altura = altura;
	}

	@Override
	public double calcularArea() {
		return (this.lado1 * this.altura) / 2;
	}

	@Override
	public double calcularPerimetro() {
		return this.lado1 + this.lado2 + this.lado3;
	}

}
