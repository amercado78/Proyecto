package com.mx.jmi.adminJMI.controllers;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mx.jmi.adminJMI.dtos.CategoriaDto;
import com.mx.jmi.adminJMI.dtos.SubcategoriaDto;
import com.mx.jmi.adminJMI.entity.Categorias;
import com.mx.jmi.adminJMI.entity.Subcategorias;
import com.mx.jmi.adminJMI.interfaces.CategoriasService;
import com.mx.jmi.adminJMI.interfaces.SubcategoriasService;
import com.mx.jmi.adminJMI.mappers.CategoriasMapper;
import com.mx.jmi.adminJMI.mappers.SubcategoriasMapper;

@Controller
public class PagesController {
	
	Logger logger = LoggerFactory.getLogger(PagesController.class);
	List<Categorias> listaCategorias; 
	List<Subcategorias> listaSubcategorias; 
	
	@Autowired
	private CategoriasService categoriasService;
	@Autowired
	private SubcategoriasService subcategoriasService;
	
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
		model.addAttribute("categoria", new Categorias());
		try {		
			return "paginaCategorias";				
		} catch (Exception e) {	
			logger.info("/categories Exception-error:"+e.getMessage());
			return "error";
		}		
		
	}
	
	@GetMapping("/subcategories")
	public String subcategories(Model model, HttpSession session) {
		logger.info("/subcategories");
		model.addAttribute("seccion", "Subcategorias");
		listaSubcategorias = subcategoriasService.findAll();
		List<SubcategoriaDto> subcategorias = SubcategoriasMapper.mapearListaSubcategoriasEntityASubcategoriaDto(listaSubcategorias);
		model.addAttribute("seccion", "Subcategorias");
		model.addAttribute("subcategorias", subcategorias);
		model.addAttribute("subcategoria", new Subcategorias());
		try {		
			return "paginaSubcategorias";				
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
	
	@PostMapping("/guardarCategoria")
	public String guardarCategoria(@ModelAttribute Categorias categoria, Model model){
		model.addAttribute("categoria", categoria);
		Date date = new Date();  
        Timestamp ts=new Timestamp(date.getTime());   
		categoria.setFa(ts);
		categoria.setFc(ts);
		categoria.setEstatus(1);
		categoriasService.save(categoria);
		return "redirect:/categories";
	}

}
