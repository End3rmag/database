package com.example.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class SensorType(
    val id:Int,
    val sensor_type:String
)
object SensorTypes: Table() {
    val id = integer("id").autoIncrement()
    val sensor_type = varchar("sensor_type", length = 50)
    override val primaryKey: PrimaryKey
        get() = PrimaryKey(id)
}


