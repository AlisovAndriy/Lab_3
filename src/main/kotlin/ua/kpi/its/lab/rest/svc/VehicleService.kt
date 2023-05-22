package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.dto.VehicleRequest
import ua.kpi.its.lab.rest.dto.VehicleResponse

interface VehicleService {
    fun createVehicle(VehicleRequest: VehicleRequest): VehicleResponse
    fun getVehicleById(id: Long): VehicleResponse
    fun updateVehicle(id: Long, VehicleRequest: VehicleRequest): VehicleResponse
    fun deleteVehicle(id: Long)
}