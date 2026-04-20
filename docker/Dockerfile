# Use the official OpenJDK base image
FROM eclipse-temurin:21.0.7_6-jdk
# LABEL authors="valfrido"

# Create directory inside the container
RUN mkdir /opt/app
# Set the working directory inside the container
WORKDIR /opt/app

# Copy the built jar file into the container
ARG JAR_VERSION
COPY ../target/demo-integration-api-${JAR_VERSION}.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]