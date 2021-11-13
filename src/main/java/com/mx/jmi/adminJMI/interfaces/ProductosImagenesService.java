package com.mx.jmi.adminJMI.interfaces;

import java.util.List;

import com.mx.jmi.adminJMI.entity.Productos;
import com.mx.jmi.adminJMI.entity.ProductosImagenes;

public interface ProductosImagenesService {
	List<ProductosImagenes> findByProductos(Productos producto);
}
