FROM eclipse-temurin:17-jdk
WORKDIR /App

COPY target/Point-of-sale-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
