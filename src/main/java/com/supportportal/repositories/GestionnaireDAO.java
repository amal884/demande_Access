package com.supportportal.repositories;

import com.supportportal.entities.Gestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GestionnaireDAO  extends JpaRepository<Gestionnaire, Long> {
    @Query(" SELECT C FROM Gestionnaire C WHERE C.nom LIKE :kw")
    List<Gestionnaire> searchGestionnaireByName(@Param("kw") String keyword);
}
