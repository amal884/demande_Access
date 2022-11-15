package com.supportportal.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.supportportal.dtos.GestionnaireDto;
import com.supportportal.entities.Gestionnaire;
import com.supportportal.mappers.GestionnaireMapper;
import com.supportportal.repositories.GestionnaireDAO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class GestionnaireServiceImpl implements GestionnaireService {
    private GestionnaireDAO gestionnaireDAO;
    private GestionnaireMapper gestionnaireMapper;

    @Override
    public List<Gestionnaire> getGestionnaireHistory(Long gestionnaieId) {
        return null;
    }

    @Override
    public List<GestionnaireDto> listGestionnaire() {
        log.info("✔ Got the list of gestionnaires !");
        List<Gestionnaire> gestionnaires = gestionnaireDAO.findAll();
        List<GestionnaireDto> gestionnaireDtos = gestionnaires.stream().map(d -> gestionnaireMapper.fromGestionnaire(d)).collect(Collectors.toList());
        return gestionnaireDtos;
    }

    @Override
    public Gestionnaire savGestionnaire(Gestionnaire gestionnaire) {
        log.info("⌛ saving gestionnaire... ");
        Gestionnaire savedGestionnaire = gestionnaireDAO.save(gestionnaire);
        log.info("✔ gestionnaire saved ");
        return savedGestionnaire;
    }

    @Override
    public GestionnaireDto saveGestionnaire(GestionnaireDto gestionnaireDto) {
        log.info("⌛ saving gestionnaire... ");
        Gestionnaire gestionnaire = gestionnaireMapper.fromGestionnaireDto( gestionnaireDto);
        Gestionnaire savedGestionnaire = gestionnaireDAO.save(gestionnaire);
        log.info("✔ gestionnaire saved ");
        return gestionnaireMapper.fromGestionnaire(savedGestionnaire);
    }

    @Override
    public List<GestionnaireDto> searchGestionnaire(String searchKeyword) {

        List<Gestionnaire> gestionnaireList = gestionnaireDAO.searchGestionnaireByName("%"+searchKeyword+"%" );

        return gestionnaireList.stream().map( demandeur -> gestionnaireMapper.fromGestionnaire( demandeur))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteGestionnaire(String demid) {

    }
}
