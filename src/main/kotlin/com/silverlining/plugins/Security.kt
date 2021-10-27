package com.silverlining.plugins


import com.silverlining.UserSession
import com.silverlining.ddl.Users
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.response.*
import org.jetbrains.exposed.sql.Query
import org.jetbrains.exposed.sql.SqlExpressionBuilder
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction


fun Application.configureSecurity() {
    install(Authentication) {
        form("auth-form") {
            userParamName = "username"
            passwordParamName = "password"

            validate { credentials ->
                var output: Principal? = null;

                transaction(DB.db) {
                    val matching = Users.select{Users.username eq credentials.name}

                    if (matching.count() < 1) {
                        println ("no matching user found")
                        null
                    } else {
                        val user = matching.elementAt(0)
                        println("matched user: ${user[Users.username]}")

                        val uid = user[Users.id]

                        // TODO: Hash w/ PBKDF2
                        val inputHashed = credentials.password
                        val truth = user[Users.phash]

                        if (inputHashed == truth) {
                            // TODO: Also set UID and whatnot
                            output = UserIdPrincipal(credentials.name)
                        } else {
                            // failure to authenticate
                        }
                    }
                }
                output
            }
        }
        session<UserSession> {
            validate {
                    session -> session /* TODO: Unstub this */
            }
            challenge {
                call.respondRedirect("/login")
            }
        }
    }

}
