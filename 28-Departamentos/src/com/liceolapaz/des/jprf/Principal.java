package com.liceolapaz.des.jprf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
	private static HashMap<Integer, Departamento> departamentos = new HashMap<>();

	public static void main(String[] args) {
		while (true) {
			escribirMenu();
			pedirOpcion();
			int opcion = leerOpcion();
			switch (opcion) {
			case 0:
				System.exit(0);
				break;
				
			case 1:
				pedirRuta();
				String ruta = leerRuta();
				leerFichero(ruta);
				//System.out.println(departamentos);
				break;
				
			case 2:
				Departamento departamento = crearDepartamento();
				int numeroDepartamento = departamento.getNumeroDepartamento();
				if (departamentos.containsKey(numeroDepartamento)) {
					System.err.println("Ya existe un departamento con número " + numeroDepartamento);
				} else {
					departamentos.put(numeroDepartamento, departamento);
					//System.out.println(departamentos);
				}
				break;
			
			case 3:
				departamento = crearDepartamento();
				numeroDepartamento = departamento.getNumeroDepartamento();
				if (!departamentos.containsKey(numeroDepartamento)) {
					System.err.println("No existe un departamento con número " + numeroDepartamento);
				} else {
					departamentos.replace(numeroDepartamento, departamento);
					//System.out.println(departamentos);
				}
				break;
				
			case 4:
				pedirDato("número de departamento");
				String numero = leerDato();
				numeroDepartamento = 0;
				try {
					numeroDepartamento = Integer.parseInt(numero);
				} catch (NumberFormatException e) {
					System.err.println("El número de departamento tiene que ser un número entero");
					break;
				}
				if (!departamentos.containsKey(numeroDepartamento)) {
					System.err.println("No existe un departamento con número " + numeroDepartamento);
				} else {
					departamentos.remove(numeroDepartamento);
					//System.out.println(departamentos);
				}
				break;
				
			case 5:
				pedirRuta();
				ruta = leerRuta();
				escribirFichero(ruta);
				break;

			default:
				System.err.println("Opción no válida");
				break;
			}
		}
	}

	private static void escribirFichero(String ruta) {
		try {
			FileWriter fw = new FileWriter(ruta);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			String linea = "num_depto;nombre;nombre_corto;planta;cif_director;correo_e";
			pw.println(linea);
			for (Departamento departamento : departamentos.values()) {
				linea = "";
				linea += departamento.getNumeroDepartamento() + ";";
				linea += departamento.getNombre() + ";";
				linea += departamento.getNombreCorto() + ";";
				linea += departamento.getPlanta() + ";";
				linea += departamento.getCifDirector() + ";";
				linea += departamento.getCorreoElectronico();
				pw.println(linea);
			}
			pw.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.err.println("Error al escribir el fichero");
		}
	}

	private static Departamento crearDepartamento() {
		Departamento departamento = null;
		pedirDato("número de departamento");
		String numero = leerDato();
		int numeroDepartamento = 0;
		try {
			numeroDepartamento = Integer.parseInt(numero);
		} catch (NumberFormatException e) {
			System.err.println("El número de departamento tiene que ser un número entero");
			return null;
		}
		pedirDato("nombre");
		String nombre = leerDato();
		pedirDato("nombre corto");
		String nombreCorto = leerDato();
		pedirDato("planta");
		String plantaTexto = leerDato();
		int planta = 0;
		try {
			planta = Integer.parseInt(plantaTexto);
		} catch (NumberFormatException e) {
			System.err.println("La planta tiene que ser un número entero");
			return null;
		}
		pedirDato("CIF Director");
		String cifDirector = leerDato();
		pedirDato("correo electrónico");
		String correoElectronico = leerDato();
		departamento = new Departamento(numeroDepartamento, nombre, nombreCorto, 
				planta, cifDirector, correoElectronico);
		return departamento;
	}

	private static String leerDato() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextLine();
	}

	private static void pedirDato(String dato) {
		System.out.print("Escriba " + dato + ": ");
	}

	private static void leerFichero(String ruta) {
		File fichero = new File(ruta);
		if (fichero.isFile()) {
			try {
				Scanner escaner = new Scanner(fichero);
				if (escaner.hasNextLine()) {
					escaner.nextLine();
				}
				while (escaner.hasNextLine()) {
					String linea = escaner.nextLine();
					String[] partes = linea.split(";");
					int numeroDepartamento = 0;
					try {
						numeroDepartamento = Integer.parseInt(partes[0]);
					} catch (NumberFormatException e) {
						System.err.println("El número de departamento tiene que ser un número entero");
						return;
					}
					String nombre = partes[1];
					String nombreCorto = partes[2];
					int planta = 0;
					try {
						planta = Integer.parseInt(partes[3]);
					} catch (NumberFormatException e) {
						System.err.println("La planta tiene que ser un número entero");
						return;
					}
					String cifDirector = partes[4];
					String correoElectronico = partes[5];
					Departamento departamento = new Departamento(numeroDepartamento, nombre, 
							nombreCorto, planta, cifDirector, correoElectronico);
					departamentos.put(numeroDepartamento, departamento);
				}
			} catch (FileNotFoundException e) {
				System.err.println("La ruta " + ruta + " no existe");
			} 
		} else {
			System.err.println("La ruta " + ruta + " no es un fichero");
		}
	}

	private static String leerRuta() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextLine();
	}

	private static void pedirRuta() {
		System.out.print("Escriba la ruta del fichero: ");
	}

	private static void pedirOpcion() {
		System.out.print("Escoja una opción: ");
	}

	private static int leerOpcion() {
		Scanner escaner = new Scanner(System.in);
		int opcion = -1;
		try {
			opcion = escaner.nextInt();
		} catch (InputMismatchException e) {
		}
		return opcion;
	}

	private static void escribirMenu() {
		System.out.println("\nGESTOR DEPARTAMENTOS\n" 
				+ "1. Importar departamentos\n" 
				+ "2. Añadir departamento\n"
				+ "3. Modificar departamento\n" 
				+ "4. Eliminar departamento\n" 
				+ "5. Exportar departamentos\n"
				+ "0. Salir");
	}

}
