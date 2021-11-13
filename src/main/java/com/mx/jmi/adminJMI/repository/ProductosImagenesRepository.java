package com.mx.jmi.adminJMI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.jmi.adminJMI.entity.Productos;
import com.mx.jmi.adminJMI.entity.ProductosImagenes;


@Repository
public interface ProductosImagenesRepository extends JpaRepository<ProductosImagenes , Integer>{
	
	public List<ProductosImagenes> findByProductos(Productos producto);
}
