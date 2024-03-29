package com.example.dao

import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

object databasefactory {
    fun init(){
        val driverClassName = "org.postgresql.Driver"
        val jdbcURL = "jdbc:postgresql://5.35.94.60:5432/ZachynTim?user=postgres&password=123"
        val database = Database.connect(jdbcURL, driverClassName)

    }
    suspend fun <T> dbQuery(block:suspend ()->T):T = newSuspendedTransaction(Dispatchers.IO){block()}
}