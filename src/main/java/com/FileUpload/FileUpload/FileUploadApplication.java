package com.FileUpload.FileUpload;

import com.FileUpload.FileUpload.service.DocumentService;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class FileUploadApplication implements CommandLineRunner {

	@Resource
	DocumentService storageService;


	public static void main(String[] args) {
		SpringApplication.run(FileUploadApplication.class, args);
	}
	@Override
	public void run(String... arg) throws Exception {
		//storageService.deleteAll();
		//storageService.init();
		 }
}
