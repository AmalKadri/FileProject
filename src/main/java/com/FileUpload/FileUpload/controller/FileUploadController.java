package com.FileUpload.FileUpload.controller;


import com.FileUpload.FileUpload.entity.Document;
import com.FileUpload.FileUpload.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
public class FileUploadController {

    @Autowired
    private DocumentService documentService;

    @GetMapping("/")
    public  List<Document> get(Model model){
        List<Document> docs=documentService.getFiles();
        model.addAttribute("docs",docs);
        return docs;
    }

   @PostMapping("/uploadFile")
    public String upload (@RequestParam("file") MultipartFile file) throws IOException {
        documentService.saveFile(file);
        return  "file uploaded";
   }

   @GetMapping("/file/{id}")
    public Optional<Document> findById(@PathVariable UUID id) throws Exception {
        Optional<Document> p=documentService.getFile(id);
        return p;

}

    @DeleteMapping("/file/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID id) throws Exception{
        documentService.deleteFile(id);

        return new ResponseEntity<String>("Product with id"+id+"has been deleted",HttpStatus.OK);
    }
    @PostMapping("/Files")
    public String uploadFiles (@RequestParam("files") MultipartFile[] files) throws IOException {
        for (MultipartFile file: files) {
            documentService.saveFiles(files);
        }
        return  "files uploaded";
    }

}
