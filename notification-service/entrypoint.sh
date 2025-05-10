#!/bin/sh

EUREKA_URL=${SPRING_CLOUD_EUREKA_CLIENT_SERVICEURL_DEFAULTZONE:-http://eureka-server:8761/eureka}

echo "Waiting for Eureka at $EUREKA_URL..."



until curl -s "$EUREKA_URL" > /dev/null; do
  echo "Eureka not ready at $EUREKA_URL. Retrying in 5s..."
  sleep 5
done

echo "Eureka is up! Starting Notification Service..."
exec java -jar app.jar
