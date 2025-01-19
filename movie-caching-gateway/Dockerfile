FROM gradle:jdk21 AS library-build

WORKDIR /app

COPY ../grpc-movie-contract /app

RUN gradle publishToMavenLocal

FROM gradle:jdk21 AS app-build

WORKDIR /app

COPY ../movie-caching-gateway /app

COPY --from=library-build /root/.m2 /root/.m2

RUN gradle bootJar --no-daemon

FROM eclipse-temurin:21-alpine

WORKDIR /app

COPY --from=app-build /app/build/libs/*.jar /app/gateway.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/gateway.jar"]