package com.liceolapaz.des.jprf;

import java.util.Scanner;

public class Principal {
	private static final int ANHO_ACTUAL = 2021;

	public static void main(String[] args) {
		// Pedir año de nacimiento
		pedirAnho();
		// Leer año y almacenarlo
		int anho = leerAnho();
		// Escribir mensaje
		escribirMensaje(anho);
	}

	private static void escribirMensaje(int anho) {
		// Crear una variable para almacenar el mensaje
		String mensaje = "";
		// Comprobar anho y almacenar mensaje en la variable
		if (anho > ANHO_ACTUAL) {
			mensaje = "No puedes haber nacido en el futuro";
		} else if (ANHO_ACTUAL - anho > 150) {
			mensaje = "Tendrías que estar muerto";
		} else if (ANHO_ACTUAL - anho >= 18) {
			mensaje = "Puedes pasar";
		} else {
			mensaje = "No puedes pasar";
		}
		// Escribir mensaje por pantalla
		System.out.println(mensaje);
	}

	private static int leerAnho() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static void pedirAnho() {
		System.out.print("Escriba su año de nacimiento: ");
	}

}
