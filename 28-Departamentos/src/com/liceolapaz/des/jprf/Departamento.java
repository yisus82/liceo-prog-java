package com.liceolapaz.des.jprf;

public class Departamento {
	private int numeroDepartamento;
	private String nombre;
	private String nombreCorto;
	private int planta;
	private String cifDirector;
	private String correoElectronico;
	
	public Departamento(int numeroDepartamento, String nombre, String nombreCorto, int planta, String cifDirector,
			String correoElectronico) {
		super();
		this.numeroDepartamento = numeroDepartamento;
		this.nombre = nombre;
		this.nombreCorto = nombreCorto;
		this.planta = planta;
		this.cifDirector = cifDirector;
		this.correoElectronico = correoElectronico;
	}

	public int getNumeroDepartamento() {
		return numeroDepartamento;
	}

	public void setNumeroDepartamento(int numeroDepartamento) {
		this.numeroDepartamento = numeroDepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public String getCifDirector() {
		return cifDirector;
	}

	public void setCifDirector(String cifDirector) {
		this.cifDirector = cifDirector;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	@Override
	public String toString() {
		return "Departamento [numeroDepartamento=" + numeroDepartamento + ", nombre=" + nombre + ", nombreCorto="
				+ nombreCorto + ", planta=" + planta + ", cifDirector=" + cifDirector + ", correoElectronico="
				+ correoElectronico + "]";
	}
	
	
}
