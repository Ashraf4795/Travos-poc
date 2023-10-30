package com.travos_fcm

import com.travos_fcm.plugins.*
import com.travos_fcm.service.fcm.initializeFirebaseApp
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    initializeFirebaseApp()
    configureRouting()
}
