package com.mx.jmi.adminJMI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mx.jmi.adminJMI.dtos.ProductosImagenesDto;
import com.mx.jmi.adminJMI.entity.Productos;
import com.mx.jmi.adminJMI.entity.ProductosImagenes;
import com.mx.jmi.adminJMI.interfaces.ProductosImagenesService;
import com.mx.jmi.adminJMI.mappers.ProductosImagenesMapper;

@RestController
public class ProductoRestController {
	
	List<ProductosImagenes> productosImageneslist;
	List<ProductosImagenesDto> productosImagenesDtoList;
	
	@Autowired
	ProductosImagenesService productosImagenesService;
	
	@GetMapping("/imagenesProducto/{id}")
	public List<ProductosImagenesDto> getImagenesProductos(@PathVariable Integer id) {
		Productos productos = new Productos();
		productos.setPkproducto(id);
		productosImageneslist = productosImagenesService.findByProductos(productos);
		productosImagenesDtoList = ProductosImagenesMapper.mapearListaProductosImagenesEntityAProductosImagenesDto(productosImageneslist);
		return productosImagenesDtoList;
	}

}
