package com.travos_fcm.service.fcm

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message

fun sendNotificationToDevice(deviceToken: String, payload: Map<String, String>): String {
    val message: Message = Message.builder().apply {
        payload.forEach { (key, value) ->
            putData(key, value)
            setToken(deviceToken)
        }
    }.build()

    val response = FirebaseMessaging.getInstance().send(message)
    println("Successfully sent message: $response")

    return response
}
