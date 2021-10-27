package com.silverlining.plugins

import com.silverlining.ddl.Users
import de.rtner.security.auth.spi.SimplePBKDF2
import io.ktor.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

/**
 * Lazily-loaded Database object.
 *
 * Refer to the database and use it with the following:
 *     import org.jetbrains.exposed.sql.transactions.transaction
 *     transaction(DB.db) {
 *        // your code here
 *     }
 */
object DB {
    val db_url = System.getProperty("user.dir") + "/data.db"
    val db by lazy {
        Database.connect(
            "jdbc:sqlite:$db_url",
            "org.sqlite.JDBC"
        )
    }
}

/**
 * Initialize database backend used for Silver Lining webapp.
 */
fun Application.configurationDB(){
    // force initialization of lazy DB
    transaction(DB.db) {
        // TODO Check that we aren't overwriting the existing `Users` database
        SchemaUtils.create(Users)

        // TODO: Check user doesn't already exist
        val inserted = Users.insert {
            it[username] = "test"
            it[phash] = SimplePBKDF2().deriveKeyFormatted("hunter2")
        }
        println("created user \"test\" with password \"hunter2\" and uid ${inserted[Users.id]}")
    }
}