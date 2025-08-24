plugins {
    id("ktlint")
    id("ktlintHook")
}

allprojects {
    apply {
        plugin("common")
        plugin("ktlint")
    }
}
