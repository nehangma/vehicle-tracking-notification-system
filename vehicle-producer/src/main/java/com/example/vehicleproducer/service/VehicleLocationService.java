package com.example.vehicleproducer.service;

import com.example.vehicleproducer.model.VehicleLocation;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

/**
 * This service generates random vehicle location data and sends it to Kafka.
 */
@Service
@RequiredArgsConstructor
public class VehicleLocationService {

	    private final KafkaTemplate<String, VehicleLocation> vehicleLocationKafkaTemplate;


    // You can configure this topic name in application.yml later
    private static final String LOCATION_TOPIC_NAME = "vehicle-locations";


    private final Random random = new Random();

    /**
     * Simulates a single vehicle location update and sends to Kafka.
     */
    public void sendVehicleLocation() {
        // Generate fake data
        String vehicleId = UUID.randomUUID().toString();
        double latitude = 12.90 + (random.nextDouble() * 0.1);  // Bangalore-ish
        double longitude = 77.50 + (random.nextDouble() * 0.1);
        LocalDateTime timestamp = LocalDateTime.now();

        VehicleLocation location = new VehicleLocation(vehicleId, latitude, longitude, timestamp);
        // Log to console
        System.out.println("Sending: " + location);

        // Send to Kafka
        vehicleLocationKafkaTemplate.send(LOCATION_TOPIC_NAME, vehicleId, location);
    }
}
