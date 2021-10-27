package com.silverlining.ddl

import org.jetbrains.exposed.sql.Table

// Represents the users of the SilverLining web application
object Users: Table("UserTable") {
    // unique user id
    val id = integer("id").autoIncrement()
    // username
    val username = varchar("username", 64)
    // password hash, length of up to 128 bytes
    val phash = char("phash", 128)

    override val primaryKey = PrimaryKey(id)
}