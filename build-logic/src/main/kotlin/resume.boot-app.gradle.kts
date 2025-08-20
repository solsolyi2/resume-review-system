plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
//    kotlin("plugin.jpa")
    kotlin("plugin.allopen")
    kotlin("plugin.spring")
    kotlin("jvm")

}

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

kotlin {
    jvmToolchain(21)
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}



tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
        showStandardStreams = true
    }
}
