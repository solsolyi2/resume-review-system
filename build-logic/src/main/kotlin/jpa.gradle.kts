plugins {
    kotlin("jvm")
    kotlin("kapt")
    kotlin("plugin.allopen")
    kotlin("plugin.noarg")
    kotlin("plugin.jpa")
}

configure<org.jetbrains.kotlin.allopen.gradle.AllOpenExtension> {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

configure<org.jetbrains.kotlin.noarg.gradle.NoArgExtension> {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

val catalog = extensions.findByType<VersionCatalogsExtension>()?.named("libs")

dependencies {
    catalog?.let {
        add("implementation", it.findLibrary("spring-boot-starter-data-jpa").get())
        add("implementation", it.findLibrary("openfeign-querydsl-jpa").get())
        add("runtimeOnly", it.findLibrary("postgresql").get())
        add("implementation", it.findLibrary("postgresql").get())
        add("implementation", it.findLibrary("p6spy").get())
    }

    // openfeign-querydsl-apt 사용 시 Q 클래스 생성을 위한 kapt 설정
    kapt("io.github.openfeign.querydsl:querydsl-apt:7.0:jpa")
    kapt("jakarta.annotation:jakarta.annotation-api")
    kapt("jakarta.persistence:jakarta.persistence-api")
}

// querydsl Q 클래스 생성을 위한 kapt 설정
configure<org.jetbrains.kotlin.gradle.plugin.KaptExtension> {
    correctErrorTypes = true
}

// 생성된 Q 클래스가 컴파일에 포함되도록 설정
configure<SourceSetContainer> {
    named("main") {
        java.srcDir("build/generated/source/kapt/main")
    }
}

tasks.named("runKtlintCheckOverMainSourceSet") {
    dependsOn("kaptKotlin")
}
