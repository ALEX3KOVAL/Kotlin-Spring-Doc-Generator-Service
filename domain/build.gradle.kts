plugins {
    kotlin("jvm")
}

group = "ru.alex3koval.docGenerator"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.bundles.apache)

    implementation("io.projectreactor:reactor-core:3.4.40")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
