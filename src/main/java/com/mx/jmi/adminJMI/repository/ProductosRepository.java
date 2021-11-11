package com.mx.jmi.adminJMI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.jmi.adminJMI.entity.Productos;
import com.mx.jmi.adminJMI.interfaces.ProductoRepositoryCustom;

@Repository
public interface ProductosRepository extends JpaRepository<Productos , Integer>{
	@Override
	public List<Productos> findAll();
}
