FROM openjdk:21-jdk-alpine

LABEL maintainer="ErenJaeger"

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
