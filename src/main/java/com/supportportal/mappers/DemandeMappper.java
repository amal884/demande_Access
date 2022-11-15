package com.supportportal.mappers;


import com.supportportal.dtos.DemandeEnginsDto;
import com.supportportal.dtos.DemandePersonneDdto;
import com.supportportal.dtos.DemandeTransitaireDto;
import com.supportportal.entities.DemandeEengins;
import com.supportportal.entities.DemandePersonne;
import com.supportportal.entities.DemandeTransitaire;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandeMappper {
    @Autowired
    private DemandeurMapper demandeurMapper;

    public DemandeEengins fromDemandeEnginsDto(DemandeEnginsDto demandeEnginsDto){
        DemandeEengins demandeEengins = new DemandeEengins();
        BeanUtils.copyProperties( demandeEnginsDto, demandeEengins);
//        demandeEengins.setDemandeur( demandeurMapper.fromDemandeurDto( demandeEnginsDto.getDemandeurDto() ) );
        return demandeEengins;
    }

    public DemandeEnginsDto fromDemandeEengins(DemandeEengins demandeEengins){
        System.out.println("mmmm");
        DemandeEnginsDto demandeEnginsDto = new DemandeEnginsDto();
        BeanUtils.copyProperties( demandeEengins, demandeEnginsDto);
//        demandeEnginsDto.setDemandeurDto( demandeurMapper.fromDemandeur( demandeEengins.getDemandeur() ) );
        demandeEnginsDto.setType( demandeEengins.getClass().getSimpleName() );
        return demandeEnginsDto;
    }


    public DemandeTransitaire fromDemandeTransitaireDTO(DemandeTransitaireDto demandeTransitaireDto){
        DemandeTransitaire demandeTransitaire = new DemandeTransitaire();
        BeanUtils.copyProperties( demandeTransitaireDto, demandeTransitaire);
        demandeTransitaire.setDemandeur( demandeurMapper.fromDemandeurDto( demandeTransitaireDto.getDemandeurDto() ) );
        return demandeTransitaire;
    }

    public DemandeTransitaireDto fromDemandeTransitaire(DemandeTransitaire demandeTransitaire){
        DemandeTransitaireDto demandeTransitaireDto = new DemandeTransitaireDto();
        BeanUtils.copyProperties( demandeTransitaire, demandeTransitaireDto);
        demandeTransitaireDto.setDemandeurDto( demandeurMapper.fromDemandeur( demandeTransitaire.getDemandeur() ) );
        demandeTransitaireDto.setType( demandeTransitaire.getClass().getSimpleName() );
        return demandeTransitaireDto;
    }

    public DemandePersonne fromDemandePersonneDdto(DemandePersonneDdto demandePersonneDdto){
        DemandePersonne demandePersonne = new DemandePersonne();
        BeanUtils.copyProperties( demandePersonneDdto, demandePersonne);
        demandePersonne.setDemandeur( demandeurMapper.fromDemandeurDto( demandePersonneDdto.getDemandeurDto() ) );
        return demandePersonne;
    }

    public DemandePersonneDdto fromDemandePersonne(DemandePersonne demandePersonne){
        DemandePersonneDdto demandePersonneDdto = new DemandePersonneDdto();
        BeanUtils.copyProperties( demandePersonne, demandePersonneDdto);
        demandePersonneDdto.setDemandeurDto( demandeurMapper.fromDemandeur( demandePersonne.getDemandeur() ) );
        demandePersonneDdto.setType( demandePersonne.getClass().getSimpleName() );
        return demandePersonneDdto;
    }
//
//    public DemandePersonne demandePersonnetFromDemandePersonneRequestDto(DemandeRequestDto demandeRequestDto){
//        DemandePersonne demandePersonne = new DemandePersonne();
//        BeanUtils.copyProperties( demandeRequestDto, demandePersonne);
//        demandePersonne.setDemandeur( demandeurMapper.fromDemandeurDto( demandeRequestDto.getDemandeurDto() ) );
//        return demandePersonne;
//    }
//
//    public DemandeTransitaire demandeTransitaireFromDemandePersonneRequestDto(DemandeRequestDto demandeRequestDto){
//        DemandeTransitaire demandeTransitaire = new DemandeTransitaire();
//        BeanUtils.copyProperties( demandeRequestDto, demandeTransitaire);
//        demandeTransitaire.setDemandeur( demandeurMapper.fromDemandeurDto( demandeRequestDto.getDemandeurDto() ) );
//        return demandeTransitaire;
//    }





}
