plugins {
    kotlin("jvm") version "2.0.20"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

tasks.shadowJar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
}

dependencies {
    implementation("io.grpc:grpc-netty-shaded:1.58.0")
    implementation("io.grpc:grpc-protobuf:1.58.0")
    implementation("io.grpc:grpc-stub:1.58.0")

    implementation("com.rabbitmq:amqp-client:5.18.0")

    implementation("org.postgresql:postgresql:42.7.2")
    implementation("com.zaxxer:HikariCP:5.0.1")

    implementation("org.jetbrains.exposed:exposed-core:0.58.0")
    implementation("org.jetbrains.exposed:exposed-dao:0.58.0")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.58.0")

    implementation("org.slf4j:slf4j-api:2.0.0")

    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("com.google.protobuf:protobuf-java:4.28.2")

    implementation("com.rabbitmq:amqp-client:5.24.0")

    implementation("org.example:grpc-movie-contract:1.0-SNAPSHOT")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}