package com.SpringInitial.nivel1.Empleado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity(name = "Empleado")
@Table
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idEmpleado;
	
	@Column(name="nombre",
			nullable = false)
	private String nombre;
	
	@Column(name="salario",
			nullable=false)
	private double salario;
	
	@Column(name="tipus_feina",
			nullable=false)
	private String tipo_emp;
	
	@Column(name= "imatge",
			length=45,
			nullable=true)
	private String imatge;
	
	public Empleado() {
	}
	
	
	public Empleado(long id, String nombre, String tipo_emp) {
		this.idEmpleado = id;
		this.nombre = nombre;
		this.tipo_emp= tipo_emp;
	}

	public long getId() {
		return idEmpleado;
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

	public void setTipo_emp(String tipo_emp) {
		this.tipo_emp = tipo_emp;
	}

	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getImatge() {
		return imatge;
	}

	public void setImatge(String imatge) {
		this.imatge = imatge;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + idEmpleado + ", nombre=" + nombre + ", salario=" + salario + ", tipo_emp=" + tipo_emp + "]";
	}
}
