rootProject.name = "resume-review-system"

pluginManagement {
    includeBuild("build-logic")
    plugins {
        id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    }
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}



include(
        "user",
        "resume",
        "review",
        "company",
        "bootstrap"
)
