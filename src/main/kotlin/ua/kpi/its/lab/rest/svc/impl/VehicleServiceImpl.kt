package ua.kpi.its.lab.rest.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.dto.VehicleRequest
import ua.kpi.its.lab.rest.dto.VehicleResponse
import ua.kpi.its.lab.rest.entity.Vehicle
import ua.kpi.its.lab.rest.repository.VehicleRepository
import ua.kpi.its.lab.rest.svc.VehicleService

@Service
class VehicleServiceImpl(private val VehicleRepository: VehicleRepository) : VehicleService {
    override fun createVehicle(VehicleRequest: VehicleRequest): VehicleResponse {
        val Vehicle = Vehicle(name = VehicleRequest.name, address = VehicleRequest.address)
        val savedVehicle = VehicleRepository.save(Vehicle)
        return VehicleResponse.fromEntity(savedVehicle)
    }

    override fun getVehicleById(id: Long): VehicleResponse {
        val Vehicle = VehicleRepository.findById(id).orElseThrow()
        return VehicleResponse.fromEntity(Vehicle)
    }

    override fun updateVehicle(id: Long, VehicleRequest: VehicleRequest): VehicleResponse {
        val Vehicle = VehicleRepository.findById(id).orElseThrow()
        Vehicle.name = VehicleRequest.name
        Vehicle.address = VehicleRequest.address
        val updatedVehicle = VehicleRepository.save(Vehicle)
        return VehicleResponse.fromEntity(updatedVehicle)
    }

    override fun deleteVehicle(id: Long) {
        VehicleRepository.deleteById(id)
    }
}