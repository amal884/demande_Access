package com.supportportal.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@DiscriminatorValue("ENGIIN")
public class DemandeEengins extends Demande{
    private String carteGrise;

}
