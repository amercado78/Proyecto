package com.mx.jmi.adminJMI.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mx.jmi.adminJMI.dtos.ActualizarProductoDto;
import com.mx.jmi.adminJMI.interfaces.FileManagerService;

@Controller 
public class FileManagerController {
	
	@Autowired
    private FileManagerService fileManagerService;
	
	@PostMapping("uploadProductImage")
    public ResponseEntity<?> uploadProductImageFile(@ModelAttribute ActualizarProductoDto actualizarProducto, @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<Object>("Seleccionar un archivo", HttpStatus.OK);
        }

        try {
        	fileManagerService.saveProductImageFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Object>("Archivo subido correctamente", HttpStatus.OK);
    }
}
