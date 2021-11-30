FROM maven:3.8.4-jdk-11-slim AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM openjdk:11.0-jre-slim

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/gemfire-backend-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "gemfire-backend-0.0.1-SNAPSHOT.jar"]