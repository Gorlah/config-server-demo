plugins {
    id("org.springframework.boot")
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":projects:commons-kotlin"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks {
    bootJar { enabled = false }
    jar { enabled = true }
}
