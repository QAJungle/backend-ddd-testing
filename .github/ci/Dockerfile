FROM openjdk:17

COPY infrastructure-rest/build/libs/infrastructure-rest-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=ci","app.jar"]