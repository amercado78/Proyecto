package com.mx.jmi.adminJMI.interfaces;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileManagerService {
	String saveProductImageFile(MultipartFile file) throws IOException;
}
