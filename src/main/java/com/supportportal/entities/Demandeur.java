package com.supportportal.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Demandeur {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String cin;
    private String nom ;

    private String prenom;

    private String adresse;

    private String email;

    private String telephone;

    private String organisme;

    private String photo;


    @OneToMany(mappedBy = "demandeur",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Demande> demandes = new ArrayList<>();

}
