import io.zonky.test.db.postgres.embedded.EmbeddedPostgres
import org.flywaydb.core.Flyway
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jooq.codegen.GenerationTool
import org.jooq.meta.jaxb.Configuration
import org.jooq.meta.jaxb.Database
import org.jooq.meta.jaxb.Generate
import org.jooq.meta.jaxb.Generator
import org.jooq.meta.jaxb.Jdbc
import org.jooq.meta.jaxb.Target

plugins {
    java
    `java-test-fixtures`

    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"

    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "org.example.server"
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

    testFixturesApi("org.springframework.boot:spring-boot-starter-test")
    testFixturesApi("io.zonky.test:embedded-postgres:1.3.1")
    testFixturesApi("io.zonky.test:embedded-database-spring-test:2.1.1")
    testFixturesApi(enforcedPlatform("io.zonky.test.postgres:embedded-postgres-binaries-bom:14.3.0"))
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
        classpath("org.flywaydb:flyway-core:8.5.12")
        classpath("org.jooq:jooq-codegen:3.14.15")
        classpath("io.zonky.test:embedded-postgres:1.3.1")
        classpath(enforcedPlatform("io.zonky.test.postgres:embedded-postgres-binaries-bom:14.3.0"))
    }
}

tasks.create("generate") {
    EmbeddedPostgres.builder()
        .start().use { embeddedPostgres ->
            val userName = "postgres"
            val dbName = "postgres"
            val schema = "public"
            Flyway.configure()
                .locations("filesystem:$projectDir/src/main/resources/db/migration")
                .schemas(schema)
                .dataSource(embeddedPostgres.getDatabase(userName, dbName))
                .load()
                .migrate()
            GenerationTool.generate(
                Configuration().withGenerator(
                    Generator().withDatabase(
                        Database()
                            .withInputSchema(schema)
                    ).withGenerate(
                        Generate()
                    ).withTarget(
                        Target()
                            .withPackageName("org.example.template.domain.db")
                            .withDirectory("$projectDir/src/main/java/")
                    )
                ).withJdbc(
                    Jdbc().withUrl(embeddedPostgres.getJdbcUrl(userName, dbName))
                )
            )
        }
}
