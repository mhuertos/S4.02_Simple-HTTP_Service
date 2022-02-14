package com.itacademy.springh2.empleadoController;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.itacademy.springh2.empleadoService.EmpleadoService;
import com.itacademy.springh2.entity.Director;
import com.itacademy.springh2.entity.Empleado;
import com.itacademy.springh2.entity.Jefe;
import com.itacademy.springh2.entity.Secretario;

@RestController
public class Controller {
	
	@Autowired
	EmpleadoService empleadoService;
	
	public Controller(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}
	
	@GetMapping("/")
	public String getSaludo() {
		return "Hola, bienvenido al sistema gestor de empleados.";
	}
	
	@GetMapping("/listaEmpleados")
	public List<Empleado> getEmpleados(@RequestParam(required=false) String puesto) {
		return empleadoService.listarEmpleados(puesto);
	}
	
	@GetMapping("/verFoto/{idEmpleado}")
	public void getImagen(
			@PathVariable("idEmpleado") Long id,
			HttpServletResponse response) {
		empleadoService.getImatge(id, response);
		
	}
	
	@PostMapping("/añadirDirector")
	public void añadirEmpleado(@RequestBody Director director) {
		empleadoService.añadirEmpleado(director);
	}
	
	@PostMapping("/añadirJefe")
	public void añadirEmpleado(@RequestBody Jefe jefe) {
		empleadoService.añadirEmpleado(jefe);
	}
	
	@PostMapping("/añadirSecretario")
	public void añadirEmpleado(@RequestBody Secretario secretario) {
		empleadoService.añadirEmpleado(secretario);
	}
	
	@PutMapping("/actualizarEmpleado({idEmpleado}")
	public void actualizarEmpleado(
			@PathVariable("idEmpleado") Long idEmpleado,
			@RequestParam(required=false) String nombre,
			@RequestParam(required=false) Double salario) {
		
		empleadoService.actualizaEmpleado(idEmpleado, nombre, salario);
	}
	
	@PutMapping("/subirFoto/{idEmpleado}")
	public void subirFoto(
			@PathVariable("idEmpleado") Long id,
			@RequestBody(required=true) MultipartFile imagen) {
		empleadoService.subirFoto(id, imagen);
	}
	
	@DeleteMapping("/eliminarEmpleado/{idEmpleado}")
	public void eliminarEmpleado(@PathVariable("idEmpleado") Long id) {
		empleadoService.eliminarEmpleado(id);
	}


	
	

}
