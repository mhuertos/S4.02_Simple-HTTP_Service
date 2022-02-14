package com.itacademy.springh2.entity;

import javax.persistence.Entity;

@Entity
public class Secretario extends Empleado{
	
	private String nombre;
	private final String puesto = "secretario";
	private final double salario = 30000.80;
	
	public Secretario() {}
	
	public Secretario(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPuesto() {
		return puesto;
	}

	public double getSalario() {
		return salario;
	}
}
