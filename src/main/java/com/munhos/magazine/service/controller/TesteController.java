package com.munhos.magazine.service.controller;



import com.itextpdf.text.DocumentException;
import com.munhos.magazine.service.service.VendaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.IOException;

@RestController
public class TesteController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private VendaService vendaService;

    @GetMapping("/gerarPDF")
    public ResponseEntity<Resource> gerarPDF() {
        try {
            vendaService.gerarPDF();
            File file = new File("vendas.pdf");
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=vendas.pdf");
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);
            headers.add(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.length()));
            Resource resource = new FileSystemResource(file);
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(resource);
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}