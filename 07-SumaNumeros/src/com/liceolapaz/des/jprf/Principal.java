package com.liceolapaz.des.jprf;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// Pedir números al usuario
		pedirNumeros();
		// Crear variable para almacenar números
		int[] numeros = new int[10];
		// Leer números
		int contador = 0;
		do {
			numeros[contador] = leerNumero();
			contador++;
		} while(contador < 10);
		// Calcular suma y almacenarla
		int sumaTotal = calcularSuma(numeros);
		// Escribir el resultado
		escribirResultado(sumaTotal);
	}

	private static void escribirResultado(int sumaTotal) {
		System.out.println("La suma de los números es " + sumaTotal);
	}

	private static int calcularSuma(int[] numeros) {
		int total = 0;
		for (int i = 0; i < numeros.length; i++) {
			total += numeros[i]; // total = total + numeros[i];
		}
		return total;
	}

	private static int leerNumero() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static void pedirNumeros() {
		System.out.println("Escriba 10 números enteros:");
	}

}
