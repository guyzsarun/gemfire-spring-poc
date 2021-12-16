ARG base_image=gradle:6.9.1-jdk11-alpine
ARG runtime=openjdk:8-jre-slim
FROM ${base_image} AS build


COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM ${runtime}

EXPOSE 8080

WORKDIR /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java","-jar","/app/spring-boot-application.jar"]