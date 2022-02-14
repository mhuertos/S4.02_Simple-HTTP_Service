package com.itacademy.springh2.empleadoRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itacademy.springh2.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	
	List<Empleado> findAllByPuesto(String puesto);

}
