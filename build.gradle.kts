val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val exposed_version: String by project
val pbkdf_version: String by project

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

    // ORM for Kotlin
    // https://github.com/JetBrains/Exposed
    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
    // SQLite driver
    // https://github.com/xerial/sqlite-jdbc
    implementation("org.xerial:sqlite-jdbc:3.36.0.3")

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

    // https://github.com/m9aertner/PBKDF2 or https://mvnrepository.com/artifact/de.rtner/PBKDF2
    implementation( "de.rtner:PBKDF2:$pbkdf_version" )

    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlin_version")
}