import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.gorylenko.gradle-git-properties") version "2.2.4" apply false
    id("io.spring.dependency-management") version "1.0.10.RELEASE" apply true
    id("org.springframework.boot") version "2.4.2" apply false
    kotlin("jvm") version "1.4.21" apply false
    kotlin("plugin.spring") version "1.4.21" apply false
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
        maven { url = uri("https://repo.spring.io/milestone") }
    }

    dependencyManagement {
        imports {
            // TODO - This can be removed once spring-cloud-dependencies 2020.0.1 has been released
            // https://repo.spring.io/release/org/springframework/cloud/spring-cloud-dependencies/
            // https://github.com/spring-cloud/spring-cloud-release/wiki/Spring-Cloud-2020.0-Release-Notes
            mavenBom("org.springframework.cloud:spring-cloud-config-dependencies:3.0.1")
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:2020.0.0")
        }

        dependencies {
            dependency("io.springfox:springfox-boot-starter:3.0.0")
        }
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_15.toString()
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
