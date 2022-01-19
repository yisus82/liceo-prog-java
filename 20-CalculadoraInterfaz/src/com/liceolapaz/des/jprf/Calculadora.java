package com.liceolapaz.des.jprf;

import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		do {
			escribirMenu();
			pedirOpcion();
			int opcion = leerEntero();
			if (opcion == 0) {
				System.exit(0);
			} else if (opcion >= 1 && opcion <= 4) {
				escribirSubmenu();
				pedirOpcion();
				int opcionSubmenu = leerEntero();
				Numero operando1 = null;
				Numero operando2 = null;
				Numero resultado = null;
				switch (opcionSubmenu) {
				case 1:
					pedirValor1();
					int valor1 = leerEntero();
					pedirValor2();
					int valor2 = leerEntero();
					operando1 = new Entero(valor1);
					operando2 = new Entero(valor2);
					resultado = realizarOperacion(opcion, operando1, operando2);
					if (resultado != null) {
						System.out.println("El resultado es: " + resultado.mostrar());
					} else {
						System.out.println("Error al calcular el resultado");
					}
					break;
					
				case 2:
					pedirNumerador1();
					int numerador1 = leerEntero();
					pedirDenominador1();
					int denominador1 = leerEntero();
					pedirNumerador2();
					int numerador2 = leerEntero();
					pedirDenominador2();
					int denominador2 = leerEntero();
					operando1 = new Racional(numerador1, denominador1);
					operando2 = new Racional(numerador2, denominador2);
					resultado = realizarOperacion(opcion, operando1, operando2);
					if (resultado != null) {
						System.out.println("El resultado es: " + resultado.mostrar());
					} else {
						System.out.println("Error al calcular el resultado");
					}
					break;
					
				case 3:
					pedirParteReal1();
					int parteReal1 = leerEntero();
					pedirParteImaginaria1();
					int parteImaginaria1 = leerEntero();
					pedirParteReal2();
					int parteReal2 = leerEntero();
					pedirParteImaginaria2();
					int parteImaginaria2 = leerEntero();
					operando1 = new Complejo(parteReal1, parteImaginaria1);
					operando2 = new Complejo(parteReal2, parteImaginaria2);
					resultado = realizarOperacion(opcion, operando1, operando2);
					if (resultado != null) {
						System.out.println("El resultado es: " + resultado.mostrar());
					} else {
						System.out.println("Error al calcular el resultado");
					}
					break;

				default:
					System.out.println("Opción no válida");
					break;
				}
			} else {
				System.out.println("Opción no válida");
			}
		} while(true);
	}

	private static void pedirParteReal1() {
		System.out.print("Escriba la parte real del operando 1: ");
	}
	
	private static void pedirParteImaginaria1() {
		System.out.print("Escriba la parte imaginaria del operando 1: ");
	}
	
	private static void pedirParteReal2() {
		System.out.print("Escriba la parte real del operando 2: ");
	}
	
	private static void pedirParteImaginaria2() {
		System.out.print("Escriba la parte imaginaria del operando 2: ");
	}

	private static void pedirNumerador1() {
		System.out.print("Escriba el numerador del primer operando: ");
	}
	
	private static void pedirDenominador1() {
		System.out.print("Escriba el denominador del primer operando: ");
	}
	
	private static void pedirNumerador2() {
		System.out.print("Escriba el numerador del segundo operando: ");
	}
	
	private static void pedirDenominador2() {
		System.out.print("Escriba el denominador del segundo operando: ");
	}

	private static Numero realizarOperacion(int opcion, Numero operando1, Numero operando2) {
		switch (opcion) {
		case 1:
			return operando1.sumar(operando2);
			
		case 2:
			return operando1.restar(operando2);
			
		case 3:
			return operando1.multiplicar(operando2);
			
		case 4:
			return operando1.dividir(operando2);

		default:
			return null;
		}
	}

	private static void pedirValor2() {
		System.out.print("Introduzca el valor del segundo operando: ");
	}

	private static void pedirValor1() {
		System.out.print("Introduzca el valor del primer operando: ");
	}

	private static void escribirSubmenu() {
		System.out.println("\nTipo de números\n1.Enteros\n2.Racionales\n3.Complejos");
	}

	private static int leerEntero() {
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
