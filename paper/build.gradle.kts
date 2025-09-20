plugins {
    `maven-publish`
    signing
    kotlin("jvm") version "2.1.21"
}

repositories {
    mavenCentral()
    maven("https://libraries.minecraft.net/")
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.7-R0.1-SNAPSHOT")
    compileOnly("org.jetbrains:annotations:21.0.1")
    api(project(":triumph-gui")) {
        exclude(group = "net.kyori")
    }
    implementation(kotlin("stdlib-jdk8"))
}

license {
    header = rootProject.file("LICENSE")
    encoding = "UTF-8"
    mapping("java", "JAVADOC_STYLE")
    include("**/*.java")
}

val javaComponent: SoftwareComponent = components["java"]

java {
    disableAutoTargetJvm()
}

tasks {

    val sourcesJar by creating(Jar::class) {
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
    }

    val javadocJar by creating(Jar::class) {
        dependsOn.add(javadoc)
        archiveClassifier.set("javadoc")
        from(javadoc)
    }

    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
}
kotlin {
    jvmToolchain(21)
}