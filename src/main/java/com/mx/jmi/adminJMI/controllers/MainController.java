package com.mx.jmi.adminJMI.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {
	
    Logger logger = LoggerFactory.getLogger(MainController.class);
    
    @Value("${version.admin.JMI}")
    private String adminVersion;

    @GetMapping("/version")
	public ResponseEntity<String> main(Model model, HttpSession session) {    	
    	logger.info("/AdminJMI V:" + adminVersion); 
    	
    	return new ResponseEntity<>("AdminJMI V:" + adminVersion, HttpStatus.OK);    	
    }
   

}
