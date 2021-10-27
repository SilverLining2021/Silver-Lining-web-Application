package com.silverlining.plugins

import com.silverlining.ddl.Users
import com.silverlining.ddl.Users.phash
import com.silverlining.ddl.Users.username
import io.ktor.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.transactions.transaction

object DB {
    val db_url = System.getProperty("user.dir") + "/data.db"
    val db by lazy {
        Database.connect(
            "jdbc:sqlite:$db_url",
            "org.sqlite.JDBC"
        )
    }
}

fun Application.configurationDB(){
    // Database definition

    // force initialization of lazy DB
    transaction(DB.db) {
        SchemaUtils.create(Users)

        // TODO: Check user doesn't already exist
        val inserted = Users.insert {
            it[username] = "test"
            it[phash] = "testhash"
        }
        println("created user with ID ${inserted[Users.id]}")
    }
}