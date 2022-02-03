package com.SpringInitial.nivel1.Empleado;

import javax.persistence.Entity; 

@Entity
public class Director extends Empleado{
	
	private String nombre;
	private final String tipo_emp = "Director";
	private final double salario = 100000;
	
	
	public Director(String nombre) {
		this.nombre = nombre;
	}
	
	public Director() {
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
		return "Director [id=" + super.getId() + ", nombre=" + nombre + ", tipo_emp=" + tipo_emp + ", salario=" + salario + "]";
	}
	
	
	

}
