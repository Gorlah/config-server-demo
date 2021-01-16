plugins {
	kotlin("jvm")
	kotlin("plugin.spring")
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.springframework.cloud:spring-cloud-config-server")
	implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}
