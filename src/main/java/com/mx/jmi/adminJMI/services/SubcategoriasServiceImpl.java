package com.mx.jmi.adminJMI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.jmi.adminJMI.entity.Subcategorias;
import com.mx.jmi.adminJMI.interfaces.SubcategoriasService;
import com.mx.jmi.adminJMI.repository.SubcategoriasRepository;
@Service
public class SubcategoriasServiceImpl implements SubcategoriasService {
	
	@Autowired
	SubcategoriasRepository subcategoriasRepository;

	@Override
	public List<Subcategorias> findAll() {
		return subcategoriasRepository.findAll();
	}

	@Override
	public void save(Subcategorias subcategorias) {
		subcategoriasRepository.save(subcategorias);	
	}

}
