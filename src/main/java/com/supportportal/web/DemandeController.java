package com.supportportal.web;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.supportportal.dtos.*;
import com.supportportal.entities.*;
import com.supportportal.exceptions.DemandeNotFoundException;
import com.supportportal.mappers.DemandeMappper;
import com.supportportal.mappers.DemandeurMapper;
import com.supportportal.repositories.BadgeDAO;
import com.supportportal.repositories.DemandeDAO;
import com.supportportal.repositories.DemandeurDAO;
import com.supportportal.services.BadgeService;
import com.supportportal.services.DemandeService;
import com.supportportal.services.DemandeurService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
//@RequestMapping(value =  "/demande")
public class DemandeController {
    @Autowired
    private DemandeService demandeService;
    @Autowired
    private DemandeDAO demandeDAO ;
    @Autowired
    private DemandeurService demandeurService;
    @Autowired
    private DemandeurDAO demandeurDAO ;

    @Autowired
    private BadgeService badgeService;
    @Autowired
    private BadgeDAO badgeDAO ;

    @Autowired

    private DemandeMappper demandeMappper;
    @Autowired
    private DemandeurMapper demandeurMapper;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(path="/test",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto() throws Exception{
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/cinFront/s22.png"));
    }
    @GetMapping(path = "/url" )
    public URL testUrl() throws MalformedURLException {
        System.out.println("mmmmmm");
        File myFile=new File(String.valueOf(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheBack/s22.png")));
        URL url = myFile.toURI().toURL();
        log.info("✔ Demande Engins  created !");
        return url;
    }





    @GetMapping(path = "/demandes" )
    public List<DemandeDto> getAllDemandes() {

        List<DemandeDto> demandeDto=  demandeService.listDemande().stream().map(demande -> {
            if (demande instanceof DemandeTransitaire){
                DemandeurDto demandeurDto= modelMapper.map(demande.getDemandeur(), DemandeurDto.class);
                DemandeTransitaireDto demandeTransitaireDto = modelMapper.map(demande, DemandeTransitaireDto.class);
                demandeTransitaireDto.setDemandeurDto(demandeurDto);
                demandeTransitaireDto.setType( demande.getClass().getSimpleName() );
                try {
                    demandeTransitaireDto.setPhoto(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/photo/"+demande.getPhoto()))));
                    demandeTransitaireDto.setCinFront(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/cinFront/"+demande.getCinFront()))));
                    demandeTransitaireDto.setCinBack(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/cinBack/"+demande.getCinBack()))));
                    demandeTransitaireDto.setMarcheFront(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheFront/"+demande.getMarcheFront()))));
                    demandeTransitaireDto.setMarcheBack(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheBack/"+demande.getMarcheBack()))));
                    demandeTransitaireDto.setMarcheDure(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheDure/"+demande.getMarcheBack()))));
                    demandeTransitaireDto.setMarcheDure(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheDure/"+demande.getMarcheBack()))));
                    demandeTransitaireDto.setCnss(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/cnss/"+demande.getCnss()))));
                    demandeTransitaireDto.setDemandeAccess(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/demandeAccess/"+demande.getDemandeAccess()))));
                    demandeTransitaireDto.setDim(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/dim/"+ ((DemandeTransitaire) demande).getDim()))));



                } catch (IOException e) {
                    e.printStackTrace();
                }

                return demandeTransitaireDto;
            }
            else if (demande instanceof DemandeEengins) {
                DemandeurDto demandeurDto= modelMapper.map(demande.getDemandeur(), DemandeurDto.class);
                DemandeEnginsDto demandeEnginsDto = modelMapper.map(demande, DemandeEnginsDto.class);
                demandeEnginsDto.setDemandeurDto(demandeurDto);
                demandeEnginsDto.setType( demande.getClass().getSimpleName() );
                try {
                    System.out.println(demande.getPhoto());
                    demandeEnginsDto.setPhoto(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/photo/"+demande.getPhoto()))));
                    demandeEnginsDto.setCinFront(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/cinFront/"+demande.getCinFront()))));
                    demandeEnginsDto.setCinBack(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/cinBack/"+demande.getCinBack()))));
                    demandeEnginsDto.setMarcheFront(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheFront/"+demande.getMarcheFront()))));
                    demandeEnginsDto.setMarcheBack(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheBack/"+demande.getMarcheBack()))));
                    demandeEnginsDto.setMarcheDure(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheDure/"+demande.getMarcheDure()))));
                    demandeEnginsDto.setCnss(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/cnss/"+demande.getCnss()))));
                    demandeEnginsDto.setDemandeAccess(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/demandeAccess/"+demande.getDemandeAccess()))));
                    demandeEnginsDto.setCarteGrise(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/carteGrise/"+((DemandeEengins) demande).getCarteGrise()))));



                } catch (IOException e) {
                    e.printStackTrace();
                }

                return demandeEnginsDto;
            }
            else {
                DemandeurDto demandeurDto= modelMapper.map(demande.getDemandeur(), DemandeurDto.class);
                DemandePersonneDdto demandePersonneDdto = modelMapper.map(demande, DemandePersonneDdto.class);
                demandePersonneDdto.setDemandeurDto(demandeurDto);
                demandePersonneDdto.setType( demande.getClass().getSimpleName() );
                try {
                    demandePersonneDdto.setPhoto(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/photo/"+demande.getPhoto()))));
                    demandePersonneDdto.setCinFront(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/cinFront/"+demande.getCinFront()))));
                    demandePersonneDdto.setCinBack(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/cinBack/"+demande.getCinBack()))));
                    demandePersonneDdto.setMarcheFront(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheFront/"+demande.getMarcheFront()))));
                    demandePersonneDdto.setMarcheBack(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheBack/"+demande.getMarcheBack()))));
                    demandePersonneDdto.setMarcheDure(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheDure/"+demande.getMarcheBack()))));
                    demandePersonneDdto.setMarcheDure(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheDure/"+demande.getMarcheBack()))));
                    demandePersonneDdto.setCnss(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/cnss/"+demande.getCnss()))));
                    demandePersonneDdto.setDemandeAccess(String.valueOf(Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/gestionAccess/demandeAccess/"+demande.getDemandeAccess()))));




                } catch (IOException e) {
                    e.printStackTrace();
                }
                return demandePersonneDdto;
            }
                })
                .collect(Collectors.toList());
        return  demandeDto;
    }

//    @PostMapping("/demande")
//    public DemandeDto saveDemandeDto(@RequestBody DemandeDto request){
//        return demandeService.saveDemande( request);
//    }
//    @PostMapping("/demandes")
//    public Demande saveDemande(@RequestBody Demande request){
//        return demandeService.saveDemande( request);
//    }

    @GetMapping("/demande/search")
    public DemandeDto getDemande(@RequestParam(name = "keyword", defaultValue = "") Long keyword) throws DemandeNotFoundException {

        return demandeService.getDemande(keyword);
    }

    @PostMapping("/demandes-engin")
    public void saveDemandeEngin(@RequestParam("photo") MultipartFile photo, @RequestParam("cinFront") MultipartFile cinFront,
                                  @RequestParam("cinBack") MultipartFile cinBack,
                                  @RequestParam("marcheFront") MultipartFile marcheFront,
                                  @RequestParam("marcheBack") MultipartFile marcheBack,
                                  @RequestParam("marcheDure") MultipartFile marcheDure,
                                  @RequestParam("cnss") MultipartFile cnss,
                                  @RequestParam("demandeAccess") MultipartFile demandeAccess,
                                  @RequestParam("carteGrise") MultipartFile carteGrise,
                                  @RequestParam("badgeType") String badgeType,
                                  @RequestParam("TYPE") String TYPE,


                                  @RequestParam("demandeRequestDto") String  demandeRequestDto) throws IOException {
        System.out.println("mmmm");

        ObjectMapper mapper =new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        System.out.println(TYPE);
        System.out.println(demandeRequestDto);


        DemandeRequestDto demandeRequestDto1 = mapper.readValue(demandeRequestDto,DemandeRequestDto.class);
//        Demandeur demandeur = demandeurDAO.findByCin(demandeRequestDto1.getCin());
          Demandeur demandeur = new Demandeur();
          demandeur.setCin(demandeRequestDto1.getCin());
          demandeur.setNom(demandeRequestDto1.getNom());
          demandeur.setPrenom(demandeRequestDto1.getPrenom());
          demandeur.setEmail(demandeRequestDto1.getEmail());
          demandeur.setAdresse(demandeRequestDto1.getAdresse());
          demandeur.setOrganisme(demandeRequestDto1.getOrganisme());
          demandeur.setTelephone(demandeRequestDto1.getTelephone());
          demandeurDAO.save(demandeur);
//        System.out.println(demandeur.getId());
        if(TYPE.equals("ENGIIN")){

            System.out.println(demandeRequestDto1);
            DemandeEengins demandeEengins = new DemandeEengins();
            demandeEengins.setDate(new Date());

            demandeEengins.setDemandeur(demandeur);
//
            demandeEengins.setANP(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("ANP"::equals));
            demandeEengins.setSOMAPORT(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("SOMAPORT"::equals));
            demandeEengins.setMARSAMAROC(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("MARSAMAROC"::equals));
            demandeEengins.setPORTNET(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("PORTNET"::equals));
            demandeEengins.setMASSCEREALES(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("MASSCEREALES"::equals));
            demandeEengins.setONCF(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("ONCF"::equals));
            demandeEengins.setOCP(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("OCP"::equals));
            demandeEengins.setTC3(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("TC3"::equals));
            demandeEengins.setDGSN(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("DGSN"::equals));
            demandeEengins.setPROTECTIONCIVIL(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("PROTECTIONCIVIL"::equals));
            demandeEengins.setONSA(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("ONSA"::equals));
            demandeEengins.setCHANTIERNAVAL(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("CHANTIERNAVAL"::equals));
            demandeEengins.setMOULAYYOUSSEF(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("MOULAYYOUSSEF"::equals));
            demandeEengins.setDemandeStatus(DemandeStatus.RECUE);
            if(badgeType.equals("PERMANENT")){
                demandeEengins.setBadgeType(BadgeType.PERMANENT);
            }else{
                demandeEengins.setBadgeType(BadgeType.PROVISOIR);
            }

            System.out.println("bbbbbbb");

            demandeEengins.setPhoto(photo.getOriginalFilename());
            demandeEengins.setCinFront(cinFront.getOriginalFilename());
            demandeEengins.setCinBack(cinBack.getOriginalFilename());
            demandeEengins.setMarcheFront(marcheFront.getOriginalFilename());
            demandeEengins.setMarcheBack(marcheBack.getOriginalFilename());
            demandeEengins.setMarcheDure(marcheDure.getOriginalFilename());
            demandeEengins.setCnss(cnss.getOriginalFilename());
            demandeEengins.setDemandeAccess(demandeAccess.getOriginalFilename());
            demandeEengins.setCarteGrise(carteGrise.getOriginalFilename());
            String photoName = photo.getOriginalFilename();
            String cinFrontName = cinFront.getOriginalFilename();
            String cinBackName = cinBack.getOriginalFilename();
            String marcheFrontName = marcheFront.getOriginalFilename();
            String marcheBackName = marcheBack.getOriginalFilename();
            String marcheDureName = marcheDure.getOriginalFilename();
            String cnssName = cnss.getOriginalFilename();
            String demandeAccessName = demandeAccess.getOriginalFilename();
            String carteGriseName = carteGrise.getOriginalFilename();
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/photo/"+photoName),photo.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/cinFront/"+cinFrontName),cinFront.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/cinBack/"+cinBackName),cinBack.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheFront/"+marcheFrontName),marcheFront.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheBack/"+marcheBackName),marcheBack.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheDure/"+marcheDureName),marcheDure.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/cnss/"+cnssName),cnss.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/demandeAccess/"+demandeAccessName),demandeAccess.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/carteGrise/"+carteGriseName),carteGrise.getBytes());
            demandeDAO.save(demandeEengins);
            log.info("✔ Demande Engins  created !");


        }
        }

    //************************************************************************//

    @PostMapping("/demandes-personne")
    public void saveDemandePersonne(@RequestParam("photo") MultipartFile photo, @RequestParam("cinFront") MultipartFile cinFront,
                            @RequestParam("cinBack") MultipartFile cinBack,
                            @RequestParam("marcheFront") MultipartFile marcheFront,
                            @RequestParam("marcheBack") MultipartFile marcheBack,
                            @RequestParam("marcheDure") MultipartFile marcheDure,
                            @RequestParam("cnss") MultipartFile cnss,
                            @RequestParam("demandeAccess") MultipartFile demandeAccess,
                            @RequestParam("badgeType") String badgeType,
                            @RequestParam("TYPE") String TYPE,

                            @RequestParam("demandeRequestDto") String  demandeRequestDto) throws IOException {
        System.out.println("mmmm");

        ObjectMapper mapper =new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        System.out.println(TYPE);
        System.out.println(demandeRequestDto);


        DemandeRequestDto demandeRequestDto1 = mapper.readValue(demandeRequestDto,DemandeRequestDto.class);
//        Demandeur demandeur = demandeurDAO.findByCin(demandeRequestDto1.getCin());

        Demandeur demandeur = new Demandeur();
        demandeur.setCin(demandeRequestDto1.getCin());
        demandeur.setNom(demandeRequestDto1.getNom());
        demandeur.setPrenom(demandeRequestDto1.getPrenom());
        demandeur.setEmail(demandeRequestDto1.getEmail());
        demandeur.setAdresse(demandeRequestDto1.getAdresse());
        demandeur.setOrganisme(demandeRequestDto1.getOrganisme());
        demandeur.setTelephone(demandeRequestDto1.getTelephone());
        demandeurDAO.save(demandeur);
        System.out.println(demandeur.getId());
        if(TYPE.equals("PERSONNE")){

            System.out.println(demandeRequestDto1);
            DemandePersonne demandePersonne = new DemandePersonne();
            demandePersonne.setDate(new Date());

            demandePersonne.setDemandeur(demandeur);
//
            demandePersonne.setANP(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("ANP"::equals));
            demandePersonne.setSOMAPORT(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("SOMAPORT"::equals));
            demandePersonne.setMARSAMAROC(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("MARSAMAROC"::equals));
            demandePersonne.setPORTNET(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("PORTNET"::equals));
            demandePersonne.setMASSCEREALES(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("MASSCEREALES"::equals));
            demandePersonne.setONCF(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("ONCF"::equals));
            demandePersonne.setOCP(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("OCP"::equals));
            demandePersonne.setTC3(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("TC3"::equals));
            demandePersonne.setDGSN(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("DGSN"::equals));
            demandePersonne.setPROTECTIONCIVIL(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("PROTECTIONCIVIL"::equals));
            demandePersonne.setONSA(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("ONSA"::equals));
            demandePersonne.setCHANTIERNAVAL(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("CHANTIERNAVAL"::equals));
            demandePersonne.setMOULAYYOUSSEF(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("MOULAYYOUSSEF"::equals));
            demandePersonne.setDemandeStatus(DemandeStatus.RECUE);
            if(badgeType.equals("PERMANENT")){
                demandePersonne.setBadgeType(BadgeType.PERMANENT);
            }else{
                demandePersonne.setBadgeType(BadgeType.PROVISOIR);
            }

            System.out.println("bbbbbbb");

//            demandePersonne.setPhoto(photo.getOriginalFilename());
            demandePersonne.setCinFront(cinFront.getOriginalFilename());
            demandePersonne.setCinBack(cinBack.getOriginalFilename());
            demandePersonne.setMarcheFront(marcheFront.getOriginalFilename());
            demandePersonne.setMarcheBack(marcheBack.getOriginalFilename());
            demandePersonne.setMarcheDure(marcheDure.getOriginalFilename());
            demandePersonne.setCnss(cnss.getOriginalFilename());
            demandePersonne.setDemandeAccess(demandeAccess.getOriginalFilename());
            String photoName = photo.getOriginalFilename();
            String cinFrontName = cinFront.getOriginalFilename();
            String cinBackName = cinBack.getOriginalFilename();
            String marcheFrontName = marcheFront.getOriginalFilename();
            String marcheBackName = marcheBack.getOriginalFilename();
            String marcheDureName = marcheDure.getOriginalFilename();
            String cnssName = cnss.getOriginalFilename();
            String demandeAccessName = demandeAccess.getOriginalFilename();
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/photo/"+photoName),photo.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/cinFront/"+cinFrontName),cinFront.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/cinBack/"+cinBackName),cinBack.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheFront/"+marcheFrontName),marcheFront.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheBack/"+marcheBackName),marcheBack.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheDure/"+marcheDureName),marcheDure.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/cnss/"+cnssName),cnss.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/demandeAccess/"+demandeAccessName),demandeAccess.getBytes());
            demandeDAO.save(demandePersonne);
            log.info("✔ Demande Personne  created !");


        }
    }

    //************************************************************************//
    @PostMapping("/demandes-transitaire")
    public void saveDemandeTransitaire(@RequestParam("photo") MultipartFile photo, @RequestParam("cinFront") MultipartFile cinFront,
                                    @RequestParam("cinBack") MultipartFile cinBack,
                                    @RequestParam("marcheFront") MultipartFile marcheFront,
                                    @RequestParam("marcheBack") MultipartFile marcheBack,
                                    @RequestParam("marcheDure") MultipartFile marcheDure,
                                    @RequestParam("cnss") MultipartFile cnss,
                                    @RequestParam("demandeAccess") MultipartFile demandeAccess,
                                    @RequestParam("dim") MultipartFile dim,
                                    @RequestParam("badgeType") String badgeType,
                                    @RequestParam("TYPE") String TYPE,

                                    @RequestParam("demandeRequestDto") String  demandeRequestDto) throws IOException {
        System.out.println("mmmm");

        ObjectMapper mapper =new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        System.out.println(TYPE);
        System.out.println(demandeRequestDto);


        DemandeRequestDto demandeRequestDto1 = mapper.readValue(demandeRequestDto,DemandeRequestDto.class);
//        Demandeur demandeur = demandeurDAO.findByCin(demandeRequestDto1.getCin());

        Demandeur demandeur = new Demandeur();
        demandeur.setCin(demandeRequestDto1.getCin());
        demandeur.setNom(demandeRequestDto1.getNom());
        demandeur.setPrenom(demandeRequestDto1.getPrenom());
        demandeur.setEmail(demandeRequestDto1.getEmail());
        demandeur.setAdresse(demandeRequestDto1.getAdresse());
        demandeur.setOrganisme(demandeRequestDto1.getOrganisme());
        demandeur.setTelephone(demandeRequestDto1.getTelephone());
        demandeurDAO.save(demandeur);
        System.out.println(demandeur.getId());
        if(TYPE.equals("TRANSITAIRE")){

            System.out.println(demandeRequestDto1);
            DemandeTransitaire demandeTransitaire = new DemandeTransitaire();
            demandeTransitaire.setDate(new Date());

            demandeTransitaire.setDemandeur(demandeur);
//
            demandeTransitaire.setANP(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("ANP"::equals));
            demandeTransitaire.setSOMAPORT(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("SOMAPORT"::equals));
            demandeTransitaire.setMARSAMAROC(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("MARSAMAROC"::equals));
            demandeTransitaire.setPORTNET(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("PORTNET"::equals));
            demandeTransitaire.setMASSCEREALES(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("MASSCEREALES"::equals));
            demandeTransitaire.setONCF(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("ONCF"::equals));
            demandeTransitaire.setOCP(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("OCP"::equals));
            demandeTransitaire.setTC3(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("TC3"::equals));
            demandeTransitaire.setDGSN(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("DGSN"::equals));
            demandeTransitaire.setPROTECTIONCIVIL(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("PROTECTIONCIVIL"::equals));
            demandeTransitaire.setONSA(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("ONSA"::equals));
            demandeTransitaire.setCHANTIERNAVAL(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("CHANTIERNAVAL"::equals));
            demandeTransitaire.setMOULAYYOUSSEF(Arrays.stream(demandeRequestDto1.getCheckArray().toArray()).anyMatch("MOULAYYOUSSEF"::equals));
            demandeTransitaire.setDemandeStatus(DemandeStatus.RECUE);
            if(badgeType.equals("PERMANENT")){
                demandeTransitaire.setBadgeType(BadgeType.PERMANENT);
            }else{
                demandeTransitaire.setBadgeType(BadgeType.PROVISOIR);
            }

            System.out.println("bbbbbbb");

            demandeTransitaire.setPhoto(photo.getOriginalFilename());
            demandeTransitaire.setCinFront(cinFront.getOriginalFilename());
            demandeTransitaire.setCinBack(cinBack.getOriginalFilename());
            demandeTransitaire.setMarcheFront(marcheFront.getOriginalFilename());
            demandeTransitaire.setMarcheBack(marcheBack.getOriginalFilename());
            demandeTransitaire.setMarcheDure(marcheDure.getOriginalFilename());
            demandeTransitaire.setCnss(cnss.getOriginalFilename());
            demandeTransitaire.setDemandeAccess(demandeAccess.getOriginalFilename());
            demandeTransitaire.setDim(dim.getOriginalFilename());
            String photoName = photo.getOriginalFilename();
            String cinFrontName = cinFront.getOriginalFilename();
            String cinBackName = cinBack.getOriginalFilename();
            String marcheFrontName = marcheFront.getOriginalFilename();
            String marcheBackName = marcheBack.getOriginalFilename();
            String marcheDureName = marcheDure.getOriginalFilename();
            String cnssName = cnss.getOriginalFilename();
            String dimName = dim.getOriginalFilename();
            String demandeAccessName = demandeAccess.getOriginalFilename();
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/photo/"+photoName),photo.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/cinFront/"+cinFrontName),cinFront.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/cinBack/"+cinBackName),cinBack.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheFront/"+marcheFrontName),marcheFront.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheBack/"+marcheBackName),marcheBack.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/marcheDure/"+marcheDureName),marcheDure.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/cnss/"+cnssName),cnss.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/demandeAccess/"+demandeAccessName),demandeAccess.getBytes());
            Files.write(Paths.get(System.getProperty("user.home")+"/gestionAccess/dim/"+dimName),dim.getBytes());
            demandeDAO.save(demandeTransitaire);
            log.info("✔ Demande Transitaire  created !");


        }
    }

//    @PutMapping("/demandes/{id}")
//    public ResponseEntity<Demande> updateAccepte(@PathVariable("id") long id, @RequestBody demandeRequestStatus demandeStatus) {
//        System.out.println("mmmmmmmmmm");
//        Optional<Demande> tutorialData = demandeDAO.findById(id);
//
//        if (tutorialData.isPresent()) {
//            Demande _tutorial = tutorialData.get();
//            _tutorial.setDemandeStatus(DemandeStatus.ACCEPTE);
//
//            return new ResponseEntity<>(demandeDAO.save(_tutorial), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }


    @PutMapping ("/demandes/{id}") // put modifier touts les attribut . fatch modifier les attribut qui ont ete envoyer dans la requete
    public void save(@PathVariable Long id ,@RequestBody String demandeStatus){
        System.out.println("mm");
        Demande demande = demandeDAO.findById(id).orElseThrow(()->new RuntimeException(String.format("Demande not found")));
        demande.setDemandeStatus(DemandeStatus.ACCEPTE);
         badgeService.saveBadge(id);
         demandeDAO.save(demande);
    }







}



