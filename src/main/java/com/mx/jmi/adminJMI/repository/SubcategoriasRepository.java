package com.mx.jmi.adminJMI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.jmi.adminJMI.entity.Subcategorias;



public interface SubcategoriasRepository extends JpaRepository<Subcategorias, Long>{
	@Override
	public List<Subcategorias> findAll();
}
