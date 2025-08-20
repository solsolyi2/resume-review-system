plugins {
//    id("org.springframework.boot")
//    id("io.spring.dependency-management")
    kotlin("plugin.spring")
    kotlin("jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

kotlin {
    jvmToolchain(21)
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
