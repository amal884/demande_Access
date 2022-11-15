package com.supportportal.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Traitement {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String description ;

    @ManyToOne
    private Gestionnaire gestionnaire ;

    @ManyToOne
    private Demande demande ;




}
