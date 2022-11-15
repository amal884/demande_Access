package com.supportportal.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Demande {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id")
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

    private String photo;

    private String cinFront;


    private String cinBack;


    private String marcheFront;


    private String marcheBack;


    private String marcheDure;

    private String cnss;


    private String demandeAccess;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Demandeur demandeur;


    @OneToOne(mappedBy = "demande")
    private Badge badge ;

    @OneToMany(mappedBy = "demande")
    private  List<Traitement> traitements = new ArrayList<>();



}
