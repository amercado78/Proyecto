package com.mx.jmi.adminJMI.interfaces;

import java.util.List;

import com.mx.jmi.adminJMI.entity.Productos;

public interface ProductoService {
	List<Productos> findAll();
	void save(Productos productos);
	public Productos findByPkproducto(int id);
}
