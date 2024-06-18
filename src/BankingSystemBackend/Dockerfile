# Use an official OpenJDK runtime as a parent image
FROM openjdk:8-jdk-alpine

# Create a volume to hold application data
VOLUME /tmp

# Add a label to mark the maintainer of the image
LABEL maintainer="sanis.mrzan@gmail.com"

# Argument for JVM options
ARG JAVA_OPTS

# Environment variable to hold JVM options
ENV JAVA_OPTS=$JAVA_OPTS

# Copy the WAR file into the container at /app.war
COPY target/backend-0.0.1-SNAPSHOT.war /app.war

# Expose port 8080 (adjust if your application listens on a different port)
EXPOSE 8080

# Run the application using java -jar command
CMD ["java", "-jar", "/app.war"]
