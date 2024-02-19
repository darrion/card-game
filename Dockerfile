# Java 17
FROM amazoncorretto:17-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY build/libs/acmecardgame.jar /app/app.jar

# Specify the command to run your application
CMD ["java", "-jar", "app.jar"]
