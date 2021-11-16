package com.mx.jmi.adminJMI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.jmi.adminJMI.entity.PreciosProductos;
import com.mx.jmi.adminJMI.entity.Productos;

public interface PreciosProductosRepository extends JpaRepository<PreciosProductos, Integer> {
	@Override
	public List<PreciosProductos> findAll();
	public PreciosProductos findByProductos(Productos producto);

}
