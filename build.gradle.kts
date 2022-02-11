plugins {
    kotlin("jvm")
    `java-library`
    `maven-publish`
    signing
}

repositories {
    mavenCentral()
    maven("https://repo.spongepowered.org/repository/maven-public/")
}

val configurateVersion: String by project
val guava: String by project

version = "0.1.0-SNAPSHOT"
group = "org.anvilpowered"

dependencies {
    api("org.spongepowered:configurate-core:$configurateVersion")
    api("org.spongepowered:configurate-hocon:$configurateVersion")
    api("com.google.inject:guice:5.0.1")
    api(guava)
}

java {
    withJavadocJar()
    withSourcesJar()
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
        kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "registry"
            from(components["java"])
            pom {
                name.set("registry")
                description.set("")
                url.set("https://github.com/AnvilPowered/Registry")
                scm {
                    url.set("https://github.com/AnvilPowered/Registry")
                }
                licenses {
                    license {
                        name.set("GNU LESSER GENERAL PUBLIC LICENSE Version 3")
                        url.set("https://www.gnu.org/licenses/lgpl-3.0.html")
                        distribution.set("repo")
                    }
                }
                developers {
                    developer {
                        id.set("alexstaeding")
                        name.set("Alexander Staeding")
                        organization.set("AnvilPowered")
                    }
                    developer {
                        id.set("STG-Allen")
                        name.set("Jacob Allen")
                        organization.set("AnvilPowered")
                    }
                }
            }
        }
    }
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}
