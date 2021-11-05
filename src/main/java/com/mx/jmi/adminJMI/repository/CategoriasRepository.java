package com.mx.jmi.adminJMI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.jmi.adminJMI.entity.Categorias;


public interface CategoriasRepository extends JpaRepository<Categorias, Integer>{
	@Override
	public List<Categorias> findAll();
	
}
