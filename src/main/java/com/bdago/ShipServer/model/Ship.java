package com.bdago.ShipServer.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ships")
public class Ship {
    private Long id;

    public Ship() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "MMSI")
    private String MMSI;

    @Column(name = "BaseDate")
    private LocalDateTime BaseDate;

    @Column(name = "VesselName")
    private String VesselName;

    @Column(name = "LAT")
    private double LAT;

    @Column(name = "LON")
    private double LON;

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getMMSI() {
        return MMSI;
    }

    public void setMMSI(String MMSI) {
        this.MMSI = MMSI;
    }

    public LocalDateTime getBaseDate() {
        return BaseDate;
    }

    public void setBaseDate(LocalDateTime BaseDate) {
        BaseDate = BaseDate;
    }

    public String getVesselName() {
        return VesselName;
    }

    public void setVesselName(String VesselName) {
        VesselName = VesselName;
    }

    public double getLAT() {
        return LAT;
    }

    public void setLAT(double LAT) {
        this.LAT = LAT;
    }

    public double getLON() {
        return LON;
    }

    public void setLON(double LON) {
        this.LON = LON;
    }
}
