package com.liceolapaz.des.jprf;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		while (true) {
			// Escribir menú
			escribirMenu();
			// Pedir opción
			pedirOpcion();
			// Leer opción y almacenarla
			int opcion = leerEntero();
			// Si la opción es 0
			if (opcion == 0) {
				// Salir
				System.exit(0);
			}
			// Si la opción es 1
			else if (opcion == 1) {
				// Pedir número binario
				pedirNumeroBinario();
				// Leer número binario y almacenarlo
				int numeroBinario = leerEntero();
				// Comprobar si es negativo
				if (numeroBinario < 0) {
					// Mostrar error
					System.out.println("Introduzca solo números positivos");
				} else {
					String numeroTexto = "" + numeroBinario;
					// Comprobar si tiene algo que no sea 0 ó 1
					if (!numeroTexto.trim().matches("[01]+")) {
						// Mostrar error
						System.out.println("El número introducido no es binario");
					} else {
						int resultadoDecimal = binarioADecimal(numeroTexto);
						System.out.println("El resultado de la conversión es " + resultadoDecimal);
					}
				}
			}
			// Si la opción es 2
			else if (opcion == 2) {
				// Pedir número decimal
				pedirNumeroDecimal();
				// Leer número decimal y almacenarlo
				int numeroDecimal = leerEntero();
				// Comprobar si es negativo
				if (numeroDecimal < 0) {
					// Mostrar error
					System.out.println("Introduzca solo números positivos");
				} else {
					String resultadoBinario = decimalABinario(numeroDecimal);
					System.out.println("El resultado de la conversión es " + resultadoBinario);
				}
			}
			// Si es otra opción
			else {
				// Mostrar error
				System.out.println("Opción no válida");
			}
		}
	}

	private static String decimalABinario(int numeroDecimal) {
		String resultado = "";
		int dividendo = numeroDecimal;
		int resto = 0;
		while (dividendo > 0) {
			resto = dividendo % 2;
			dividendo /= 2;
			resultado = resto + resultado;
		}
		return resultado;
	}

	private static void pedirNumeroDecimal() {
		System.out.print("Introduzca un número decimal: ");
	}

	private static int binarioADecimal(String numeroTexto) {
		int resultado = 0;
		int posicion = numeroTexto.length() - 1;
		int exponente = 0;
		
		while(posicion >= 0) {
			resultado += Math.pow(2, exponente) * Character.getNumericValue(numeroTexto.charAt(posicion));
			exponente++;
			posicion--;
		}
		
		return resultado;
	}

	private static void pedirOpcion() {
		System.out.print("Escoja una opción: ");
	}

	private static void pedirNumeroBinario() {
		System.out.print("Introduzca un número binario: ");
	}

	private static int leerEntero() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static void escribirMenu() {
		System.out.println(
				"\nCONVERSOR BINARIO" + "\n1. De binario a decimal" + "\n2. De decimal a binario" + "\n0. Salir");
	}

}
