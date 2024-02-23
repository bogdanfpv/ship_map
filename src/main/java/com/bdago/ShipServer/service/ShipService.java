package com.bdago.ShipServer.service;

import com.bdago.ShipServer.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShipService {

        private final ShipRepository shipRepository;

        @Autowired
        public ShipService(ShipRepository shipRepository) {
            this.shipRepository = shipRepository;
        }

        public List<String> getUniqueNamesInTimeframe(LocalDateTime start, LocalDateTime end) {
            return shipRepository.findUniqueNamesInTimeframe(start, end);
        }

        //TODO: getLastPosition from unique MMSI found between start end.
}
