package com.supportportal.repositories;


import com.supportportal.entities.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeDAO extends JpaRepository<Demande, Long> {

}
