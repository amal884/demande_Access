package com.supportportal.repositories;


import com.supportportal.entities.Demandeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeurDAO extends JpaRepository<Demandeur, Long> {

//    List<Demandeur>  getAll( String accountId);
@Query(" SELECT C FROM Demandeur C WHERE C.nom LIKE :kw")
List<Demandeur> searchDemandeurByName(@Param("kw") String keyword);

Demandeur findByCin(String cin);

  void deleteByCin( String  cin);

}
