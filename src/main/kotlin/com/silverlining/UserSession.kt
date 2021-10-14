package com.silverlining

import io.ktor.auth.*

/**
 * Represents an authenticated user session.
 */
data class UserSession(val uid: Int, val name: String, val count: Int) : Principal