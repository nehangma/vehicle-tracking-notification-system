package com.example.locationconsumer.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "vehicle_locations")
public class VehicleLocation {
	@Id
    private String vehicleId;
    private double latitude;
    private double longitude;
    private LocalDateTime timestamp;
}
