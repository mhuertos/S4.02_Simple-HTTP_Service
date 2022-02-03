package com.SpringInitial.nivel1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SpringInitial.nivel1.Empleado.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	
	//Probamos
	@Query("SELECT e FROM Empleado e WHERE e.tipo_emp LIKE ?1")
	public List<Empleado> findByTipoEmpleo(String tipoEmpleo);
	
}
