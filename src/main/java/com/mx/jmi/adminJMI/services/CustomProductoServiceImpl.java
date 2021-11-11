package com.mx.jmi.adminJMI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.jmi.adminJMI.interfaces.ProductoRepositoryCustom;
import com.mx.jmi.adminJMI.dtos.ProductoDto;
import com.mx.jmi.adminJMI.interfaces.CustomProductoService;
import com.mx.jmi.adminJMI.repository.ProductosRepository;

@Service
public class CustomProductoServiceImpl implements CustomProductoService {

	@Autowired
	ProductoRepositoryCustom productoRepositoryCustom;
	
	@Override
	public List<ProductoDto> getProductos() {
		return productoRepositoryCustom.getProductos();	
	}

}
