package com.FileUpload.FileUpload.service;


import com.FileUpload.FileUpload.entity.Document;
import com.FileUpload.FileUpload.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document saveFile(MultipartFile file) throws IOException {
       String name= file.getOriginalFilename();
        try {
            Document document=new Document();
            document.setName(name);
            document.setType(file.getContentType());
            document.setData(file.getBytes());
            return  documentRepository.save(document);
        }catch (Exception e){
                 e.printStackTrace();
        }
         return  null;

    }

    public Optional<Document> getFile(UUID fileId){
        return  documentRepository.findById(fileId);
    }

    public List<Document> getFiles(){
        return  documentRepository.findAll();
    }
    public void deleteFile( UUID id) throws Exception {
        documentRepository.deleteById(id);

    }
    public Document saveFiles(MultipartFile[] files) {
        for (MultipartFile file : files) {
            String name= file.getOriginalFilename();

            Document document=new Document();

            try {

                document.setName(name);
                document.setData(file.getBytes());
                document.setType(file.getContentType());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return  documentRepository.save(document);
        }
        return null ;
    }
}
