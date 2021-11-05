package com.mx.jmi.adminJMI.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mx.jmi.adminJMI.dtos.CategoriaDto;
import com.mx.jmi.adminJMI.entity.Categorias;
import com.mx.jmi.adminJMI.interfaces.CategoriasService;
import com.mx.jmi.adminJMI.mappers.CategoriasMapper;

@Controller
public class PagesController {
	
	Logger logger = LoggerFactory.getLogger(PagesController.class);
	List <Categorias> listaCategorias; 
	
	@Autowired
	private CategoriasService categoriasService;
	
	@GetMapping({"/","/login"})
	public String login(Model model, HttpSession session) {		
		logger.info("/login");
		model.addAttribute("seccion", "login");
		
		try {		
			return "paginaInicioSesion";				
		} catch (Exception e) {	
			logger.info("/categories Exception-error:"+e.getMessage());
			return "error";
		}		
		
	}
	
	@GetMapping("/categories")
	public String categories(Model model, HttpSession session) {		
		logger.info("/categories");
		listaCategorias = categoriasService.findAll();
		List<CategoriaDto> categorias = CategoriasMapper.mapearListaCategoriasEntityACategoriaDto(listaCategorias);
		model.addAttribute("seccion", "Categorias");
		model.addAttribute("categorias", categorias);
		try {		
			return "paginaCategorias";				
		} catch (Exception e) {	
			logger.info("/categories Exception-error:"+e.getMessage());
			return "error";
		}		
		
	}

	@GetMapping("/products")
	public String products(Model model, HttpSession session) {		
		logger.info("/products");
		model.addAttribute("seccion", "products");
		
		try {		
			return "paginaProductos";				
		} catch (Exception e) {	
			logger.info("/categories Exception-error:"+e.getMessage());
			return "error";
		}		
		
	}

}
