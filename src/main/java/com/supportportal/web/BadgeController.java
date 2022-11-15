package com.supportportal.web;

import com.itextpdf.text.DocumentException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.supportportal.entities.Badge;
import com.supportportal.entities.Demande;
import com.supportportal.mappers.BadgeMapper;
import com.supportportal.repositories.BadgeDAO;
import com.supportportal.repositories.DemandeDAO;
import com.supportportal.services.BadgeService;
import com.supportportal.services.FileService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
//import org.thymeleaf.spring4.SpringTemplateEngine;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class BadgeController {
    @Autowired
    private BadgeService badgeService;
    @Autowired
    private BadgeDAO badgeDAO;
    @Autowired
    private DemandeDAO demandeDAO;
    @Autowired
    private BadgeMapper badgeMapper;


//    @Autowired
//    SpringTemplateEngine templateEngine;

    @Autowired
    private final FileService fileService;




   @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/getdetails/{id}" ,produces="application/pdf")
//    @ResponseBody
    public void savePDF( @PathVariable(name="id") Long idDemande) throws IOException, DocumentException {
//       String html ;
//       String outputFolder = System.getProperty("user.home") + File.separator + "thymeleaf.pdf";
//       OutputStream outputStream = new FileOutputStream(outputFolder);
//
//       ITextRenderer renderer = new ITextRenderer();
//       renderer.setDocumentFromString(html);
//       renderer.layout();
//       renderer.createPDF(outputStream);
//
//       outputStream.close();




   }
}
