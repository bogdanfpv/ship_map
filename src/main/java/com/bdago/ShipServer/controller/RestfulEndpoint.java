package com.bdago.ShipServer.controller;

import com.bdago.ShipServer.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/ships")
public class RestfulEndpoint {

    private final ShipService shipService;

    @Autowired
    public RestfulEndpoint(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("/unique-names")
    public List<String> getUniqueNamesInTimeframe(
            @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime end) {
        return shipService.getUniqueNamesInTimeframe(start, end);
    }
}

//The client should send GET requests to /api/ships/unique-names?start=<start-time>&end=<end-time>
//In this implementation, the client specifies the (start,end) to the server