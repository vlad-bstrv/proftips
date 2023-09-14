FROM openjdk:17
ADD /build/libs/proftips-0.0.1-SNAPSHOT.jar libs/backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]