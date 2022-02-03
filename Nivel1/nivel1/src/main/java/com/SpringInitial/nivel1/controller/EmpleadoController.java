package com.SpringInitial.nivel1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SpringInitial.nivel1.Empleado.Director;
import com.SpringInitial.nivel1.Empleado.Empleado;
import com.SpringInitial.nivel1.Empleado.Jefe;
import com.SpringInitial.nivel1.Empleado.Secretario;
import com.SpringInitial.nivel1.service.EmpleadoService;


@RestController
@RequestMapping(path="v1/empleados")
public class EmpleadoController {
	
	@Autowired
	EmpleadoService empleadoService;
	
	public EmpleadoController(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}
	
	@GetMapping("/listaEmpleados")
	public List<Empleado> listarEmpleados(){
		return empleadoService.listarEmpleados();
	}
	
	
	@GetMapping("/listaJefes")
	public List<Empleado> listarEmpleados(Jefe jefe){
		return empleadoService.listarEmpleados(jefe);
	}
	
	@GetMapping("/listaSecretarios")
	public List<Empleado> listarEmpleados(Secretario secretario){
		return empleadoService.listarEmpleados(secretario);
	}
	
	@GetMapping("/listaDirectores")
	public List<Empleado> listarEmpleados(Director director){
		return empleadoService.listarEmpleados(director);
	}
	
	@PostMapping("/añadirJefe")
	public void añadirJefe(@RequestParam(required=true)String nombre) {
		Jefe jefe = new Jefe(nombre);
		empleadoService.añadirEmpleado(jefe);
	}
	
	@PostMapping("/añadirSecretario")
	public void añadirSecretario(@RequestParam(required=true)String nombre) {
		Secretario secretario = new Secretario(nombre);
		empleadoService.añadirEmpleado(secretario);
	}
	
	@PostMapping("/añadirDirector")
	public void añadirDirector(@RequestParam(required=true)String nombre) {
		Director director = new Director(nombre);
		empleadoService.añadirEmpleado(director);
	}
	
	
	@DeleteMapping(path= "eliminar/{idEmpleado}")
	public void eliminarEmpleado(@PathVariable("idEmpleado") Long idEmpleado) {
		empleadoService.deleteEmpleado(idEmpleado);
	}
	
	@PutMapping(path= "actualizar/{idEmpleado}")
	public void updateAtributo(
			@PathVariable("idEmpleado") Long idEmpleado,
			@RequestParam(required=false) String nombre,
			@RequestParam(required=false) Double salario) {
		
		empleadoService.actualizaEmpleado(idEmpleado, nombre, salario);
	}
		

}
