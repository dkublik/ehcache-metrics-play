plugins {
	java
	groovy
	id("org.springframework.boot") version "2.1.6.RELEASE"
}

apply(plugin = "io.spring.dependency-management")

group = "pl.dk.learn"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

configure<JavaPluginConvention> {
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
	annotationProcessor("org.projectlombok:lombok")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-cache")
	implementation("net.sf.ehcache:ehcache")

	implementation("org.codehaus.groovy:groovy-all:2.5.7")
	implementation("org.projectlombok:lombok")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.spockframework:spock-spring:1.3-groovy-2.5")
	testImplementation("org.awaitility:awaitility-groovy:3.1.6")
}

tasks.withType(Wrapper::class.java).configureEach {
	gradleVersion = "5.5.1"
}
