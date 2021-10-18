package com.liceolapaz.des.jprf;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		// Pedir número al usuario
		pedirNumero();
		// Leer el número y guardarlo
		int numeroUsuario = leerNumero();
		// Escribir si el número es par o impar
		escribirMensaje(numeroUsuario);
	}

	private static void escribirMensaje(int numeroUsuario) {
		// Almacenar el mensaje en una variable
		String mensaje = 
				(numeroUsuario == 0) ? 
					"El número no es par ni impar" :
						(numeroUsuario % 2 == 0) ? 
					"El número introducido es par" :
						"El número introducido es impar";
		// Escribir por pantalla el mensaje
		System.out.println(mensaje);
	}

	private static int leerNumero() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static void pedirNumero() {
		System.out.print("Escriba un número entero: ");
	}
}
