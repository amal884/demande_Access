package com.supportportal.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.supportportal.entities.Demande;
import com.supportportal.repositories.DemandeDAO;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
//@RequestMapping("/file")
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class fileGetController {

    private DemandeDAO demandeDAO ;

    @GetMapping(value="/zip/{id}", produces="application/zip")
    public void zipFiles(HttpServletResponse response ,@PathVariable("id") Long id) throws IOException {

        System.out.println("mmm");
     Demande demande = demandeDAO.findById(id).get();
        //setting headers
        response.setStatus(HttpServletResponse.SC_OK);
        response.addHeader("Content-Disposition", "attachment; filename=\"documents.zip\"");
//        response.addHeader("Content-Disposition", "attachment; filename=\"test.zip\"");

        ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());

        // create a list to add files to be zipped
        ArrayList<File> files = new ArrayList<>(2);
        files.add(new File(String.valueOf(Paths.get(System.getProperty("user.home")+"/gestionAccess/photo/"+demande.getPhoto()  ))));
        files.add(new File(String.valueOf(Paths.get(System.getProperty("user.home")+"/gestionAccess/cinFront/"+demande.getCinFront()  ))));
        files.add(new File(String.valueOf(Paths.get(System.getProperty("user.home")+"/gestionAccess/cinBack/"+demande.getCinBack() ))));
        files.add(new File(String.valueOf(Paths.get(System.getProperty("user.home")+"/gestionAccess/demandeAccess/"+demande.getDemandeAccess() ))));
        files.add(new File(String.valueOf(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheFront/"+demande.getMarcheFront() ))));
        files.add(new File(String.valueOf(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheBack/"+demande.getMarcheBack() ))));
        files.add(new File(String.valueOf(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheDure/"+demande.getMarcheDure()))));
        files.add(new File(String.valueOf(Paths.get(System.getProperty("user.home")+"/gestionAccess/cnss/"+demande.getCnss()))));



//        files.add(new File(String.valueOf(Paths.get(System.getProperty("user.home")+"/gestionAccess/cinFront/message.jpg)"))));
        // package files
        for (File file : files) {
            //new zip entry and copying inputstream with file to zipOutputStream, after all closing streams
            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
            FileInputStream fileInputStream = new FileInputStream(file);

            IOUtils.copy(fileInputStream, zipOutputStream);

            fileInputStream.close();
            zipOutputStream.closeEntry();
        }

        zipOutputStream.close();
    }

//    @GetMapping("download")
//    public ResponseEntity<Resource> downloadFiles() throws IOException {
//
//        //setting headers
//
//        Resource resource = new UrlResource(filePath.toUri());
//        response.setStatus(HttpServletResponse.SC_OK);
//        response.addHeader("Content-Disposition", "attachment; filename=\"test.zip\"");
//
//        ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());
//
//        // create a list to add files to be zipped
//        ArrayList<File> files = new ArrayList<>(2);
//        files.add(new File(String.valueOf(Paths.get(System.getProperty("user.home")+"/gestionAccess/photo/s22.png"))));
//        files.add(new File(String.valueOf(Paths.get(System.getProperty("user.home")+"/gestionAccess/cinFront/message.jpg"))));
//        // package files
//        for (File file : files) {
//            //new zip entry and copying inputstream with file to zipOutputStream, after all closing streams
//            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
//            FileInputStream fileInputStream = new FileInputStream(file);
//
//            IOUtils.copy(fileInputStream, zipOutputStream);
//
//            fileInputStream.close();
//            zipOutputStream.closeEntry();
//        }
//
//        zipOutputStream.close();
//    }


//    @GetMapping("download/{filename}")
//    public ResponseEntity<Resource> downloadFiles(@PathVariable("filename") String filename) throws IOException {
//        Path filePath = get(DIRECTORY).toAbsolutePath().normalize().resolve(filename);
//        if(!Files.exists(filePath)) {
//            throw new FileNotFoundException(filename + " was not found on the server");
//        }
//        Resource resource = new UrlResource(filePath.toUri());
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("File-Name", filename);
//        httpHeaders.add(CONTENT_DISPOSITION, "attachment;File-Name=" + resource.getFilename());
//        return ResponseEntity.ok().contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
//                .headers(httpHeaders).body(resource);
//    }
}
