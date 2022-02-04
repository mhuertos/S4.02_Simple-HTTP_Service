package com.SpringInitial.nivel1.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

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

	
	@Transactional
	public void uploadImage(Long idEmpleado, MultipartFile imagen) {
		
		Empleado empleado = empleadoRepository.findById(idEmpleado)
				.orElseThrow(() -> new IllegalStateException("El empleado con id "
															+idEmpleado+" no existe."));
		try {
			String imagenNombre = imagen.getOriginalFilename();
			empleado.setImatge(imagenNombre);
		}catch(Exception e) {
			e.getMessage();
		}
		guardarImagenDirectorioImatge(imagen);
	}
	
	
	public void guardarImagenDirectorioImatge(MultipartFile imagen) {
		try {
			Path directorioImagenes = Paths.get("src//main//resources//static//imatges");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			byte[] bytesImagen = imagen.getBytes();
			Path rutaCompleta = Paths.get(rutaAbsoluta+"//"+imagen.getOriginalFilename());
			Files.write(rutaCompleta, bytesImagen);
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	
	public void getImatge(Long idEmpleado, HttpServletResponse response) {
		Empleado empleado = empleadoRepository.getById(idEmpleado);
		
		String imatgeNom = empleado.getImatge();
		
		if(imatgeNom == null) {
			throw new IllegalStateException("El empleado con id "
					+idEmpleado+" no tiene foto.");
		}else {
			response.setContentType(MediaType.IMAGE_JPEG_VALUE);
			Path rutaCompleta = Paths.get("src//main//resources//static//imatges"+"//"+imatgeNom);
			try {
				byte[] imatge = Files.readAllBytes(rutaCompleta);
				StreamUtils.copy(imatge, response.getOutputStream());
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
	}
}
