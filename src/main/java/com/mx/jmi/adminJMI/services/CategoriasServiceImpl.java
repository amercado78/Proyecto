package com.mx.jmi.adminJMI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.jmi.adminJMI.entity.Categorias;
import com.mx.jmi.adminJMI.interfaces.CategoriasService;
import com.mx.jmi.adminJMI.repository.CategoriasRepository;

@Service
public class CategoriasServiceImpl implements CategoriasService{
	
	@Autowired
	CategoriasRepository categoriasRepository;

	@Override
	public List<Categorias> findAll() {
		return categoriasRepository.findAll(); 
	}

	@Override
	public void save(Categorias categorias) {
		categoriasRepository.save(categorias);
		
	}
	
	
}
