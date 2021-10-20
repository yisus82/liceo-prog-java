package com.liceolapaz.des.jprf;

import java.util.Random;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// Pedimos al usuario el número a buscar
		pedirNumeroBuscar();
		// Leemos el número a buscar y lo almacenamos
		int numeroBuscar = leerEntero();
		/*
		 * Pedimos al usuario el número máximo de intentos
		 */
		pedirMaximoIntentos();
		/*
		 * Leemos el número máximo de intentos y lo almacenamos
		 */
		int maximoIntentos = leerEntero();
		// Almacenar número intentos;
		int numeroIntentos = 0;
		while (numeroIntentos < maximoIntentos) {
			// Generar número aleatorio y almacenarlo
			int numeroAleatorio = generarNumeroAleatorio(1, 10);
			// Imprimir número generado
			System.out.println("El número generado fue: " + numeroAleatorio);
			// Sumar 1 a los intentos
			numeroIntentos++; // numeroIntentos = numeroIntentos + 1;
			/*
			 * Comprobar si el número generado es igual al número a buscar
			 */
			comprobarNumero(numeroBuscar, numeroAleatorio, numeroIntentos, maximoIntentos);
			// Si encontramos el número salir del bucle
			if (numeroAleatorio == numeroBuscar) {
				break;
			}
		}
	}

	private static void comprobarNumero(int numeroBuscar, int numeroAleatorio, int numeroIntentos, int maximoIntentos) {
		// Si son iguales, imprimir mensaje
		if (numeroBuscar == numeroAleatorio) {
			System.out.println("Número encontrado en " + numeroIntentos + " intento(s)");
		}
		// Si no lo son y hay más intentos, repetir
		else if (numeroIntentos < maximoIntentos) {
			return;
		}
		// Si no hay más intentos, escribir mensaje
		else {
			System.out.println("No se ha podido encontrar el número en " + maximoIntentos + " intento(s)");
		}
	}

	private static int generarNumeroAleatorio(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

	private static void pedirMaximoIntentos() {
		System.out.print("Escriba el número máximo de intentos: ");
	}

	private static int leerEntero() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static void pedirNumeroBuscar() {
		System.out.print("Escriba el número a buscar (entre 1 y 10): ");
	}

}
