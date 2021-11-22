package com.liceolapaz.des.jprf;

import java.util.Locale;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		// Pedir los números
		pedirNumeros();
		// Variable para almacenar números
		int[] numeros = new int[11];
		// Para contar números almacenados
		numeros[10] = 0;
		while(true) {
			// Leer el número y almacenarlo
			numeros[numeros[10]] = leerNumero();
			// Si es positivo
			if (numeros[numeros[10]] > 0) {
				numeros[10]++;
			}
			// Si no es positivo
			else {
				// Mostrar un mensaje de error
				System.out.println("Por favor, introduzca solo números enteros positivos");
				continue;
			}
			if (numeros[10] == 10) {
				break;
			}
		}
		// Escribir números
		System.out.print("Los números introducidos fueron:");
		for (numeros[10] = numeros.length - 2; numeros[10] >= 0; numeros[10]--) {
			System.out.print(" " + numeros[numeros[10]]);
		}
		System.out.println();
		// Escribir mensaje de despedida
		System.out.println("¡Hasta la próxima!");
	}

	private static int leerNumero() {
		return new Scanner(System.in).nextInt();
	}

	private static void pedirNumeros() {
		System.out.println("Escriba 10 números enteros positivos enteros:");
	}
}
