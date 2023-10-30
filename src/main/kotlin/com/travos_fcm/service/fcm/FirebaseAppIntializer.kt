package com.travos_fcm.service.fcm

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import io.ktor.server.application.*
import java.io.File
import java.io.FileInputStream

fun Application.initializeFirebaseApp() {
    //TODO: replace this absolute path with your machine path
    val serviceAccount = FileInputStream(File("\\Ktor_Dojo\\travos_poc\\Travos_poc\\src\\main\\kotlin\\com\\travos_fcm\\service\\fcm\\service_key.json"))
    val options = FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build()
    FirebaseApp.initializeApp(options)
}
