package com.silverlining.plugins

import com.silverlining.ddl.Users
import de.rtner.security.auth.spi.SimplePBKDF2
import io.ktor.application.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.vendors.currentDialect

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
        // Only create new Users tables if it doesn't already exist
        if (!currentDialect.tableExists(Users)) {
            SchemaUtils.create(Users)
        }

        val existingUsers = Users.select { Users.username eq "test" }
        if (existingUsers.count() == 0L) {
            val inserted = Users.insert {
                it[username] = "test"
                it[phash] = SimplePBKDF2().deriveKeyFormatted("hunter2")
            }
            log.debug("created user 'test' with password 'hunter2' and uid ${inserted[Users.id]}")
        } else {
            log.debug("Skipped creating test user because they already exist")
        }
    }
}