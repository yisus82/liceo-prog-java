package com.liceolapaz.des.jprf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

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
				String contenido = leerFicheroTexto(ruta);
				if (contenido != null) {					
					mostrarContenido(contenido);
				}
				break;
				
			case 2:
				escribirSubmenu();
				pedirOpcion();
				int opcion2 = leerOpcion();
				switch (opcion2) {
				case 1:
					pedirRutaOrigen();
					String rutaOrigenTexto = leerRuta();
					pedirRutaDestino();
					String rutaDestinoTexto = leerRuta();
					copiarFicheroTexto(rutaOrigenTexto, rutaDestinoTexto);
					break;
					
				case 2:
					pedirRutaOrigen();
					String rutaOrigenBinario = leerRuta();
					pedirRutaDestino();
					String rutaDestinoBinario = leerRuta();
					copiarFicheroBinario(rutaOrigenBinario, rutaDestinoBinario);
					break;
					
				case 0:
					continue;

				default:
					System.out.println("Opción no válida");
					break;
				}
				break;
				
			case 3:
				pedirRutaDirectorio();
				String rutaDirectorio = leerRuta();
				listarFicheros(rutaDirectorio);
				break;

			default:
				System.out.println("Opción no válida");
				break;
			}
		}
	}

	private static void listarFicheros(String rutaDirectorio) {
		File directorio = new File(rutaDirectorio);
		if (directorio.isDirectory()) {
			System.out.println();
			String[] nombresFicheros = directorio.list();
			for (int i = 0; i < nombresFicheros.length; i++) {
				File fichero = new File(directorio, nombresFicheros[i]);
				long numeroBytesFichero = fichero.length();
				System.out.println(nombresFicheros[i] + "\t" + String.format("%.2f", (numeroBytesFichero / 1024.0)) + " KB");
			}
		} else {
			System.out.println("La ruta " + rutaDirectorio + " no es un directorio");
		}
	}

	private static void pedirRutaDirectorio() {
		System.out.print("Escriba la ruta del directorio: ");
	}

	private static void copiarFicheroBinario(String rutaOrigenBinario, String rutaDestinoBinario) {
		byte[] contenido = leerFicheroBinario(rutaOrigenBinario);
		if (contenido != null) {
			escribirFicheroBinario(contenido, rutaDestinoBinario);
		}
	}

	private static void escribirFicheroBinario(byte[] contenido, String rutaDestinoBinario) {
		try {
			FileOutputStream fos = new FileOutputStream(rutaDestinoBinario);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			bos.write(contenido);
			bos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error al escribir el fichero binario");
		} catch (IOException e) {
			System.out.println("Error al escribir el fichero binario");
		}
	}

	private static byte[] leerFicheroBinario(String rutaOrigenBinario) {
		byte[] contenido = null;
		File fichero = new File(rutaOrigenBinario);
		if (fichero.isFile()) {
			try {
				long numeroBytesFichero = fichero.length();
				contenido = new byte[(int) numeroBytesFichero];
				int posicion = 0;
				FileInputStream fis = new FileInputStream(fichero);
				BufferedInputStream bis = new BufferedInputStream(fis);
				byte[] buffer = new byte[1024];
				int bytesLeidos = 0;
				bytesLeidos = bis.read(buffer);
				while (bytesLeidos != -1) {
					for (int i = 0; i < bytesLeidos; i++) {
						contenido[posicion] = buffer[i];
						posicion++;
					}
					bytesLeidos = bis.read(buffer);
				}
				bis.close();
				fis.close();
			} catch (FileNotFoundException e) {
				System.out.println("La ruta " + rutaOrigenBinario + " no es un fichero");
				return null;
			} catch (IOException e) {
				System.out.println("Error al leer el fichero binario");
				return null;
			}
		} else {
			System.out.println("La ruta " + rutaOrigenBinario + " no es un fichero");
			return null;
		}
		return contenido;
	}

	private static void copiarFicheroTexto(String rutaOrigenTexto, String rutaDestinoTexto) {
		String contenido = leerFicheroTexto(rutaOrigenTexto);
		if (contenido != null) {
			escribirFicheroTexto(contenido, rutaDestinoTexto);
		}
	}

	private static void escribirFicheroTexto(String contenido, String rutaDestinoTexto) {
		try {
			FileWriter fw = new FileWriter(rutaDestinoTexto);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			pw.print(contenido);
			pw.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Error al escribir el fichero de destino");
		}
	}

	private static void pedirRutaDestino() {
		System.out.print("Escriba la ruta del fichero de destino: ");
	}

	private static void pedirRutaOrigen() {
		System.out.print("Escriba la ruta del fichero de origen: ");
	}

	private static void escribirSubmenu() {
		System.out.println("\nTipo de fichero a copiar\n"
				+ "1. Fichero de texto\n"
				+ "2. Fichero binario\n"
				+ "0. Cancelar");
	}

	private static void mostrarContenido(String contenido) {
		System.out.print(contenido);
	}

	private static String leerFicheroTexto(String ruta) {
		String contenido = "";
		File fichero = new File(ruta);
		if (fichero.isFile()) {
			try {
				FileReader fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr);
				String linea = br.readLine();
				while (linea != null) {
					contenido += linea + "\n";
					linea = br.readLine();
				}
				br.close();
				fr.close();
				return contenido;
			} catch (FileNotFoundException e) {
				System.out.println("La ruta " + ruta + " no es un fichero");
				return null;
			} catch (IOException e) {
				System.out.println("Error el leer el archivo");
				return null;
			}
		} else {
			System.out.println("La ruta " + ruta + " no es un fichero");
			return null;
		}
	}

	private static String leerRuta() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextLine();
	}

	private static void pedirRuta() {
		System.out.print("Escriba la ruta del fichero: ");
	}

	private static int leerOpcion() {
		Scanner escaner = new Scanner(System.in);
		try {		
			return escaner.nextInt();
		} catch (InputMismatchException e) {
			return -1;
		}
	}

	private static void pedirOpcion() {
		System.out.print("Escoja una opción: ");
	}

	private static void escribirMenu() {
		System.out.println("\nFICHEROS\n"
				+ "1. Leer fichero de texto\n"
				+ "2. Copiar fichero\n"
				+ "3. Listar archivos de directorio\n"
				+ "0. Salir");
	}

}
