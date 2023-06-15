FROM openjdk:11-jdk-slim-buster
COPY build/libs/office-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]