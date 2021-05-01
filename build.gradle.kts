import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.gorylenko.gradle-git-properties") version "2.2.4" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply true
    id("org.springframework.boot") version "2.4.5" apply false
    kotlin("jvm") version "1.4.32" apply false
    kotlin("plugin.spring") version "1.4.32" apply false
}

allprojects {
    group = "com.gorlah"
    version = "0.0.1-SNAPSHOT"
}

subprojects {
    apply {
        plugin("com.gorylenko.gradle-git-properties")
        plugin("io.spring.dependency-management")
    }

    repositories {
        mavenCentral()
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:2020.0.2")
        }

        dependencies {
            dependency("io.springfox:springfox-boot-starter:3.0.0")
            dependency("org.springframework.vault:spring-vault-core:2.3.2")
        }
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_15.toString()
        targetCompatibility = JavaVersion.VERSION_15.toString()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = JavaVersion.VERSION_15.toString()
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
