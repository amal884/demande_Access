package com.supportportal.mappers;

import com.supportportal.dtos.GestionnaireDto;
import com.supportportal.entities.Gestionnaire;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class GestionnaireMapper {

    public GestionnaireDto fromGestionnaire(Gestionnaire gestionnaire){
        GestionnaireDto gestionnaireDto = new GestionnaireDto();
        BeanUtils.copyProperties( gestionnaire, gestionnaireDto);
        return gestionnaireDto;
    }

    public Gestionnaire fromGestionnaireDto( GestionnaireDto gestionnaireDto){
        Gestionnaire gestionnaire = new Gestionnaire();
        BeanUtils.copyProperties( gestionnaireDto, gestionnaire);
        return gestionnaire;
    }
}
