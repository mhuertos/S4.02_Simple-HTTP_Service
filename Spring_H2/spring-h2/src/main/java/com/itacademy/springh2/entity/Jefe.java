package com.itacademy.springh2.entity;

import javax.persistence.Entity;

@Entity
public class Jefe extends Empleado{

	private String nombre;
	private final String puesto = "jefe";
	private final double salario = 60000.57;
	
	public Jefe() {}
	
	public Jefe(String nombre) {
		this.nombre = nombre;
	}

	public String getPuesto() {
		return puesto;
	}

	public double getSalario() {
		return salario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
