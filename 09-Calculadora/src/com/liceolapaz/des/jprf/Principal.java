package com.liceolapaz.des.jprf;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		do {
			// Escribir menú
			escribirMenu();
			// Pedir opción
			pedirOpcion();
			// Leer opción y almacenarla
			int opcion = leerOpcion();
			// Si la opcion es 0
			if (opcion == 0) {
				// Salir
				System.exit(0);
			}
			// Si la opcion es 1, 2, 3 o 4
			else if (opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4) {
				// Pedir el primer operando
				pedirPrimerOperando();
				// Leer el primer operando y almacenarlo
				double primerOperando = leerOperando();
				// Pedir el segundo operando
				pedirSegundoOperando();
				// Leer el segundo operando y almacenarlo
				double segundoOperando = leerOperando();
				// Escribir resultado
				escribirResultado(primerOperando, segundoOperando, opcion);
			}
			// Si es otra opción
			else {
				// Mostrar mensaje de error
				System.out.println("Opción no válida");
			}
		} while (true);
	}

	private static void escribirResultado(double primerOperando, double segundoOperando, int opcion) {
		double resultado = 0;
		switch (opcion) {
		// Suma
		case 1:
			resultado = primerOperando + segundoOperando;
			break;
		// Resta
		case 2:
			resultado = primerOperando - segundoOperando;
			break;
		// Producto
		case 3:
			resultado = primerOperando * segundoOperando;
			break;
		// División
		case 4:
			resultado = primerOperando / segundoOperando;
			break;
		}
		System.out.println("El resultado de la operación es: " + resultado);
	}

	private static void pedirSegundoOperando() {
		System.out.print("Escriba el segundo operando: ");
	}

	private static double leerOperando() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextDouble();
	}

	private static void pedirPrimerOperando() {
		System.out.print("Escriba el primer operando: ");
	}

	private static int leerOpcion() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static void pedirOpcion() {
		System.out.print("Escoja una opción: ");
	}

	private static void escribirMenu() {
		System.out.println(
				"\nCALCULADORA\n" + "1. Suma\n" + "2. Resta\n" + "3. Producto\n" + "4. División\n" + "0. Salir");
	}

}
