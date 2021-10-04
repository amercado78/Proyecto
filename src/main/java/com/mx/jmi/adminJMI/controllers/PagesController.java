package com.mx.jmi.adminJMI.controllers;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {
	
	Logger logger = LoggerFactory.getLogger(PagesController.class);
	
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
		model.addAttribute("seccion", "categories");
		
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
