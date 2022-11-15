package com.supportportal.services;



import com.supportportal.dtos.*;
import com.supportportal.entities.Demande;
import com.supportportal.exceptions.DemandeurNotFountException;

import java.io.IOException;
import java.util.List;

public interface DemandeService {

    DemandePersonneDdto saveDemandePersonne(DemandePersonneDdto demandePersonneDdto);

    DemandeTransitaireDto saveDemandeTransitaire(DemandeTransitaireDto demandeTransitaireDto);

    DemandeDto getDemande(Long demandeId);

    List<DemandeDto> listDemandeDTO();
    List<Demande> listDemande();

    void deleteDemande(Long demadeId);

    DemandeEnginsDto saveDemandeEngins(DemandeRequestDto demandeRequestDto1, String photoName, String cinFrontName, String cinBackName, String marcheFrontName, String marcheBackName, String marcheDureName, String cnssName, String demandeAccessName, String carteGriseName) throws DemandeurNotFountException, IOException, DemandeurNotFountException;
}