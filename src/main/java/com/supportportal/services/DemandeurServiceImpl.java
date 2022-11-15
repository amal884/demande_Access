package com.supportportal.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.supportportal.dtos.DemandeurDto;
import com.supportportal.entities.Demande;
import com.supportportal.entities.Demandeur;
import com.supportportal.mappers.DemandeurMapper;
import com.supportportal.repositories.DemandeurDAO;
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
public class DemandeurServiceImpl implements DemandeurService {
    private DemandeurDAO demandeurDAO;
    private DemandeurMapper demandeurMapper;
    @Override
    public List<Demande> getDemandeHistory(String demandeurId) {
        return null;
    }

    @Override
    public List<DemandeurDto> listDemandeurs() {
        log.info("✔ Got the list of demandeurs !");
        List<Demandeur> demandeurs = demandeurDAO.findAll();
        List<DemandeurDto> demandeurDtos = demandeurs.stream().map(d -> demandeurMapper.fromDemandeur(d)).collect(Collectors.toList());
        return demandeurDtos;
    }

    @Override
    public Demandeur saveDemandeur(Demandeur demandeur) {
        log.info("⌛ saving demandeur... ");
        Demandeur savedDemandeur = demandeurDAO.save(demandeur);
        log.info("✔ demandeur saved ");
        return savedDemandeur;
    }

    @Override
    public DemandeurDto saveDemandeur(DemandeurDto demandeurDto) {

        log.info("⌛ saving Demandeur... ");
        Demandeur demandeur = demandeurMapper.fromDemandeurDto( demandeurDto);
        Demandeur savedDemandeur = demandeurDAO.save(demandeur);
        log.info("✔ Demandeur saved ");
        return demandeurMapper.fromDemandeur(savedDemandeur);
    }

    @Override
    public DemandeurDto getDemandeur(String cin) {
        Demandeur demandeur = demandeurDAO.findByCin(cin);
        return demandeurMapper.fromDemandeur( demandeur);
    }

    @Override
    public List<DemandeurDto> searchDemandeur(String searchKeyword) {
        List<Demandeur> customerList = demandeurDAO.searchDemandeurByName("%"+searchKeyword+"%" );

        return customerList.stream().map( demandeur -> demandeurMapper.fromDemandeur( demandeur))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDemandeur(String demid) {
        log.info("⌛ deleting demandeur... ");
        demandeurDAO.deleteByCin(demid);
        log.info("✔ demandeur deleted ");
    }


}
