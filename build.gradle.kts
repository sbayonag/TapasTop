/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    java
    id("java-library")
    id("maven-publish")
    id("eclipse")
    id("io.freefair.lombok") version "8.4"
    id("org.springframework.boot") version "3.2.2"
}

apply(plugin = "io.spring.dependency-management")

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
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    implementation("org.springframework.data:spring-data-rest-hal-explorer")
    implementation("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.16.1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.16.1")
    implementation("com.fasterxml.jackson.module:jackson-module-parameter-names:2.16.1")
    implementation("org.projectlombok:lombok:1.18.30")
    implementation("jakarta.xml.bind:jakarta.xml.bind-api:4.0.1")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client:3.3.2")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.2.1")
    compileOnly("org.hibernate:hibernate-jpamodelgen:6.4.2.Final")
    annotationProcessor("org.hibernate:hibernate-jpamodelgen:6.4.2.Final")
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

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.compilerArgs.add("--enable-preview")
    options.compilerArgs.add("-Xlint:preview")
}

tasks.withType<Javadoc>().configureEach {
    options.encoding = "UTF-8"
}

eclipse.jdt.file.withProperties {
    setProperty("org.eclipse.jdt.core.compiler.problem.enablePreviewFeatures", "enabled")
    setProperty("org.eclipse.jdt.core.compiler.problem.reportPreviewFeatures", "ignore")
}

tasks.withType<Test>().configureEach {
    jvmArgs("--enable-preview")
}

tasks.withType<JavaExec>().configureEach {
    jvmArgs("--enable-preview")
}
