package com.mx.jmi.adminJMI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mx.jmi.adminJMI.dtos.ProductoActualizarDto;
import com.mx.jmi.adminJMI.dtos.ProductosImagenesDto;
import com.mx.jmi.adminJMI.entity.Categorias;
import com.mx.jmi.adminJMI.entity.PreciosProductos;
import com.mx.jmi.adminJMI.entity.Productos;
import com.mx.jmi.adminJMI.entity.ProductosImagenes;
import com.mx.jmi.adminJMI.entity.Subcategorias;
import com.mx.jmi.adminJMI.interfaces.CategoriasService;
import com.mx.jmi.adminJMI.interfaces.CustomProductoService;
import com.mx.jmi.adminJMI.interfaces.PreciosProductosService;
import com.mx.jmi.adminJMI.interfaces.ProductoService;
import com.mx.jmi.adminJMI.interfaces.ProductosImagenesService;
import com.mx.jmi.adminJMI.interfaces.SubcategoriasService;
import com.mx.jmi.adminJMI.mappers.ProductosImagenesMapper;
import com.mx.jmi.adminJMI.mappers.ProductosMapper;

@RestController
public class ProductoRestController {
	
	List<ProductosImagenes> productosImageneslist;
	List<ProductosImagenesDto> productosImagenesDtoList;
	
	@Autowired
	private ProductoService productosService;
	@Autowired
	CustomProductoService customProductoService;
	@Autowired
	private CategoriasService categoriasService;
	@Autowired
	private SubcategoriasService subcategoriasService;
	@Autowired 
	PreciosProductosService preciosProductosService;
	
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
	
	@GetMapping("/getProductByUpdate/{id}")
	public ProductoActualizarDto getProductByUpdate(@PathVariable Integer id) {
		Productos producto = productosService.findByPkproducto(id);
		List<Subcategorias> subcategorias = subcategoriasService.findAll();
		List<Categorias> categorias = categoriasService.findAll();
		PreciosProductos precioProducto = preciosProductosService.findByProductos(producto);
		return ProductosMapper.mapearAproductoActualizarDto(producto, subcategorias, categorias, precioProducto);
	} 

}
