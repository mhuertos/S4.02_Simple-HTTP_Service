package com.itacademy.springh2.empleadoService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import com.itacademy.springh2.empleadoRepository.EmpleadoRepository;
import com.itacademy.springh2.entity.Empleado;
import com.itacademy.springh2.entity.Jefe;

@Service
public class EmpleadoService {
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	public EmpleadoService(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository = empleadoRepository;
	}

	public List<Empleado> listarEmpleados() {
		return empleadoRepository.findAll();
	}
	
	public List<Empleado> listarEmpleados(String puesto) {
		if(puesto == null) {
			return empleadoRepository.findAll();
		}else {
			return empleadoRepository.findAllByPuesto(puesto);
		}
	}
	

	public void añadirEmpleado(Empleado empleado) {
		empleadoRepository.save(empleado);
	}

	@Transactional
	public void actualizaEmpleado(Long idEmpleado, String nombre, Double salario) {
		Empleado empleado = empleadoRepository.findById(idEmpleado)
				.orElseThrow(() -> new IllegalStateException("No existe empleado con id"+idEmpleado));
		if(nombre != null) {
			empleado.setNombre(nombre);
		}
		if(salario != null) {
			empleado.setSalario(salario);
		}
	}

	public void eliminarEmpleado(Long id) {
		if(empleadoRepository.existsById(id)) {
			empleadoRepository.deleteById(id);
		}else {
			System.out.println("No existe ningún empleado con id"+id);
		}
		
	}

	@Transactional
	public void subirFoto(Long id, MultipartFile imagen) {
		Empleado empleado = empleadoRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("No existe empleado con id;" + id));
		
		try{
			empleado.setImagen(imagen.getBytes());
			System.out.println("Cargada con éxito");
		}catch(Exception e) {
			System.out.println("No se ha podido cargar la foto"+ e.getMessage());
		}
	}
	
	public void getImatge(Long idEmpleado, HttpServletResponse response) {
		Empleado empleado = empleadoRepository.findById(idEmpleado)
				.orElseThrow(() -> new IllegalStateException("No existe empleado con id" + idEmpleado));
		byte[] imagen = empleado.getImagen();
		
		if(imagen == null) {
			throw new IllegalStateException("El empleado con id "
					+idEmpleado+" no tiene foto.");
		}else {
			response.setContentType(MediaType.IMAGE_JPEG_VALUE);
			try {
				StreamUtils.copy(imagen, response.getOutputStream());
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
	}
}
