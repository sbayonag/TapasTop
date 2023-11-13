/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    `java-library`
    `maven-publish`
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-data-jpa:3.1.4")
    api("org.springframework.boot:spring-boot-starter-data-rest:3.1.4")
    api("org.springframework.data:spring-data-rest-hal-explorer:4.1.5")
    api("org.springframework.boot:spring-boot-configuration-processor:3.1.4")
    api("org.springframework.boot:spring-boot-starter-validation:3.1.4")
    api("com.fasterxml.jackson.core:jackson-databind:2.15.3")
    api("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.3")
    api("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.15.3")
    api("com.fasterxml.jackson.module:jackson-module-parameter-names:2.15.3")
    api("org.projectlombok:lombok:1.18.30")
    api("jakarta.xml.bind:jakarta.xml.bind-api:4.0.1")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client:3.2.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.1.4")
    compileOnly("org.hibernate.orm:hibernate-jpamodelgen:6.3.1.Final")
    annotationProcessor("org.hibernate:hibernate-jpamodelgen:6.3.1.Final")
}

group = "com.TapasTop"
version = "0.0.1-SNAPSHOT"
description = "server"
java.sourceCompatibility = JavaVersion.VERSION_21

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
    options.compilerArgs.add("--enable-preview")
    options.compilerArgs.add("-Xlint:preview")
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}
