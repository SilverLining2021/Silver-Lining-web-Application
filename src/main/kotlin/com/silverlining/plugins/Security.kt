package com.silverlining.plugins


import com.silverlining.UserSession
import com.silverlining.ddl.Users
import de.rtner.security.auth.spi.SimplePBKDF2
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.response.*
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

                        val input = credentials.password
                        val truth = user[Users.phash]

                        if (SimplePBKDF2().verifyKeyFormatted(truth, input)) {
                            // TODO: Also set UID and whatnot
                            println("successfully logged in with valid PBKDF2 hash")
                            output = UserIdPrincipal(credentials.name)
                        } else {
                            // failure to authenticate
                            println("Failed to authenticate user")
                            null
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
