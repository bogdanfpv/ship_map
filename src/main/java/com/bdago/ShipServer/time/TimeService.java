package com.bdago.ShipServer.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

@Service
public class TimeService {

    @Autowired
    private StartTimeService startTimeService;

    public String getCurrentTime() {
        Duration elapsed = Duration.between(startTimeService.getStartLocalDateTime(), LocalDateTime.now());
        LocalDateTime current = startTimeService.getDataStartTimeLocalDateTime().plus(elapsed);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentFormatted = current.format(formatter);

        return currentFormatted;
    }
}
