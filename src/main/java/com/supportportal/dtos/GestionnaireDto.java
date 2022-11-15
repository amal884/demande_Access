package com.supportportal.dtos;

import com.supportportal.entities.Zone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GestionnaireDto {
    private Long id;

    private String nom ;

    private String prenom;

    private String adresse;

    private String email;

    private String telephone;

    private Zone zone ;
}
