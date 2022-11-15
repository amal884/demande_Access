package com.supportportal.dtos;

import com.supportportal.entities.BadgeStatus;
import com.supportportal.entities.BadgeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BadgeDto {
    private Long id;
    private Date dateDebut ;
    private Date dateFin ;
    private BadgeStatus status ;
    private BadgeType badgeType ;


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

     private DemandeDto demandeDto ;

}
