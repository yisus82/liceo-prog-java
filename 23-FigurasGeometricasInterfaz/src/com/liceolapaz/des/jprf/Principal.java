package com.liceolapaz.des.jprf;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		do {
			// Escribir menú
			escribirMenu();
			// Pedir opción
			pedirOpcion();
			// Leer la opción y almacenarla
			int opcion = leerOpcion();
			// Variable para la figura geométrica
			FiguraGeometrica figura = null;
			switch(opcion) {
			// Si la opción es 0
			case 0:
				// Salir
				System.exit(0);
				break;
			// Si la opción es 1 (Triángulo)
			case 1:
				// Pedir la base
				pedirBaseTriangulo();
				// Leer la base y almacenarla
				double baseTriangulo = leerDouble();
				// Pedir el segundo lado
				pedirSegundoLado();
				// Leer el segundo lado y almacenarlo
				double segundoLado = leerDouble();
				// Pedir el tercer lado
				pedirTercerLado();
				// Leer el tercer lado y almacenarlo
				double tercerLado = leerDouble();
				// Pedir la altura
				pedirAlturaTriangulo();
				// Leer la altura y almacenarla
				double alturaTriangulo = leerDouble();
				// Crear figura y almacenarla
				figura = new Triangulo(baseTriangulo, segundoLado, tercerLado, alturaTriangulo);
				break;
			// Si la opción es 2 (Rectángulo)
			case 2:
				// Pedir la base
				pedirBaseRectangulo();
				// Leer la base y almacenarla
				double baseRectangulo = leerDouble();
				// Pedir la altura
				pedirAlturaRectangulo();
				// Leer la altura y almacenarla
				double alturaRectangulo = leerDouble();
				// Crear figura y almacenarla
				figura = new Rectangulo(baseRectangulo, alturaRectangulo);
				break;
			// Si la opción es 3 (Cuadrado)
			case 3:
				// Pedir el lado
				pedirLadoCuadrado();
				// Leer el lado y almacenarlo
				double ladoCuadrado = leerDouble();
				// Crear figura y almacenarla
				figura = new Cuadrado(ladoCuadrado);
				break;
			// Si la opción es 4 (Pentágono)
			case 4:
				// Pedir lado
				pedirLadoPentagono();
				// Leer lado y almacenarlo
				double ladoPentagono = leerDouble();
				// Pedir apotema
				pedirApotema();
				// Leer apotema y almacenarla
				double apotema = leerDouble();
				// Crear figura y almacenarla
				figura = new Pentagono(ladoPentagono, apotema);
				break;
			// Si es otra opción
			default:
				// Mostrar mensaje de error
				System.out.println("Opción no válida");
				continue;
			}
			// Calcular área
			double area = figura.calcularArea();
			// Calcular perímetro
			double perimetro = figura.calcularPerimetro();
			// Escribir resultado
			escribirResultado(area, perimetro);
		} while(true);
	}

	private static void pedirApotema() {
		System.out.print("Escriba el apotema del pentágono: ");
	}

	private static void pedirLadoPentagono() {
		System.out.print("Escriba el lado del pentágono: ");
	}

	private static void pedirLadoCuadrado() {
		System.out.print("Escriba el lado del cuadrado: ");
	}

	private static void pedirAlturaRectangulo() {
		System.out.print("Escriba la altura del rectángulo: ");
	}

	private static void pedirBaseRectangulo() {
		System.out.print("Escriba la base del rectángulo: ");
	}

	private static void escribirResultado(double area, double perimetro) {
		System.out.println("El área es " + area + " y el perímetro es " + perimetro);
	}

	private static void pedirAlturaTriangulo() {
		System.out.print("Escriba la altura del triángulo: ");
	}

	private static void pedirTercerLado() {
		System.out.print("Escriba el tercer lado del triángulo: ");
	}

	private static void pedirSegundoLado() {
		System.out.print("Escriba el segundo lado del triángulo: ");
	}

	private static double leerDouble() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextDouble();
	}

	private static void pedirBaseTriangulo() {
		System.out.print("Escriba el valor del primer lado (base) del triángulo: ");
	}

	private static int leerOpcion() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static void pedirOpcion() {
		System.out.print("Escoja una opción: ");
	}

	private static void escribirMenu() {
		System.out.println("\nFIGURAS GEOMÉTRICAS\n"
				+ "1. Triángulo\n"
				+ "2. Rectángulo\n"
				+ "3. Cuadrado\n"
				+ "4. Pentágono\n"
				+ "0. Salir");
	}

}
