package ua.kpi.its.lab.rest.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.dto.BatteryRequest
import ua.kpi.its.lab.rest.dto.BatteryResponse
import ua.kpi.its.lab.rest.entity.Battery
import ua.kpi.its.lab.rest.repository.BatteryRepository
import ua.kpi.its.lab.rest.svc.BatteryService
import org.springframework.security.access.prepost.PreAuthorize
@Service
class BatteryServiceImpl(private val BatteryRepository: BatteryRepository) : BatteryService {
    @PreAuthorize("hasAuthority('EDITOR')")
    override fun createBattery(BatteryRequest: BatteryRequest): BatteryResponse {
        val Battery = Battery(name = BatteryRequest.name, description = BatteryRequest.description)
        val savedBattery = BatteryRepository.save(Battery)
        return BatteryResponse.fromEntity(savedBattery)
    }
    @PreAuthorize("permitAll()")
    override fun getBatteryById(id: Long): BatteryResponse {
        val Battery = BatteryRepository.findById(id).orElseThrow()
        return BatteryResponse.fromEntity(Battery)
    }

    @PreAuthorize("hasAuthority('EDITOR')")
    override fun updateBattery(id: Long, BatteryRequest: BatteryRequest): BatteryResponse {
        val Battery = BatteryRepository.findById(id).orElseThrow()
        Battery.name = BatteryRequest.name
        Battery.description = BatteryRequest.description
        val updatedBattery = BatteryRepository.save(Battery)
        return BatteryResponse.fromEntity(updatedBattery)
    }

    @PreAuthorize("hasAuthority('EDITOR')")
    override fun deleteBattery(id: Long) {
        BatteryRepository.deleteById(id)
    }
}