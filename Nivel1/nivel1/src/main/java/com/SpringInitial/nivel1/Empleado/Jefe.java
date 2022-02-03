package com.SpringInitial.nivel1.Empleado;

import javax.persistence.Entity;

@Entity
public class Jefe extends Empleado{

	private String nombre;
	private String tipo_emp = "Jefe";
	private double salario = 90500.69;
	
	
	public Jefe(String nombre) {
		this.nombre = nombre;
	}
	
	public Jefe() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo_emp() {
		return tipo_emp;
	}

	public double getSalario() {
		return salario;
	}

	@Override
	public String toString() {
		return "Jefe [id= "+super.getId()+"nombre=" + nombre + ", tipo_emp=" + tipo_emp + ", salario=" + salario + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
