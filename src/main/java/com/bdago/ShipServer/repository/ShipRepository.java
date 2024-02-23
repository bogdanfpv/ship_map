package com.bdago.ShipServer.repository;

import com.bdago.ShipServer.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    @Query("SELECT DISTINCT s.MMSI FROM Ship s WHERE s.BaseDate BETWEEN :start AND :end")
    List<String> findUniqueNamesInTimeframe(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

}
