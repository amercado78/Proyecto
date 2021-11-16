package com.mx.jmi.adminJMI.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mx.jmi.adminJMI.interfaces.FileManagerService;
import com.mx.jmi.adminJMI.proxies.AmazonS3BucketProxy;

@Service
public class FileManagerServiceImpl implements FileManagerService{

	@Autowired
	private Environment env;
	
	@Override
	public String saveProductImageFile(MultipartFile file) throws IOException {		
		String bucketUrl = "";
        if(!file.isEmpty()){
            byte[] bytes = file.getBytes();
            Path path = Paths.get(env.getProperty("adminjmi.main.resources.files.path") + file.getOriginalFilename());
            Files.write(path,bytes);
            bucketUrl = new AmazonS3BucketProxy(
            		env.getProperty("adminjmi.aws.bucket.name"),
            		env.getProperty("adminjmi.aws.access.key.id"),
            		env.getProperty("adminjmi.aws.secret.access.key")
            		).uploadObject(path.toString());
            File fileUploaded = new File(path.toString());
            fileUploaded.delete();
        }
        return bucketUrl;
    }

}
