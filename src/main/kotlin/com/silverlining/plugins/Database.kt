package com.silverlining.plugins

import com.silverlining.ddl.Users
import io.ktor.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction


fun Application.configurationDB(){
    // Database definition
    val db_url = System.getProperty("user.dir") + "/data.db"
    Database.connect(
        "jdbc:sqlite:$db_url",
        "org.sqlite.JDBC"
    )

    transaction {
        SchemaUtils.create(Users)
    }
}