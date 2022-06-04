import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    `java-test-fixtures`

    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"

    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "com.example.server"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    api("com.example.api:api-v0")
    api(project(":application"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    runtimeOnly("org.postgresql:postgresql")

    testFixturesApi(testFixtures(project(":application")))

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
