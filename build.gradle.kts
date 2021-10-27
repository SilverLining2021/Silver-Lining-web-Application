val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.5.31"
}

group = "com.silverlining"
version = "0.0.1"

application {
    mainClass.set("com.silverlining.ApplicationKt")
}

repositories {
    mavenCentral()
}

// dependencies declarations
dependencies{
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-auth:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-jackson:$ktor_version")
    implementation("io.ktor:ktor-gson:$ktor_version")


    // https://mvnrepository.com/artifact/org.ktorm/ktorm-core
    implementation("org.ktorm:ktorm-core:3.4.1")

    // https://mvnrepository.com/artifact/mysql/mysql-connector-java
    implementation("mysql:mysql-connector-java:8.0.26")
    implementation("org.ktorm:ktorm-support-sqlite:3.4.1")
    implementation("org.xerial:sqlite-jdbc:3.34.0")


    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")

    // https://mvnrepository.com/artifact/org.freemarker/freemarker
    implementation("io.ktor:ktor-freemarker:$ktor_version")

    // Html builder & CSS wrapper from the Ktor - CSS DSL
    // https://ktor.io/docs/css-dsl.html#use_css
    implementation ("io.ktor:ktor-html-builder:$ktor_version")

    implementation("com.squareup.okhttp3:okhttp:4.9.0")
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")


}