import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    `java-test-fixtures`

    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"

    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"

    id("nu.studer.jooq") version "7.1.1"
    id("org.flywaydb.flyway") version "8.5.12"
}

group = "com.example.server"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.flywaydb:flyway-core")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    runtimeOnly("org.postgresql:postgresql")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.zonky.test:embedded-postgres:1.3.1")
    testImplementation("io.zonky.test:embedded-database-spring-test:2.1.1")
    testImplementation(enforcedPlatform("io.zonky.test.postgres:embedded-postgres-binaries-bom:14.3.0"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jooq:jooq-codegen:3.14.15")
        classpath("io.zonky.test:embedded-postgres:1.3.1")
        classpath(enforcedPlatform("io.zonky.test.postgres:embedded-postgres-binaries-bom:14.3.0"))
    }
}
