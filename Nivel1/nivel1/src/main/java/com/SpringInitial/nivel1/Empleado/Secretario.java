package com.SpringInitial.nivel1.Empleado;

import javax.persistence.Entity;


@Entity
public class Secretario extends Empleado{
	
	private String nombre;
	private final String tipo_emp = "Secretario";
	private final double salario = 60750.76;
	
	
	public Secretario(String nombre) {
		this.nombre = nombre;
	}
	
	public Secretario() {
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
		return "Secretario [id=" + super.getId() + ", nombre=" + nombre + ", tipo_emp=" + tipo_emp + ", salario=" + salario + "]";
	}
	
	
	
	
	

}
