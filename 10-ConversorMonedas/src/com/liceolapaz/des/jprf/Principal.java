package com.liceolapaz.des.jprf;

import java.util.Scanner;

public class Principal {

	private static final double YEN_A_EURO = 0.0075;
	private static final double LIBRA_A_EURO = 1.19;
	private static final double DOLAR_A_EURO = 0.86;

	public static void main(String[] args) {
		do {
			// Escribir menú
			escribirMenu();
			// Pedir opción
			pedirOpcion();
			// Leer opción y almacenarla
			int opcion = leerOpcion();
			switch (opcion) {
			// Si la opción es 0
			case 0:
				// Salir
				System.exit(0);
				break;
			// Si la opción es 1, 2, 3
			case 1:
			case 2:
			case 3:
				// Pedir cantidad
				pedirCantidad();
				// Leer cantidad y almacenarla
				double cantidad = leerCantidad();
				// Escribir resultado
				escribirResultado(cantidad, opcion);
				break;
			// Si es otra opción
			default:
				// Mostrar mensaje de error
				System.out.println("Opción no válida");
			}
		} while (true);
	}

	private static void escribirResultado(double cantidad, int opcion) {
		double resultado = 0;
		if (opcion == 1) {
			resultado = cantidad * DOLAR_A_EURO;
		} else if (opcion == 2) {
			resultado = cantidad * LIBRA_A_EURO;
		} else if (opcion == 3) {
			resultado = cantidad * YEN_A_EURO;
		}
		System.out.println("La cantidad en euros es " + String.format("%.2f", resultado));
	}

	private static double leerCantidad() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextDouble();
	}

	private static void pedirCantidad() {
		System.out.print("Escriba la cantidad: ");
	}

	private static int leerOpcion() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static void pedirOpcion() {
		System.out.print("Escoja una opción: ");
	}

	private static void escribirMenu() {
		System.out.println("\nCONVERSOR DE MONEDAS\n" + "1. Dólares\n" + "2. Libras\n" + "3. Yens\n" + "0. Salir");
	}

}
