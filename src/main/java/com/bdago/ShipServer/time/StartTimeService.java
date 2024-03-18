package com.bdago.ShipServer.time;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Service
public class StartTimeService {

    private LocalDateTime start;
    private LocalDateTime dataStartTime = LocalDateTime.of(2022, 1, 1, 0, 0, 0);

    public LocalDateTime getStartLocalDateTime() {
        return start;
    }

    public LocalDateTime getDataStartTime() {
        LocalDateTime dateTimeWithoutNanos = this.dataStartTime.truncatedTo(ChronoUnit.SECONDS);
        return dateTimeWithoutNanos;
    }

    public String getDataStartTimeString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return this.dataStartTime.format(formatter);
    }

    public void setStartLocalDateTime(LocalDateTime start) {
        this.start = start;
    }

    public String getStartFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return start.format(formatter);
    }
}