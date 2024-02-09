package com.example.plugins

import com.example.Services.SensorService
import com.example.Services.sensorService
import com.example.routes.sensorRouting
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        sensorRouting(sensorService = sensorService)
    }
}
