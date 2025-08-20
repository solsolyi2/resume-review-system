plugins {

}

allprojects {
    group = "com.hexagonal"
    version = "0.0.1-SNAPSHOT"
}

tasks.withType<Test> {
    useJUnitPlatform()
}
