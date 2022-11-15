package com.supportportal.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeurDto {

    private String cin;

    private String nom ;

    private String prenom;

    private String adresse;

    private String email;

    private String telephone;

    private String organisme;




}
