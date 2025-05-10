package com.example.vehicleproducer.scheduler;

import com.example.vehicleproducer.service.VehicleLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduler that sends vehicle location data at regular intervals.
 */
@Component
@RequiredArgsConstructor
public class VehicleLocationScheduler {

    private final VehicleLocationService vehicleLocationService;

    /**
     * Send data every 5 seconds.
     */
    @Scheduled(fixedRate = 5000)
    public void scheduleVehicleLocation() {
        vehicleLocationService.sendVehicleLocation();
    }
}
