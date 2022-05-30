package com.liceolapaz.des.jprf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Principal {
	private static HashMap<Integer, Usuario> usuarios = new HashMap<>();
	
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
				//System.out.println(usuarios);
				break;
				
			case 2:
				Usuario usuario = crearUsuario();
				int id = usuario.getId();
				if (usuarios.containsKey(id)) {
					System.err.println("Ya existe un usuario con id " + id);
				} else {
					usuarios.put(id, usuario);
					//System.out.println(usuarios);
				}
				break;
			
			case 3:
				usuario = crearUsuario();
				id = usuario.getId();
				if (!usuarios.containsKey(id)) {
					System.err.println("No existe un usuario con id " + id);
				} else {
					usuarios.replace(id, usuario);
					//System.out.println(usuarios);
				}
				break;
				
			case 4:
				pedirDato("id");
				String numero = leerDato();
				id = 0;
				try {
					id = Integer.parseInt(numero);
				} catch (NumberFormatException e) {
					System.err.println("El id tiene que ser un número entero");
					break;
				}
				if (!usuarios.containsKey(id)) {
					System.err.println("No existe un usuarios con id " + id);
				} else {
					usuarios.remove(id);
					//System.out.println(usuarios);
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
	
	private static Usuario crearUsuario() {
		Usuario usuario = null;
		pedirDato("id");
		String numero = leerDato();
		int id = 0;
		try {
			id = Integer.parseInt(numero);
		} catch (NumberFormatException e) {
			System.err.println("El id tiene que ser un número entero");
			return null;
		}
		pedirDato("email");
		String email = leerDato();
		pedirDato("nombre");
		String firstName = leerDato();
		pedirDato("apellidos");
		String lastName = leerDato();
		pedirDato("avatar");
		String avatarURL = leerDato();
		URL avatar;
		try {
			avatar = new URL(avatarURL);
		} catch (MalformedURLException e) {
			System.err.println("El avatar tiene que ser una URL");
			return null;
		}
		usuario = new Usuario(id, email, firstName, lastName, avatar);
		return usuario;
	}

	private static void escribirFichero(String ruta) {
		try {
			FileWriter fw = new FileWriter(ruta);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			String linea = "[";
			pw.println(linea);
			Usuario[] usuariosArray = new Usuario[usuarios.values().size()];
			usuariosArray = usuarios.values().toArray(usuariosArray);
			for (int i = 0; i < usuariosArray.length; i++) {
				linea = "  {";
				pw.println(linea);
				Usuario usuario = usuariosArray[i];
				linea = "    \"id\": " + usuario.getId() + ",";
				pw.println(linea);
				linea = "    \"email\": \"" + usuario.getEmail() + "\",";
				pw.println(linea);
				linea = "    \"first_name\": \"" + usuario.getFirstName() + "\",";
				pw.println(linea);
				linea = "    \"last_name\": \"" + usuario.getLastName() + "\",";
				pw.println(linea);
				linea = "    \"avatar\": \"" + usuario.getAvatar() + "\"";
				pw.println(linea);
				if (i == usuariosArray.length - 1) {
					linea = "  }";
				} else {
					linea = "  },";
				}
				pw.println(linea);
			}
			linea = "]";
			pw.print(linea);
			pw.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.err.println("Error al escribir el fichero");
		}
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
					if (linea.equals("]")) {
						break;
					}
					if (linea.equals("  {")) {
						linea = escaner.nextLine();
						String[] partes = linea.split(": ");
						int id = 0;
						try {
							id = Integer.parseInt(partes[1].substring(0, partes[1].length() - 1));
						} catch (NumberFormatException e) {
							System.err.println("El id tiene que ser un número entero");
							return;
						}
						linea = escaner.nextLine();
						partes = linea.split(": ");
						String email = partes[1].substring(1, partes[1].length() - 2);
						linea = escaner.nextLine();
						partes = linea.split(": ");
						String firstName = partes[1].substring(1, partes[1].length() - 2);
						linea = escaner.nextLine();
						partes = linea.split(": ");
						String lastName = partes[1].substring(1, partes[1].length() - 2);
						linea = escaner.nextLine();
						partes = linea.split(": ");
						String avatarURL = partes[1].substring(1, partes[1].length() - 1);
						URL avatar;
						try {
							avatar = new URL(avatarURL);
						} catch (MalformedURLException e) {
							System.err.println("El avatar tiene que ser una URL");
							return;
						}
						Usuario usuario = new Usuario(id, email, firstName, lastName, avatar);
						usuarios.put(id, usuario);
						escaner.nextLine();
					}
				}
			} catch (FileNotFoundException e) {
				System.err.println("La ruta " + ruta + " no existe");
			} 
		} else {
			System.err.println("La ruta " + ruta + " no es un fichero");
		}
	}

	private static String leerDato() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextLine();
	}

	private static void pedirDato(String dato) {
		System.out.print("Escriba " + dato + ": ");
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
		int opcion = -1;
		try {
			opcion = escaner.nextInt();
		} catch (InputMismatchException e) {
		}
		return opcion;
	}

	private static void pedirOpcion() {
		System.out.print("Escoja una opción: ");
	}

	private static void escribirMenu() {
		System.out.println("\nGESTOR USUARIOS\n" 
				+ "1. Importar usuarios\n" 
				+ "2. Añadir usuario\n"
				+ "3. Modificar usuario\n" 
				+ "4. Eliminar usuario\n" 
				+ "5. Exportar usuarios\n"
				+ "0. Salir");
	}

}
