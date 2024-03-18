package com.bdago.ShipServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.bdago.ShipServer.time.TimeService;
import com.bdago.ShipServer.projection.ShipProjection;
import com.bdago.ShipServer.service.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/ships")
public class RestfulEndpoint {

    private final ShipService shipService;
    private TimeService timeService;

    @Autowired
    public RestfulEndpoint(ShipService shipService, TimeService timeService) {
        this.shipService = shipService;
        this.timeService = timeService;
    }

    @GetMapping("/unique-names")
    public List<String> getUniqueNamesInTimeframe(
            @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime end) {
        return shipService.getUniqueNamesInTimeframe(start, end);
    }

    @GetMapping("/current-time")
    public String getCurrentTime() {
        return timeService.getCurrentTime();
    }

    @GetMapping("/current-ships")
    public List<ShipProjection> getCurrentShips() {
        return shipService.getCurrentShips();
    }

}