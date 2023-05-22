package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.dto.BatteryRequest
import ua.kpi.its.lab.rest.dto.BatteryResponse
interface BatteryService {
    fun createBattery(BatteryRequest: BatteryRequest): BatteryResponse
    fun getBatteryById(id: Long): BatteryResponse
    fun updateBattery(id: Long, BatteryRequest: BatteryRequest): BatteryResponse
    fun deleteBattery(id: Long)
}