FROM openjdk:17-jdk-slim
WORKDIR /App

COPY target/Point-of-sale-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
