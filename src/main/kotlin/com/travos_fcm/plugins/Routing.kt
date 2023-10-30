package com.travos_fcm.plugins

import com.travos_fcm.service.fcm.sendNotificationToDevice
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/send") {
            val token = call.request.queryParameters["token"]
            token?.let {
                if (it.isNotBlank()) {
                    sendNotificationToDevice(token, mapOf(
                        Pair("from","ktor_web_app"),
                        Pair("Author","ashraf.hassan@careem.com"),
                        Pair("Time",System.currentTimeMillis().toString()),
                    ))
                }
            }
        }
    }
}

