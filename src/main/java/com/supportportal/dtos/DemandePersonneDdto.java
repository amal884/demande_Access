package com.supportportal.dtos;

import com.supportportal.entities.BadgeType;
import com.supportportal.entities.DemandeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandePersonneDdto extends DemandeDto {
    private Long id;
    private Date date ;
    private BadgeType badgeType ;
    private DemandeStatus demandeStatus ;
    private Boolean ANP;
    private Boolean SOMAPORT;
    private Boolean MARSAMAROC;
    private Boolean PORTNET;
    private Boolean MASSCEREALES;
    private Boolean ONCF;
    private Boolean OCP;
    private Boolean TC3;
    private Boolean DGSN;
    private Boolean PROTECTIONCIVIL;
    private Boolean ONSA;
    private Boolean CHANTIERNAVAL;
    private Boolean MOULAYYOUSSEF;

    private DemandeurDto demandeurDto;

    private String photo;


    private String cinFront;


    private String cinBack;


    private String marcheFront;


    private String marcheBack;

    private String marcheDure;

    private String cnss;

    private String demandeAccess;
}
