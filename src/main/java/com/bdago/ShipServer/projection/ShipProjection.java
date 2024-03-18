package com.bdago.ShipServer.projection;

import java.sql.Timestamp;

public class ShipProjection {
    private String MMSI;
    private Double LAT;
    private Double LON;
    private Timestamp LatestDateTime;

    public ShipProjection(String MMSI, Double LAT, Double LON, Timestamp LatestDateTime) {
        this.MMSI = MMSI;
        this.LAT = LAT;
        this.LON = LON;
        this.LatestDateTime = LatestDateTime;
    }

    public String getMMSI() {
        return MMSI;
    }

    public Double getLAT() {
        return LAT;
    }

    public Double getLON() {
        return LON;
    }

    public Timestamp getLatestDateTime() {
        return LatestDateTime;
    }
}