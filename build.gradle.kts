import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.3.71"
    val springVersion = "2.2.6.RELEASE"
    id("org.springframework.boot") version springVersion
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
}

group = "com.bst"
version = "0.0.1"
java.apply {
    sourceCompatibility = JavaVersion.VERSION_13
    targetCompatibility = JavaVersion.VERSION_13
}

val developmentOnly: Configuration by configurations.creating
configurations {
    runtimeClasspath {
        extendsFrom(developmentOnly)
    }
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    maven(url = "https://dl.bintray.com/pelenthium/maven")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.security:spring-security-oauth2-client")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    implementation("io.jsonwebtoken:jjwt:0.9.1")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.github.microutils:kotlin-logging:1.7.6")

    implementation("org.springdoc:springdoc-openapi-kotlin:1.3.1")
    implementation("org.springdoc:springdoc-openapi-ui:1.3.1")

    runtimeOnly("org.postgresql:postgresql")
    compileOnly("org.projectlombok:lombok")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = JavaVersion.VERSION_12.majorVersion
    }
}

tasks {
    test {
        useJUnitPlatform()
    }
}
