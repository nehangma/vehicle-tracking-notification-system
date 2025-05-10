# vehicle-tracking-notification-system
This is a comprehensive microservices-based application designed to track real-time vehicle locations and send notifications based on specified conditions. The system is built using Spring Boot, Kafka, MongoDB, and Docker, with Eureka for service discovery

Key Components:
Vehicle Location Producer: Sends real-time vehicle location data to Kafka.

Location Consumer: Consumes location data from Kafka, saves it in MongoDB, and triggers notifications based on conditions.

Notification Service: Listens to notification events and sends email notifications using a predefined template.

Eureka Server: Manages service discovery for all microservices.

Kafka & Zookeeper: Manages real-time messaging between services.

MongoDB: Stores historical vehicle location data.

Docker & Docker Compose: Containerizes each microservice for easy deployment.

Features:
Microservices architecture with Eureka service discovery.

Real-time data processing using Kafka.

Notification service (email or WhatsApp).

Centralized configuration and service registration.

Scalability with Docker Compose.

Technologies Used:
Backend: Java 17, Spring Boot 3.x, Spring Cloud (Eureka)

Messaging: Kafka, Zookeeper

Database: MongoDB

Containerization: Docker, Docker Compose

Configuration Management: Spring Cloud Config (optional)

Logging: Log4j2

Why This Project?
This project demonstrates your expertise in:

Building scalable microservices.

Real-time data processing with Kafka.

Advanced container management using Docker.

Service discovery with Eureka.
