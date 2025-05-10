package com.example.locationconsumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.locationconsumer.model.VehicleLocation;
import com.example.locationconsumer.repository.VehicleLocationRepository;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private VehicleLocationRepository repository;

    @GetMapping
    public List<VehicleLocation> getAllLocations() {
        logger.info("Fetching all vehicle locations from MongoDB");
        List<VehicleLocation> locations = repository.findAll();
        logger.debug("Fetched {} records", locations.size());
        return locations;
    }

    @GetMapping("/{vehicleId}")
    public List<VehicleLocation> getLocationsByVehicle(@PathVariable String vehicleId) {
        logger.info("Fetching locations for vehicleId: {}", vehicleId);
        List<VehicleLocation> results = repository.findByVehicleId(vehicleId);
        logger.debug("Found {} entries for vehicle {}", results.size(), vehicleId);
        return results;
    }
    
    @GetMapping("/{vehicleId}/latest")
    public VehicleLocation getLatestLocation(@PathVariable String vehicleId) {
        logger.info("Fetching latest location for vehicleId: {}", vehicleId);
        return repository.findFirstByVehicleIdOrderByTimestampDesc()
                .orElse(null);
    }

}
