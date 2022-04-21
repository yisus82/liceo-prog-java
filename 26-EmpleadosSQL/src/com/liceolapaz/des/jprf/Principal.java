package com.liceolapaz.des.jprf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Principal {
	private static HashMap<String, Empleado> empleados = new HashMap<>();

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
				String ruta = leerString();
				leerEmpleados(ruta);
				break;
				
			case 2:
				// Insertar empleado
				Empleado nuevoEmpleado = crearEmpleado();
				if (nuevoEmpleado != null) {
					String dni = nuevoEmpleado.getDni();
					if (empleados.containsKey(dni)) {
						System.err.println("El empleado con DNI " + dni + " ya existe");
						continue;
					}
					empleados.put(dni, nuevoEmpleado);
					System.out.println(empleados);
				}
				break;
				
			case 3:
				// Eliminar empleado
				pedirDato("dni");
				String dni = leerString();
				if (!empleados.containsKey(dni)) {
					System.err.println("El empleado con DNI " + dni + " no existe");
					continue;
				}
				empleados.remove(dni);
				// System.out.println(empleados);
				break;
				
			case 4:
				// Modificar empleado
				Empleado empleadoModificado = crearEmpleado();
				dni = empleadoModificado.getDni();
				if (!empleados.containsKey(dni)) {
					System.err.println("El empleado con DNI " + dni + " no existe");
					continue;
				}
				empleados.replace(dni, empleadoModificado);
				System.out.println(empleados);
				break;
				
			case 5:
				// Exportar empleados
				pedirRuta();
				ruta = leerString();
				exportarEmpleados(ruta);
				break;

			default:
				System.out.println("Opción no válida");
				break;
			}
		}
	}

	private static void exportarEmpleados(String ruta) {
		try {
			FileWriter fw = new FileWriter(ruta);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			String linea = "";
			LocalDateTime fechaActual = LocalDateTime.now();
			linea += "Fecha: " + fechaActual.getDayOfMonth() + "/" +
					fechaActual.getMonthValue() + "/" + 
					fechaActual.getYear();
			pw.println(linea);
			linea = "";
			linea += "Hora: " + fechaActual.getHour() + ":" + 
					fechaActual.getMinute() + ":" +
					fechaActual.getSecond();
			pw.println(linea);
			linea = "";
			linea += "Número de empleados: " + empleados.size();
			pw.println(linea);
			linea = "";
			int contador = 1;
			for (Empleado empleado : empleados.values()) {
				linea = "===============";
				pw.println(linea);
				linea = "Empleado " + contador;
				pw.println(linea);
				linea = "===============";
				pw.println(linea);
				linea = "DNI: " + empleado.getDni();
				pw.println(linea);
				linea = "Nombre: " + empleado.getNombre();
				pw.println(linea);
				linea = "Primer Apellido: " + empleado.getPrimerApellido();
				pw.println(linea);
				linea = "Segundo Apellido: " + empleado.getSegundoApellido();
				pw.println(linea);
				LocalDateTime fecha = empleado.getFechaNacimiento().toInstant()
					      .atZone(ZoneId.systemDefault())
					      .toLocalDateTime();
				linea = "Fecha de Nacimiento: " + fecha.getYear() + "/" +
					      fecha.getMonthValue() + "/" + fecha.getDayOfMonth();
				pw.println(linea);
				linea = "Salario: " + empleado.getSalario();
				pw.println(linea);
				linea = "Número de Departamento: " + empleado.getNumeroDepartamento();
				pw.println(linea);
				linea = "DNI Jefe: " + empleado.getDniJefe();
				pw.println(linea);
				contador++;
			}
			pw.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.err.println("Error al escribir fichero");
		}
	}

	private static Empleado crearEmpleado() {
		Empleado empleado = null;
		pedirDato("dni");
		String dni = leerString();
		pedirDato("nombre");
		String nombre = leerString();
		pedirDato("primer apellido");
		String primerApellido = leerString();
		pedirDato("segundo apellido");
		String segundoApellido = leerString();
		if (segundoApellido.equals("")) {
			segundoApellido = null;
		}
		pedirDato("fecha de nacimiento (dd/mm/aaaa)");
		String fecha = leerString();
		Date fechaNacimiento = null;
		try {
			fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
		} catch (ParseException e) {
			System.err.println("La fecha tiene que estar en formato dd/mm/aaaa");
			return null;
		}
		pedirDato("salario");
		String salarioString = leerString();
		double salario = 0;
		try {
			salario = Double.parseDouble(salarioString);
		} catch (NumberFormatException e) {
			System.err.println("El salario tiene formato incorrecto");
			return null;
		}
		pedirDato("número de departamento");
		String numero = leerString();
		int numeroDepartamento = 0;
		try {
			numeroDepartamento = Integer.parseInt(numero);
		} catch (NumberFormatException e) {
			System.err.println("El número de departamento tiene formato incorrecto");
			return null;
		}
		pedirDato("DNI del jefe");
		String dniJefe = leerString();
		if (dniJefe.equals("")) {
			dniJefe = null;
		}
		empleado = new Empleado(dni, nombre, primerApellido, 
				segundoApellido, fechaNacimiento, salario, 
				numeroDepartamento, dniJefe);
		return empleado;
	}

	private static void pedirDato(String dato) {
		System.out.print("Escriba el " + dato + ": ");
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
						// System.out.println(dni);
						String nombre = columnas[1].substring(2, columnas[1].length() - 1);
						// System.out.println(nombre);
						String primerApellido = columnas[2].substring(2, columnas[2].length() - 1);
						// System.out.println(primerApellido);
						String segundoApellido = null;
						if (!columnas[3].equals(" NULL")) {
							segundoApellido = columnas[3].substring(2, columnas[3].length() - 1);
						}
						// System.out.println(segundoApellido);
						String fecha = columnas[4].substring(2, columnas[4].length() - 1);
						// System.out.println(fecha);
						Date fechaNacimiento = null;
						try {
							fechaNacimiento = new SimpleDateFormat("yyyy/MM/dd").parse(fecha);
						} catch (ParseException e) {
							System.err.println("La fecha tiene que estar en formato yyyy/MM/dd");
							continue;
						}
						// System.out.println(fechaNacimiento);
						String salarioString = columnas[5].substring(2, columnas[5].length() - 1);
						double salario = 0;
						try {
							salario = Double.parseDouble(salarioString);
						} catch (NumberFormatException e) {
							System.err.println("El salario tiene formato incorrecto");
							continue;
						}
						// System.out.println(salario);
						String numero = columnas[6].substring(1);
						int numeroDepartamento = 0;
						try {
							numeroDepartamento = Integer.parseInt(numero);
						} catch (NumberFormatException e) {
							System.err.println("El número de departamento tiene formato incorrecto");
							continue;
						}
						// System.out.println(numeroDepartamento);
						String dniJefe = null;
						if (!columnas[7].equals(" NULL)")) {
							dniJefe = columnas[7].substring(2, 11);
						}
						// System.out.println(dniJefe);
						Empleado empleado = new Empleado(dni, nombre, primerApellido, 
								segundoApellido, fechaNacimiento, salario, 
								numeroDepartamento, dniJefe);
						// System.out.println(empleado);
						empleados.put(dni, empleado);
					}
					// System.out.println(empleados);
				}
			} catch (FileNotFoundException e) {
				System.err.println("La ruta " + ruta + " no existe");
			}
		} else {
			System.err.println("La ruta " + ruta + " no es un fichero");
		}
	}

	private static String leerString() {
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
		System.out.print("Escoja una opción: ");
	}

}
