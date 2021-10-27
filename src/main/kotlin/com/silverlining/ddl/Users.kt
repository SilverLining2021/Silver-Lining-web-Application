package com.silverlining.ddl

import org.jetbrains.exposed.sql.Table

object Users: Table("UserTable") {
    val id = integer("uid")
    val username = "username"
}