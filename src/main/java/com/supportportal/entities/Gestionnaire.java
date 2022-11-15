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
public class Gestionnaire {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String nom ;

    private String prenom;

    private String adresse;

    private String email;

    private String telephone;

    @Enumerated(EnumType.STRING)
    private Zone zone ;


    @OneToMany(mappedBy = "gestionnaire")
    private List<Traitement> traitements = new ArrayList<>();
}
