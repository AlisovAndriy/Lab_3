package ua.kpi.its.lab.rest.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
data class Vehicle(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val brand: String,
    val model: String,
    val manufacturer: String,
    val releaseDate: LocalDate,
    val topSpeed: Int,
    val price: Int,
    val abs: Boolean,
    val battery: List<Battery>
    var id: Long = 0,
    var name: String = ""
) : Comparable<Vehicle> {
    override fun compareTo(other: Vehicle): Int {
        val cmp = brand.compareTo(other.brand)
        return if (cmp != 0) cmp else price.compareTo(other.price)
    }
}

data class Battery(
    val model: String,
    val manufacturer: String,
    val type: String,
    val capacity: LocalDate,
    val releaseDate: Int,
    val chargingTime: Double,
    val fastCharging: Boolean
) : Comparable<Battery> {
    override fun compareTo(other: Battery): Int {
        val cmp = model.compareTo(other.model)
        return if (cmp != 0) cmp else chargingTime.compareTo(other.chargingTime)
    }
}
