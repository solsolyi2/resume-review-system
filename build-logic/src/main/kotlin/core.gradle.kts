import org.gradle.kotlin.dsl.named
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
}

val catalog = extensions.findByType<VersionCatalogsExtension>()?.named("libs")

dependencies {
    catalog?.let {
        add("implementation", it.findLibrary("kotlin-stdlib").get())
        add("implementation", it.findLibrary("kotlin-reflect").get())
        add("implementation", it.findLibrary("jackson-module-kotlin").get())
        add("implementation", it.findLibrary("kotlin-logging").get())

        add("testImplementation", it.findLibrary("spring-boot-starter-test").get())
        add("testImplementation", it.findLibrary("kotlin-test-junit5").get())
        add("testImplementation", it.findLibrary("kotest-runner-junit5").get())
        add("testImplementation", it.findLibrary("kotest-assertions-core").get())
        add("testImplementation", it.findLibrary("mockk").get())
        add("testImplementation", it.findLibrary("instancio-junit").get())
        add("testRuntimeOnly", it.findLibrary("junit-platform-launcher").get())
    }
}

tasks {
    named<BootJar>("bootJar").configure {
        enabled = false
    }

    named<Jar>("jar").configure {
        enabled = true
    }
}
