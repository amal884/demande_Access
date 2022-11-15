package com.supportportal.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.supportportal.dtos.*;
import com.supportportal.entities.*;
import com.supportportal.exceptions.DemandeurNotFountException;
import com.supportportal.mappers.DemandeMappper;
import com.supportportal.repositories.DemandeDAO;
import com.supportportal.repositories.DemandeurDAO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.io.DataInput;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@NoArgsConstructor
@Data
@Service
@Transactional
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")

public class DemandeServiceImpl implements DemandeService {
    private DemandeurDAO demandeurDAO ;
    @Autowired
    private DemandeDAO demandeDAO;
    private DemandeMappper demandeMapper;

    @Override
    public DemandePersonneDdto saveDemandePersonne(DemandePersonneDdto demandePersonneDdto) {


        return null;
    }

    @Override
    public DemandeTransitaireDto saveDemandeTransitaire(DemandeTransitaireDto demandeTransitaireDto) {
        return null;
    }



    @Override
    public DemandeDto getDemande(Long demandeId) {
        return null;
    }

    @Override
    public List<DemandeDto> listDemandeDTO() {
        List<Demande> demandes = demandeDAO.findAll();
        System.out.println(demandes);
        List<DemandeDto> demandeDtos = demandes.stream().map(demande -> {
            System.out.println(demandeMapper.fromDemandeEengins((DemandeEengins) demande));
            if (demande instanceof DemandeTransitaire)
                return demandeMapper.fromDemandeTransitaire((DemandeTransitaire) demande);
            else if (demande instanceof DemandeEengins) {
                System.out.println(demandes);
                return demandeMapper.fromDemandeEengins((DemandeEengins) demande);
            }
            else
                return demandeMapper.fromDemandePersonne((DemandePersonne) demande);
        }).collect(Collectors.toList());
        return demandeDtos;
    }

    @Override
    public List<Demande> listDemande() {
        return demandeDAO.findAll();
    }

    @Override
    public void deleteDemande(Long demadeId) {

    }

    @Override
    public DemandeEnginsDto saveDemandeEngins(DemandeRequestDto demandeRequestDto1, String photoName, String cinFrontName , String cinBackName, String marcheFrontName, String marcheBackName,
                                              String marcheDureName, String cnssName, String demandeAccessName, String carteGriseName) throws DemandeurNotFountException, IOException {
        log.info("⌛ Checking if demandeur exists... ");
        Demandeur demandeur = demandeurDAO.findByCin(demandeRequestDto1.getCin()) ;
        if (demandeur == null)
            throw new DemandeurNotFountException(" Customer not found !! ");
        log.info("✔ Demandeur found !");
        DemandeEengins demandeEengins =  new ObjectMapper().readValue((DataInput) demandeRequestDto1,DemandeEengins.class);
        log.info("⌛ creating Demande - engins ... ");
//        DemandeRequestDto demandeRequestDto1 = new ObjectMapper().readValue(demandeRequestDto,DemandeRequestDto.class);
        demandeEengins.setDemandeur(demandeur);
        demandeEengins.setPhoto(photoName);
        demandeEengins.setCinFront(cinFrontName);
        demandeEengins.setCinBack(cinBackName);
        demandeEengins.setMarcheFront(marcheFrontName);
        demandeEengins.setMarcheBack(marcheBackName);
        demandeEengins.setMarcheDure(marcheDureName);
        demandeEengins.setDemandeAccess(demandeAccessName);
        demandeEengins.setCnss(cnssName);
        demandeEengins.setCarteGrise(carteGriseName);
        demandeEengins.setDate((java.sql.Date) new Date());
        demandeEengins.setDemandeStatus(DemandeStatus.RECUE);

        DemandeEengins savedDemandeEngins = demandeDAO.save(demandeEengins);
        log.info("✔ demande Engins created !");
        return demandeMapper.fromDemandeEengins(savedDemandeEngins);
    }

}
