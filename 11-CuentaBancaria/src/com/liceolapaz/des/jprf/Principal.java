package com.liceolapaz.des.jprf;

import java.util.Scanner;

public class Principal {
	private static final int SIN_CUENTA = 0;
	private static final int CUENTA_NORMAL = 1;
	private static final int CUENTA_PREMIUM = 2;

	private static int tipoCuenta = SIN_CUENTA;
	private static double saldoCuenta = 0;

	public static void main(String[] args) {
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
					crearCuenta(CUENTA_NORMAL);
				}
				// Si la opción 2 es 2
				else if (opcion2 == 2) {
					crearCuenta(CUENTA_PREMIUM);
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
				ingresarDinero();
				break;
			// Si la opción es 3
			case 3:
				retirarDinero();
				break;
			// Si la opción es 4
			case 4:
				// Mostrar saldo
				mostrarSaldo();
				break;
			// Si es otra opción
			default:
				// Mostrar error
				System.out.println("Opción no válida");
				break;
			}
		} while (true);
	}

	private static void retirarDinero() {
		// Pedir cantidad
		pedirCantidad();
		// Leer cantidad y almacenarla
		double cantidad = leerDouble();
		// Si la cantidad es positiva
		if (cantidad > 0) {
			// Si es cuenta normal y no hay suficiente saldo
			if (tipoCuenta == CUENTA_NORMAL && saldoCuenta < cantidad) {
				// Mostrar mensaje de error
				System.out.println("Las cuentas normales no pueden tener saldo negativo");
			}
			// En otro caso
			else {
				// Restar cantidad al saldo
				saldoCuenta -= cantidad;
				// Mostrar saldo
				mostrarSaldo();
			}
		}
		// Si no lo es
		else {
			// Mostrar error
			System.out.println("La cantidad a retirar debe ser positiva");
		}
	}

	private static void ingresarDinero() {
		// Pedir cantidad
		pedirCantidad();
		// Leer cantidad y almacenarla
		double cantidad = leerDouble();
		// Si la cantidad es positiva
		if (cantidad > 0) {
			// Sumar cantidad al saldo
			saldoCuenta += cantidad;
			// Mostrar saldo
			mostrarSaldo();
		}
		// Si no lo es
		else {
			// Mostrar error
			System.out.println("La cantidad a ingresar debe ser positiva");
		}
	}

	private static void pedirCantidad() {
		System.out.print("Escriba la cantidad: ");
	}

	private static void mostrarSaldo() {
		// Si hay cuenta activa
		if (tipoCuenta != SIN_CUENTA) {
			// Escribir saldo
			System.out.println("El saldo de la cuenta es " + String.format("%.2f", saldoCuenta) + " €");
		}
		// Si no hay
		else {
			// Mostrar error
			System.out.println("No hay cuenta activa");
		}
	}

	private static void crearCuenta(int tipo) {
		// Pedir saldo inicial
		pedirSaldoInicial();
		// Leer saldo y almacenarlo
		saldoCuenta = leerDouble();
		// Si el el saldo es negativo
		if (saldoCuenta < 0) {
			// Mostrar error
			System.out.println("El saldo inicial no puede ser negativo");
			// Resetear el saldo
			saldoCuenta = 0;
			// Resetear tipo de cuenta
			tipoCuenta = SIN_CUENTA;
			// Salir del método
			return;
		}
		// Establecer tipo cuenta normal
		tipoCuenta = tipo;
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
