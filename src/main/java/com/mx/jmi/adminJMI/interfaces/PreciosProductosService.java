package com.mx.jmi.adminJMI.interfaces;

import com.mx.jmi.adminJMI.entity.PreciosProductos;
import com.mx.jmi.adminJMI.entity.Productos;

public interface PreciosProductosService {
	public PreciosProductos findByProductos(Productos producto);
}
