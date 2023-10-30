package com.travos_fcm.plugins

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.FileInputStream


fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/send") {
            sendNotificationToDevice()
        }
    }
}

fun Application.initializeFirebaseApp() {
    val serviceAccount = FileInputStream("F:\\Ktor_Dojo\\travos_poc\\Travos_poc\\src\\main\\resources\\service_key.json")

    val options = FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build()

    FirebaseApp.initializeApp(options)
}

fun sendNotificationToDevice() {
    val deviceToken = "cJW6-dgTS7yhIVe_0TCQk3:APA91bGGlhSHtPVFvbOYioQr-geI2PA5SyrTZ9AnioKUoOrbOYxNeIXuwANZ9rb6THMm2jMdvjjTdDDyFTA4N9FvZL1ZWvl5jjCRa2YrDRAEm3ain-juRxFodefjYEQRFm_rYaApqFB1"
    val message: Message = Message.builder()
        .putData("score", "850")
        .putData("time", "2:45")
        .setToken(deviceToken)
        .build()

    val response = FirebaseMessaging.getInstance().send(message)
    println("Successfully sent message: $response")

}
