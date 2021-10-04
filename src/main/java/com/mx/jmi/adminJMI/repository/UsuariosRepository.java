package com.mx.jmi.adminJMI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mx.jmi.adminJMI.entity.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer>{
	
	public Optional<Usuarios> findByCorreo(String correo);
	
}
