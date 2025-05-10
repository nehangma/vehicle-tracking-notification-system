package com.example.locationconsumer.repository;

import com.example.locationconsumer.model.VehicleLocation;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleLocationRepository extends MongoRepository<VehicleLocation, String> {
    // You can add custom queries here later if needed
	List<VehicleLocation> findByVehicleId(String vehicleId);
	
	Optional<VehicleLocation> findFirstByVehicleIdOrderByTimestampDesc();
}
