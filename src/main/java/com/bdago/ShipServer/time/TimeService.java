package com.bdago.ShipServer.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TimeService {

    @Autowired
    private StartTimeService startTimeService;

    public LocalDateTime getTime() {
        Duration elapsed = Duration.between(startTimeService.getStartLocalDateTime(), LocalDateTime.now());
        LocalDateTime current = startTimeService.getDataStartTime().plus(elapsed);
        LocalDateTime currentWithoutNanos = current.truncatedTo(ChronoUnit.SECONDS);

        return currentWithoutNanos;
    }

    public String getCurrentTime() {
        Duration elapsed = Duration.between(startTimeService.getStartLocalDateTime(), LocalDateTime.now());
        LocalDateTime current = startTimeService.getDataStartTime().plus(elapsed);
        LocalDateTime currentWithoutNanos = current.truncatedTo(ChronoUnit.SECONDS);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentFormatted = currentWithoutNanos.format(formatter);

        return currentFormatted;
    }
}
