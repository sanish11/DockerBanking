# Use an official Maven runtime as a parent image
FROM maven:3.8.4-openjdk-11-slim AS build

# Set the working directory
WORKDIR /app

# Copy the Maven project descriptor files
COPY pom.xml ./

# Resolve dependencies
RUN mvn dependency:go-offline

# Copy the entire project source
COPY src ./src

# Build the Java application (adjust the command based on your project)
RUN mvn clean package

# Stage 2: Create a minimal runtime image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app

# Copy the compiled artifact from the build stage
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.war ./app.war

# Expose port 8080 (adjust if your application listens on a different port)
EXPOSE 8080

# Command to run the Java application
CMD ["java", "-jar", "app.war"]
