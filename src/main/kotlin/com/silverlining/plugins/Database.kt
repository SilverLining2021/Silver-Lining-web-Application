package com.silverlining.plugins

import io.ktor.application.*
import org.ktorm.database.Database
import org.ktorm.support.sqlite.SQLiteDialect

fun Application.configurationDB(){

    // Database definition
    // Using libraries from Ktorm:
    // https://mvnrepository.com/artifact/org.ktorm/ktorm-core

    // Using libraries from MySQL Connector:
    // https://mvnrepository.com/artifact/mysql/mysql-connector-java

//    val database = Database.connect(
//        url = "jdbc:mysql://localhost:3306/Users",
//        driver = "com.mysql.cj.jdbc.Driver",
//        user = "root",
//        password = "password"
//    )

    val database = Database.connect("jdbc:sqlite:sqlite3.db")

}