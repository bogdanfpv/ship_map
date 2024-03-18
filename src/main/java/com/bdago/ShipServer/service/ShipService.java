package com.bdago.ShipServer.service;

import com.bdago.ShipServer.repository.ShipRepository;
import com.bdago.ShipServer.projection.ShipProjection;
import com.bdago.ShipServer.time.StartTimeService;
import com.bdago.ShipServer.time.TimeService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TemporalType;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShipService {

    @Autowired
    private ShipRepository shipRepository;

    @Autowired
    private StartTimeService startTimeService;

    @Autowired
    private TimeService timeService;



    @PersistenceContext
    private EntityManager entityManager;

    public List<String> getUniqueNamesInTimeframe(LocalDateTime start, LocalDateTime end) {
        return shipRepository.findUniqueNamesInTimeframe(start, end);
    }

    public List<ShipProjection> getCurrentShips() {
        TypedQuery<ShipProjection> query = entityManager.createQuery("SELECT new com.bdago.ShipServer.projection.ShipProjection(s.MMSI, s.LAT, s.LON, s.BaseDate as LatestDateTime) FROM Ship s INNER JOIN (SELECT s.MMSI as MMSI, MAX(s.BaseDate) as MaxBaseDate FROM Ship s WHERE s.BaseDate BETWEEN :start AND :end GROUP BY s.MMSI) as maxDates ON s.MMSI = maxDates.MMSI AND s.BaseDate = maxDates.MaxBaseDate", ShipProjection.class);
        query.setParameter("start", Timestamp.valueOf(startTimeService.getDataStartTime()), TemporalType.TIMESTAMP);
        query.setParameter("end", Timestamp.valueOf(timeService.getTime()), TemporalType.TIMESTAMP);
        return query.getResultList();
    }
}
