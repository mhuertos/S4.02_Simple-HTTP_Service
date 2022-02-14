package com.itacademy.springh2.entity;

import javax.persistence.Entity;

@Entity
public class Director extends Empleado{
	
	private String nombre;
	private final String puesto = "director";
	private final double salario = 90000.15;
	
	public Director() {}
	
	public Director(String nombre) {
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
