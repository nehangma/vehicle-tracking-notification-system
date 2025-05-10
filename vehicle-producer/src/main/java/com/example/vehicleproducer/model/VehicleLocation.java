package com.example.vehicleproducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleLocation {
    private String vehicleId;
    private double latitude;
    private double longitude;
    private LocalDateTime timestamp;
}
