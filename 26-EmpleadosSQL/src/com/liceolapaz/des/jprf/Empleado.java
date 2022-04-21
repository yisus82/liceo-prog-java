package com.liceolapaz.des.jprf;

import java.util.Date;

public class Empleado {
	private String dni;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Date fechaNacimiento;
	private double salario;
	private int numeroDepartamento;
	private String dniJefe;
	
	public Empleado(String dni, String nombre, String primerApellido, String segundoApellido, Date fechaNacimiento,
			double salario, int numeroDepartamento, String dniJefe) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.fechaNacimiento = fechaNacimiento;
		this.salario = salario;
		this.numeroDepartamento = numeroDepartamento;
		this.dniJefe = dniJefe;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getNumeroDepartamento() {
		return numeroDepartamento;
	}

	public void setNumeroDepartamento(int numeroDepartamento) {
		this.numeroDepartamento = numeroDepartamento;
	}

	public String getDniJefe() {
		return dniJefe;
	}

	public void setDniJefe(String dniJefe) {
		this.dniJefe = dniJefe;
	}

	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", primerApellido=" + primerApellido
				+ ", segundoApellido=" + segundoApellido + ", fechaNacimiento=" + fechaNacimiento + ", salario="
				+ salario + ", numeroDepartamento=" + numeroDepartamento + ", dniJefe=" + dniJefe + "]";
	}
	
	
}
