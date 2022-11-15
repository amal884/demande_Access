package com.supportportal.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Badge {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private Date dateDebut ;
    private Date dateFin ;
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


//    @Enumerated(EnumType.STRING)
    private BadgeStatus status ;

    private BadgeType badgeType ;

    @OneToOne
    private Demande demande ;




}
