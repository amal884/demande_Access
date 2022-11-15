package com.supportportal.repositories;


import com.supportportal.entities.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeDAO extends JpaRepository<Badge, Long> {
    @Query(" SELECT B FROM Badge B WHERE B.demande.id = :id")
    Badge searchBadgeByDemande(@Param("id") Long id);

}
