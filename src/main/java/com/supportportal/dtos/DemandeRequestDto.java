package com.supportportal.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeRequestDto {
//    private Date createdAt ;
//    private BadgeType badgeType ;
//    private DemandeStatus demandeStatus ;
    private String cin ;
    private String nom ;
    private String prenom ;
    private String adresse ;
    private String email ;
    private String telephone ;
    private String organisme ;

    private List<String> checkArray = new ArrayList<>();

    private Boolean SOMAPORT;
    private Boolean MARSAMAROC;
    private Boolean PORTNET;
    private Boolean MASSCEREALES;
    private Boolean ONCF;
    private Boolean OCP;
    private Boolean TC3;
    private Boolean ANP;
    private Boolean DGSN;
    private Boolean PROTECTIONCIVIL;
    private Boolean ONSA;
    private Boolean CHANTIERNAVAL;
    private Boolean MOULAYYOUSSEF;


}
