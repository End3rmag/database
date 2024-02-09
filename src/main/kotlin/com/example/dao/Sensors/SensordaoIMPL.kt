package com.example.dao.Sensors

import com.example.dao.databasefactory.dbQuery
import com.example.models.Sensor
import com.example.models.Sensors
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select

class SensordaoIMPL: SensordaoFacade {
    private fun resultRowToSensor(row: ResultRow) = Sensor(id =row[Sensors.id], sensor_model = row[Sensors.sensor_model], sensor_type_id = row[Sensors.sensor_type_id], parameter_type_id = row[Sensors.parameter_type_id] )

    override suspend fun createSensor(sensor: Sensor): Sensor? =dbQuery {
        val insertStatement = Sensors.insert {
            it[Sensors.sensor_model]=sensor.sensor_model
            it[Sensors.sensor_type_id]=sensor.sensor_type_id
            it[Sensors.id]=sensor.id
            it[Sensors.parameter_type_id]=sensor.parameter_type_id
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToSensor)
    }

    override suspend fun finByModel(model: String): Sensor? = dbQuery {
        Sensors.select {
            Sensors.sensor_model eq model }.map(::resultRowToSensor).singleOrNull()



    }


}
val sensordao = SensordaoIMPL()
