package com.liceolapaz.des.jprf;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    private static HashMap<String, Empleado> empleados = new HashMap<>();

    public static void main(String[] args) {
        do {
           escribirMenu();
           int opcion;
           try {
               opcion = leerOpcion();
           } catch (InputMismatchException e) {
               System.out.println("La opción tiene que ser un número entero");
               continue;
           }
           switch (opcion) {
               case 0:
                   System.exit(0);
                   break;
               case 1:
                   importarEmpleados();
                   break;
               case 2:
                   agregarEmpleado();
                   break;
               case 3:
                   modificarEmpleado();
                   break;
               case 4:
                   eliminarEmpleado();
                   break;
               case 5:
                   exportarEmpleados();
                   break;
               default:
                   System.out.println("Opción no válida");
                   break;
           }
        } while (true);
    }

    private static void exportarEmpleados() {
        System.out.print("Escriba la ruta completa del fichero a exportar: ");
        String ruta = leerTexto();
        try {
            FileWriter fw = new FileWriter(ruta);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            LocalDateTime fechaActual = LocalDateTime.now();
            String linea;
            linea = "Fecha: " + fechaActual.getDayOfMonth()
                    + "/" + fechaActual.getMonthValue()
                    + "/" + fechaActual.getYear();
            pw.println(linea);
            linea = "Hora: " + fechaActual.getHour()
                    + ":" + fechaActual.getMinute()
                    + ":" + fechaActual.getSecond();
            pw.println(linea);
            linea = "Número de empleados: " + empleados.size();
            pw.println(linea);
            int contador = 1;
            for (Empleado empleado : empleados.values()) {
                linea = "===============";
                pw.println(linea);
                linea = "Empleado " + contador;
                pw.println(linea);
                linea = "===============";
                pw.println(linea);
                linea = empleado.toString();
                pw.println(linea);
                contador++;
            }
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el fichero");
        }
    }

    private static void eliminarEmpleado() {
        System.out.print("Escriba el dni del empleado: ");
        String dni = leerTexto();
        if (!comprobarDni(dni)) {
            return;
        }
        if (!empleados.containsKey(dni)) {
            System.out.println("El empleado no existe");
            return;
        }
        empleados.remove(dni);
    }

    private static void modificarEmpleado() {
        System.out.print("Escriba el dni del empleado: ");
        String dni = leerTexto();
        if (!comprobarDni(dni)) {
            return;
        }
        if (!empleados.containsKey(dni)) {
            System.out.println("El empleado no existe");
            return;
        }
        System.out.print("Escriba el nombre: ");
        String nombre = leerTexto();
        System.out.print("Escriba el primer apellido: ");
        String apellido1 = leerTexto();
        System.out.print("Escriba el segundo apellido: ");
        String apellido2 = leerTexto();
        if (apellido2.isEmpty()) {
            apellido2 = null;
        }
        System.out.print("Escriba la fecha de nacimiento (aaaa/mm/dd): ");
        String fechaTexto = leerTexto();
        Date fechaNacimiento = comprobarFecha(fechaTexto);
        if (fechaNacimiento == null) {
            return;
        }
        System.out.print("Escriba el salario: ");
        String salarioTexto = leerTexto();
        double salario;
        try {
            salario = Double.parseDouble(salarioTexto);
        } catch (NumberFormatException e) {
            System.out.println("Formato de salario incorrecto");
            return;
        }
        System.out.print("Escriba el departamento: ");
        String departamentoTexto = leerTexto();
        int departamento;
        try {
            departamento = Integer.parseInt(departamentoTexto);
        } catch (NumberFormatException e) {
            System.out.println("Formato de departamento incorrecto");
            return;
        }
        System.out.print("Escriba el dni del jefe: ");
        String dniJefe = leerTexto();
        if (dniJefe.isEmpty()) {
            dniJefe = null;
        } else {
            if (!comprobarDni(dniJefe)) {
                System.out.println("Formato de dni incorrecto");
                return;
            }
        }
        Empleado empleado = new Empleado(dni, nombre, apellido1, apellido2, fechaNacimiento, salario, departamento, dniJefe);
        empleados.replace(dni, empleado);
    }

    private static void agregarEmpleado() {
        System.out.print("Escriba el dni del empleado: ");
        String dni = leerTexto();
        if (!comprobarDni(dni)) {
            System.out.println("Formato de dni incorrecto");
            return;
        }
        if (empleados.containsKey(dni)) {
            System.out.println("El empleado ya existe");
            return;
        }
        System.out.print("Escriba el nombre: ");
        String nombre = leerTexto();
        System.out.print("Escriba el primer apellido: ");
        String apellido1 = leerTexto();
        System.out.print("Escriba el segundo apellido: ");
        String apellido2 = leerTexto();
        if (apellido2.isEmpty()) {
            apellido2 = null;
        }
        System.out.print("Escriba la fecha de nacimiento (aaaa/mm/dd): ");
        String fechaTexto = leerTexto();
        Date fechaNacimiento = comprobarFecha(fechaTexto);
        if (fechaNacimiento == null) {
            return;
        }
        System.out.print("Escriba el salario: ");
        String salarioTexto = leerTexto();
        double salario;
        try {
            salario = Double.parseDouble(salarioTexto);
        } catch (NumberFormatException e) {
            System.out.println("Formato de salario incorrecto");
            return;
        }
        System.out.print("Escriba el departamento: ");
        String departamentoTexto = leerTexto();
        int departamento;
        try {
            departamento = Integer.parseInt(departamentoTexto);
        } catch (NumberFormatException e) {
            System.out.println("Formato de departamento incorrecto");
            return;
        }
        System.out.print("Escriba el dni del jefe: ");
        String dniJefe = leerTexto();
        if (dniJefe.isEmpty()) {
            dniJefe = null;
        } else {
            if (!comprobarDni(dniJefe)) {
                System.out.println("Formato de dni incorrecto");
                return;
            }
        }
        Empleado empleado = new Empleado(dni, nombre, apellido1, apellido2, fechaNacimiento, salario, departamento, dniJefe);
        empleados.put(dni, empleado);
    }

    private static void importarEmpleados() {
        System.out.print("Escriba la ruta completa del fichero de empleados: ");
        String ruta = leerTexto();
        File fichero = new File(ruta);
        if (!fichero.isFile()) {
            System.out.println("La ruta " + ruta + " no es un fichero");
            return;
        }
        try {
            Scanner scanner = new Scanner(fichero);
            HashMap<String, Empleado> empleadosFichero = new HashMap<>();
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(", ");
                if (partes.length != 8) {
                    System.out.println("Formato de datos incorrecto");
                    return;
                }
                String dni = partes[0].substring(2, partes[0].length() - 1);
                if (!comprobarDni(dni)) {
                    return;
                }
                String nombre = partes[1].substring(1, partes[1].length() - 1);
                String apellido1 = partes[2].substring(1, partes[2].length() - 1);
                String apellido2;
                if (partes[3].equals("NULL")) {
                    apellido2 = null;
                } else {
                    apellido2 = partes[3].substring(1, partes[3].length() - 1);
                }
                String fechaTexto = partes[4].substring(1, partes[4].length() - 1);
                Date fechaNacimiento = comprobarFecha(fechaTexto);
                if (fechaNacimiento == null) {
                    return;
                }
                String salarioTexto = partes[5].substring(1, partes[5].length() - 1);
                double salario;
                try {
                    salario = Double.parseDouble(salarioTexto);
                } catch (NumberFormatException e) {
                    System.out.println("Formato de salario incorrecto");
                    return;
                }
                String departamentoTexto = partes[6];
                int departamento;
                try {
                    departamento = Integer.parseInt(departamentoTexto);
                } catch (NumberFormatException e) {
                    System.out.println("Formato de departamento incorrecto");
                    return;
                }
                String dniJefe;
                if (partes[7].equals("NULL)")) {
                    dniJefe = null;
                } else {
                    dniJefe = partes[7].substring(1, partes[7].length() - 2);
                    if (!comprobarDni(dniJefe)) {
                        return;
                    }
                }
                Empleado empleado = new Empleado(dni, nombre, apellido1, apellido2, fechaNacimiento, salario, departamento, dniJefe);
                empleadosFichero.put(dni, empleado);
            }
            empleados.putAll(empleadosFichero);
        } catch (FileNotFoundException e) {
            System.out.println("La ruta " + ruta + " no existe");
        }
    }

    private static Date comprobarFecha(String fechaTexto) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
        sdf.setLenient(false);
        try {
            return sdf.parse(fechaTexto);
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto");
            return null;
        }
    }

    private static boolean comprobarDni(String dni) {
        if (dni.length() != 9) {
            System.out.println("Formato de dni incorrecto. Ej: 12345678Z");
            return false;
        }
        String parteNumerica = dni.substring(0, 8);
        try {
            int numero = Integer.parseInt(parteNumerica);
            char letra = dni.charAt(8);
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            char letraCorrecta = letras.charAt(numero % letras.length());
            if (letraCorrecta != letra) {
                System.out.println("Formato de dni incorrecto. Ej: 12345678Z");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Formato de dni incorrecto. Ej: 12345678Z");
            return false;
        }
        return true;
    }

    private static String leerTexto() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    private static int leerOpcion() {
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    private static void escribirMenu() {
        System.out.print("""
                GESTOR EMPLEADOS
                1. Importar empleados
                2. Añadir empleado
                3. Modificar empleado
                4. Eliminar empleado
                5. Exportar empleados
                0. Salir
                Escoja una opción:\s""");
    }
}
