package com.liceolapaz.des.jprf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		while(true) {
			escribirMenu();
			pedirOpcion();
			int opcion = leerOpcion();
			switch (opcion) {
			case 0:
				System.exit(0);
				break;
			
			case 1:
				// Leer empleados
				pedirRuta();
				String ruta = leerRuta();
				leerEmpleados(ruta);

			default:
				System.out.println("Opción no válida");
				break;
			}
		}
	}

	private static void leerEmpleados(String ruta) {
		File fichero = new File(ruta);
		if (fichero.isFile()) {
			try {
				Scanner escaner = new Scanner(fichero);
				if (escaner.hasNext()) {
					escaner.nextLine();
					while(escaner.hasNext()) {
						String linea = escaner.nextLine();
						String[] columnas = linea.split(",");
						String dni = columnas[0].substring(2, 11);
//						System.out.println(dni);
						
					}
				}
			} catch (FileNotFoundException e) {
				System.out.println("La ruta " + ruta + " no existe");
			}
		} else {
			System.out.println("La ruta " + ruta + " no es un fichero");
		}
	}

	private static String leerRuta() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextLine();
	}

	private static void pedirRuta() {
		System.out.print("Escriba la ruta del fichero: ");
	}

	private static void escribirMenu() {
		System.out.println("\nGESTOR DE EMPLEADOS"
				+ "\n1. Leer empleados"
				+ "\n2. Añadir empleado"
				+ "\n3. Eliminar empleado"
				+ "\n4. Modificar empleado"
				+ "\n5. Exportar empleados"
				+ "\n0. Salir");
	}

	private static int leerOpcion() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static void pedirOpcion() {
		System.out.println("Escoja una opción: ");
	}

}
