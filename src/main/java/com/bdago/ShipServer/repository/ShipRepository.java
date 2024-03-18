package com.bdago.ShipServer.repository;

import com.bdago.ShipServer.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bdago.ShipServer.projection.ShipProjection;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {

    @Query("SELECT DISTINCT s.MMSI FROM Ship s WHERE s.BaseDate BETWEEN :start AND :end")
    List<String> findUniqueNamesInTimeframe(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    @Query("SELECT s.MMSI, s.LAT, s.LON, s.BaseDate as LatestDateTime FROM Ship s INNER JOIN (SELECT s.MMSI as MMSI, MAX(s.BaseDate) as MaxBaseDate FROM Ship s WHERE s.BaseDate BETWEEN :start AND :end GROUP BY s.MMSI) as maxDates ON s.MMSI = maxDates.MMSI AND s.BaseDate = maxDates.MaxBaseDate")
    List<ShipProjection> getCurrentShips(@Param("start") Timestamp start, @Param("end") Timestamp end);
}