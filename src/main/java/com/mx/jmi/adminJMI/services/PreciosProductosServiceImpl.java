package com.mx.jmi.adminJMI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.jmi.adminJMI.entity.PreciosProductos;
import com.mx.jmi.adminJMI.entity.Productos;
import com.mx.jmi.adminJMI.interfaces.PreciosProductosService;
import com.mx.jmi.adminJMI.repository.PreciosProductosRepository;

@Service
public class PreciosProductosServiceImpl implements PreciosProductosService {

	@Autowired
	PreciosProductosRepository preciosProductosRepository;
	@Override
	public PreciosProductos findByProductos(Productos producto) {
		return preciosProductosRepository.findByProductos(producto);
	}

}
