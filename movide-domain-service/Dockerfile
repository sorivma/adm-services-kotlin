FROM gradle:jdk21 AS library-build

WORKDIR /app

COPY ../grpc-movie-contract /app

RUN gradle publishToMavenLocal

FROM gradle:jdk21 AS app-build

WORKDIR /app

COPY ../movide-domain-service /app

COPY --from=library-build /root/.m2 /root/.m2

RUN gradle shadowJar --no-daemon

FROM eclipse-temurin:21-alpine

WORKDIR /app

COPY --from=app-build /app/build/libs/*.jar /app/domain-service.jar

EXPOSE 9090

CMD ["java", "-jar", "/app/domain-service.jar"]
