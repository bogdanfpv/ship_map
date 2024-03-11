package com.bdago.ShipServer.time;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class StartTimeService {

    private LocalDateTime start;
    private String dataStartTime = "2022-01-01 00:00:00";

    public LocalDateTime getStartLocalDateTime() {
        return start;
    }

    public LocalDateTime getDataStartTimeLocalDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dataStartTime, formatter);
        return dateTime;
    }

    public void setStartLocalDateTime(LocalDateTime start) {
        this.start = start;
    }

    public String getStartFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return start.format(formatter);
    }
}