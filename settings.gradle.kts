pluginManagement {
    plugins {
        kotlin("jvm") version "1.9.10"
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "triumph-gui"

include("core")
findProject(":core")?.name = "triumph-gui"

include("paper")
findProject(":paper")?.name = "triumph-gui-paper"

// include("test-plugin")
