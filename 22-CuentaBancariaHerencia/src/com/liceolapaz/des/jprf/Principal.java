package com.liceolapaz.des.jprf;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		CuentaBancaria cuenta = null;
		do {
			// Escribir menú principal
			escribirMenuPrincipal();
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
			// Si la opción es 1
			case 1:
				// Escribir submenú
				escribirSubmenu();
				// Pedir opción 2
				pedirOpcion();
				// Leer la opción 2 y almacenarla
				int opcion2 = leerOpcion();
				// Si la opción 2 es 1
				if (opcion2 == 1) {
					// Pedir saldo inicial
					pedirSaldoInicial();
					// Leer saldo y almacenarlo
					double saldoInicial = leerDouble();
					cuenta = new CuentaNormal(saldoInicial);
				}
				// Si la opción 2 es 2
				else if (opcion2 == 2) {
					// Pedir saldo inicial
					pedirSaldoInicial();
					// Leer saldo y almacenarlo
					double saldoInicial = leerDouble();
					cuenta = new CuentaPremium(saldoInicial);
				}
				// Si la opción es 0
				else if (opcion2 == 0) {
					// Volver al menú principal
				}
				// Si es otra opción
				else {
					// Mostrar mensaje de error
					System.out.println("Opción no válida");
				}
				break;
			// Si la opción es 2
			case 2:
				if (cuenta == null) {
					System.out.println("No hay cuenta activa");
				} else {
					// Pedir cantidad
					pedirCantidad();
					// Leer cantidad y almacenarla
					double cantidad = leerDouble();
					cuenta.ingresarDinero(cantidad);
					// Escribir saldo
					System.out.println("El saldo de la cuenta es " + String.format("%.2f", cuenta.verSaldo()) + " €");
				}
				break;
			// Si la opción es 3
			case 3:
				if (cuenta == null) {
					System.out.println("No hay cuenta activa");
				} else {
					// Pedir cantidad
					pedirCantidad();
					// Leer cantidad y almacenarla
					double cantidad = leerDouble();
					cuenta.retirarDinero(cantidad);
					// Escribir saldo
					System.out.println("El saldo de la cuenta es " + String.format("%.2f", cuenta.verSaldo()) + " €");
				}
				break;
			// Si la opción es 4
			case 4:
				if (cuenta == null) {
					System.out.println("No hay cuenta activa");
				} else {
					// Escribir saldo
					System.out.println("El saldo de la cuenta es " + String.format("%.2f", cuenta.verSaldo()) + " €");
				}
				break;
			// Si es otra opción
			default:
				// Mostrar error
				System.out.println("Opción no válida");
				break;
			}
		} while (true);
	}

	private static void pedirCantidad() {
		System.out.print("Escriba la cantidad: ");
	}

	private static double leerDouble() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextDouble();
	}

	private static void pedirSaldoInicial() {
		System.out.print("Escriba el saldo inicial: ");
	}

	private static void escribirSubmenu() {
		System.out.println("\nTipo de cuenta\n" + " 1. Cuenta normal\n" + " 2. Cuenta Premium\n" + " 0. Cancelar");
	}

	private static int leerOpcion() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static void pedirOpcion() {
		System.out.print("Escoja una opción: ");
	}

	private static void escribirMenuPrincipal() {
		System.out.println("\nBANCO\n" + " 1. Crear cuenta\n" + " 2. Ingresar dinero\n" + " 3. Retirar dinero\n"
				+ " 4. Consultar saldo\n" + " 0. Salir");
	}

}
