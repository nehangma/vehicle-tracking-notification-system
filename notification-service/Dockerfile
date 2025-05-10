# Use official OpenJDK as base image
FROM openjdk:17-jdk-slim

# App will be added to this directory inside the container
WORKDIR /app

# Copy Maven built JAR to the image
COPY target/notification-service-0.0.1-SNAPSHOT.jar app.jar

# Install curl
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

COPY entrypoint.sh /entrypoint.sh

RUN chmod +x /entrypoint.sh



# Set environment variables if needed
ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://eureka-server:8761/eureka


# Run the app
# ENTRYPOINT ["java", "-jar", "app.jar"]
ENTRYPOINT ["/entrypoint.sh"]
