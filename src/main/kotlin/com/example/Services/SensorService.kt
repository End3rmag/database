package com.example.Services

import com.example.dao.Sensors.SensordaoFacade
import com.example.dao.Sensors.sensordao
import com.example.models.Sensor

class SensorService(private val SensorRepository:SensordaoFacade) {
    suspend fun createSensor(sensor: Sensor):Sensor? {
        return SensorRepository.createSensor(sensor)
    }
    suspend fun findByModel(model:String):Sensor? {
        return SensorRepository.finByModel(model)
    }
}
val sensorService=SensorService(sensordao)