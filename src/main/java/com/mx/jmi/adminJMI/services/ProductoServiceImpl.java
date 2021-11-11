package com.mx.jmi.adminJMI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.jmi.adminJMI.entity.Productos;
import com.mx.jmi.adminJMI.interfaces.ProductoService;
import com.mx.jmi.adminJMI.repository.ProductosRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	ProductosRepository productosRepository;
	
	@Override
	public List<Productos> findAll() {
		return productosRepository.findAll();
	}

	@Override
	public void save(Productos productos) {
		productosRepository.save(productos);	
	}

}
