package com.supportportal.web;

import lombok.extern.slf4j.Slf4j;
import com.supportportal.services.FileService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@RestController
@Slf4j
@CrossOrigin(origins = "*")

public class BadgeGetController {


    private final FileService fileService;


    public BadgeGetController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping(value = "/badge/{id}")

    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) throws IOException {

        String filename ="test";
        Resource file = fileService.download(filename);
        Path path = file.getFile()
                .toPath();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(path))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }





}
