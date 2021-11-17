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

import com.mx.jmi.adminJMI.dtos.ProductoActualizarDto;
import com.mx.jmi.adminJMI.interfaces.FileManagerService;

@Controller 
public class FileManagerController {
	
	@Autowired
    private FileManagerService fileManagerService;
	
	@PostMapping("updateProduct")
    public ResponseEntity<?> uploadProductImageFile(@ModelAttribute ProductoActualizarDto actualizarProducto, @RequestParam("files") MultipartFile[] files) {
        if (files.length == 0) {
            return new ResponseEntity<Object>("Seleccionar un archivo", HttpStatus.OK);
        }

        try {
        	fileManagerService.saveProductImageFile(files[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Object>("Archivo subido correctamente", HttpStatus.OK);
    }
}
