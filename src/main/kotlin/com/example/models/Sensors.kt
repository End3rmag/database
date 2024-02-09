package com.example.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Sensor(
 val id:Int, val sensor_type_id:Int, val sensor_model:String, val parameter_type_id:Int
)

object Sensors: Table(){
    val id=integer("id").autoIncrement()
    val sensor_type_id=integer("sensor_type_id")
    val sensor_model=varchar("sensor_model", length = 50)
    val parameter_type_id=integer("parameter_type_id")
    override val primaryKey: PrimaryKey
        get() = PrimaryKey(id)
}