package com.SpringInitial.nivel1.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringInitial.nivel1.Empleado.Director;
import com.SpringInitial.nivel1.Empleado.Empleado;
import com.SpringInitial.nivel1.Empleado.Jefe;
import com.SpringInitial.nivel1.Empleado.Secretario;

import com.SpringInitial.nivel1.repository.EmpleadoRepository;

@Service
public class EmpleadoService {
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	public EmpleadoService(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}
	
	public List<Empleado> listarEmpleados(){
		return empleadoRepository.findAll();
	}
	
	
	public List<Empleado> listarEmpleados(Empleado empleado){
		return empleadoRepository.findByTipoEmpleo(empleado.getTipo_emp());
	}
	
	
	public void añadirEmpleado(Empleado empleado) {
		empleadoRepository.save(empleado);
	}
	

	public void deleteEmpleado(Long id) {
		if(empleadoRepository.existsById(id)) {
			empleadoRepository.deleteById(id);
		}else {
			throw new IllegalStateException("No existe ningún empleado con el id: "+id);
		}
		
	}
	
	@Transactional
	public void actualizaEmpleado(Long idEmpleado, String nombre, Double salario) {
		Empleado empleado = empleadoRepository.findById(idEmpleado)
				.orElseThrow(() -> new IllegalStateException("El empleado con id "
															+idEmpleado+" no existe."));
		
		if(nombre != null 
				&& nombre.length() > 0 
				&& !Objects.equals(nombre, empleado.getNombre())) {
			empleado.setNombre(nombre);
		}
		
		if(salario!= null && salario > 0) {
			empleado.setSalario(salario);
		}
	}

}
