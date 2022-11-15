package com.supportportal.mappers;


import com.supportportal.dtos.DemandeurDto;
import com.supportportal.entities.Demandeur;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DemandeurMapper {

    public DemandeurDto fromDemandeur(Demandeur demandeur){
        DemandeurDto demandeurDto = new DemandeurDto();
        BeanUtils.copyProperties( demandeur, demandeurDto);
        return demandeurDto;
    }

    public Demandeur fromDemandeurDto( DemandeurDto demandeurDto){
        Demandeur demandeur = new Demandeur();
        BeanUtils.copyProperties( demandeurDto, demandeur);
        return demandeur;
    }


}
