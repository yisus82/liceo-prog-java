package com.liceolapaz.des.jprf;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// Pedir el día
		pedirDia();
		// Leer el día y almacenarlo
		int dia = leerEntero();
		// Pedir el mes
		pedirMes();
		// Leer el mes y almacenarlo
		int mes = leerEntero();
		// Pedir el año
		pedirAnho();
		// Leer el año y almacenarlo
		int anho = leerEntero();
		// Comprobar fecha y almacenar el mensaje
		String mensaje = comprobarFecha(dia, mes, anho);
		//Escribir mensaje
		escribirMensaje(mensaje);
	}

	private static String comprobarFecha(int dia, int mes, int anho) {
		String mensaje = "La fecha introducida es una fecha válida";
		String[] nombresMes = { "Enero", "Febrero", "Marzo", 
				"Abril", "Mayo", "Junio", 
				"Julio", "Agosto", "Septiembre", 
				"Octubre", "Noviembre", "Diciembre"};
		int[] diasMes = { 31, 28, 31, 30, 31, 30, 
				31, 31, 30, 31, 30, 31};
		
		if (dia < 1 || dia > 31) {
			mensaje = "El día tiene que ser un valor entre 1 y 31";
		} else if (mes < 1 || mes > 12) {
			mensaje = "El mes tiene que ser un valor entre 1 y 12";
		} else if (anho == 0) {
			mensaje = "El año no puede ser 0";
		} else if (dia == 29 && mes == 2) {
			boolean esBisiesto = comprobarBisiesto(anho);
			if (!esBisiesto) {
				mensaje = "El año " + anho + " no es bisiesto por lo que el mes de febrero solo tiene 28 días";
			}
		} else if (dia > diasMes[mes - 1]) {
			mensaje = "El mes de " + nombresMes[mes - 1] + " no puede tener " + dia + " días";
		}
		
		return mensaje;
	}

	private static boolean comprobarBisiesto(int anho) {
		return anho % 4 == 0 && (!(anho % 100 == 0) || (anho % 400 == 0));
	}

	private static void escribirMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	private static void pedirAnho() {
		System.out.print("Introduzca el año: ");
	}

	private static void pedirMes() {
		System.out.print("Introduzca el mes: ");
	}

	private static int leerEntero() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static void pedirDia() {
		System.out.print("Introduzca el día: ");
	}

}
