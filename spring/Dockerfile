# Use OpenJDK 17 as base image
FROM eclipse-temurin:17-jdk-alpine AS build

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY spring/mvnw spring/mvnw
COPY spring/.mvn spring/.mvn
COPY spring/pom.xml spring/pom.xml

# Download dependencies
WORKDIR /app/spring
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY spring/src src

# Build the application
RUN ./mvnw clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy the built JAR from build stage
COPY --from=build /app/spring/target/*.jar app.jar

# Expose port (Render will set PORT environment variable)
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]