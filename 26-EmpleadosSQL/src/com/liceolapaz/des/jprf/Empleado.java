package com.liceolapaz.des.jprf;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Empleado {
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechaNacimiento;
    private double salario;
    private int departamento;
    private String dniJefe;

    public Empleado(String dni, String nombre, String apellido1, String apellido2, Date fechaNacimiento, double salario, int departamento, String dniJefe) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
        this.departamento = departamento;
        this.dniJefe = dniJefe;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
        String fecha = sdf.format(fechaNacimiento);
        return "DNI: " + this.dni + "\n" +
                "Nombre: " + this.nombre + "\n" +
                "Primer Apellido: " + this.apellido1 + "\n" +
                "Segundo Apellido: " + this.apellido2 +"\n" +
                "Fecha de Nacimiento: " + fecha + "\n" +
                "Salario: " + this.salario + "\n" +
                "Número de Departamento: " + this.departamento + "\n" +
                "DNI Jefe: " + this.dniJefe;
    }
}
