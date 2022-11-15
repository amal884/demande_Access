package com.supportportal.dtos;



import com.supportportal.entities.BadgeType;

import java.sql.Date;

public class Details {

    private Date dateDebut ;
    private Date dateFin ;
    private BadgeType badgeType ;

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

    private String name;

    private int age;

    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}



