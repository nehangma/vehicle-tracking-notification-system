# Use official OpenJDK as base image
FROM openjdk:17-jdk-slim

# App will be added to this directory inside the container
WORKDIR /app

# Copy Maven built JAR to the image
COPY target/eureka-server-0.0.1-SNAPSHOT.jar app.jar


# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
