package com.supportportal.services;

import com.supportportal.dtos.GestionnaireDto;
import com.supportportal.entities.Gestionnaire;

import java.util.List;

public interface GestionnaireService {
    public List<Gestionnaire> getGestionnaireHistory(Long gestionnaieId);

    List<GestionnaireDto> listGestionnaire();

    Gestionnaire savGestionnaire(Gestionnaire gestionnaire);

    GestionnaireDto saveGestionnaire(GestionnaireDto gestionnaireDto);

    List<GestionnaireDto> searchGestionnaire( String searchKeyword);

    void deleteGestionnaire(String demid);

}
