plugins {
    java
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
}

group = "org.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.testcontainers:junit-jupiter")
    //add dependencies as needed
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.microsoft.sqlserver:mssql-jdbc:12.4.2.jre11")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
