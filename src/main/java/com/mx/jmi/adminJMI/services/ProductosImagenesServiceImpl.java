package com.mx.jmi.adminJMI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.jmi.adminJMI.entity.Productos;
import com.mx.jmi.adminJMI.entity.ProductosImagenes;
import com.mx.jmi.adminJMI.interfaces.ProductosImagenesService;
import com.mx.jmi.adminJMI.repository.ProductosImagenesRepository;

@Service
public class ProductosImagenesServiceImpl implements ProductosImagenesService {

	@Autowired
	ProductosImagenesRepository productosImagenesRepository;
	
	@Override
	public List<ProductosImagenes> findByProductos(Productos producto) {
		return productosImagenesRepository.findByProductos(producto);
	}

}
