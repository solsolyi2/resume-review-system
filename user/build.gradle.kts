plugins {
    id("bootstrap")
    id("core")
    id("jpa")
}

dependencies {

    implementation(libs.spring.boot.starter.validation)

    runtimeOnly("com.h2database:h2")

    testImplementation(libs.spring.boot.starter.test)
    testImplementation(libs.kotlin.test.junit5)
    testImplementation(libs.kotest.runner.junit5)
    testImplementation(libs.kotest.assertions.core)
    testImplementation(libs.mockk)
    testRuntimeOnly(libs.junit.platform.launcher)
}
