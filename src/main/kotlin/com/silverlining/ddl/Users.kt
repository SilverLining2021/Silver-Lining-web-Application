package com.silverlining.ddl

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

// Represents the users of the SilverLining web application
object Users: Table("Users") {
    // unique user id
    val id: Column<Int> = integer("id").autoIncrement()
    // username
    val username: Column<String> = varchar("username", 64)
    // password hash, length of up to 128 bytes
    val phash: Column<String> = char("phash", 128)

    override val primaryKey = PrimaryKey(id)
}