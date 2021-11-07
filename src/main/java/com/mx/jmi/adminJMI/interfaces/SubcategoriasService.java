package com.mx.jmi.adminJMI.interfaces;

import java.util.List;

import com.mx.jmi.adminJMI.entity.Subcategorias;

public interface SubcategoriasService {
	
	List <Subcategorias> findAll();
	void save(Subcategorias subcategorias);
}
