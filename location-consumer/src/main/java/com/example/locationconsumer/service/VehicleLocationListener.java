package com.example.locationconsumer.service;

import com.example.locationconsumer.model.NotificationDTO;
import com.example.locationconsumer.model.VehicleLocation;
import com.example.locationconsumer.repository.VehicleLocationRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VehicleLocationListener {
    private final VehicleLocationRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(VehicleLocationListener.class);
    @Value("${email.to}")
    String email;
    @Autowired
    RestTemplate restTemplate;
    public VehicleLocationListener(VehicleLocationRepository repository) {
        this.repository = repository;
    }
    
    

    @KafkaListener(
        topics = "${vehicle.kafka.topic}",
        groupId = "location-consumer-group",
        containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(VehicleLocation location) {
    	logger.info("Received location update for vehicleId: {}", location.getVehicleId());
        logger.debug("Full payload: {}", location);

        repository.save(location);
        sendNotification(email, location.toString());
        
        logger.info("Saved location to MongoDB for vehicleId: {}", location.getVehicleId());
    }
    
    public void sendNotification(String email, String message) {
        String url = "http://notification-service/notifications";

        NotificationDTO notification = new NotificationDTO(
            email,
            message
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<NotificationDTO> request = new HttpEntity<>(notification, headers);

        ResponseEntity<String> response = restTemplate.exchange(
            url,
            HttpMethod.POST,
            request,
            String.class
        );

        // ✅ Log status code and body
        logger.info("Response Status Code: " + response.getStatusCode());
        logger.info("Response Body: " + response.getBody());
    }
}
