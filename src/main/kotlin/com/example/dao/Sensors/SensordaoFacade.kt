package com.example.dao.Sensors

import com.example.models.Sensor

interface SensordaoFacade {
    suspend fun createSensor(sensor: Sensor):Sensor?
    suspend fun finByModel(model: String):Sensor?

}