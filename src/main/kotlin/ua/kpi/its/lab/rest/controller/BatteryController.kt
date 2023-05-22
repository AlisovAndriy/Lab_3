package ua.kpi.its.lab.rest.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.BatteryRequest
import ua.kpi.its.lab.rest.dto.BatteryResponse
import ua.kpi.its.lab.rest.svc.impl.BatteryServiceImpl

@RestController
@RequestMapping("/Battery")
class BatteryController(private val BatteryService: BatteryServiceImpl) {
    @PostMapping
    fun createBattery(@RequestBody BatteryRequest: BatteryRequest): ResponseEntity<BatteryResponse> {
        val BatteryResponse = BatteryService.createBattery(BatteryRequest)
        return ResponseEntity(BatteryResponse, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getBatteryById(@PathVariable id: Long): ResponseEntity<BatteryResponse> {
        val BatteryResponse = BatteryService.getBatteryById(id)
        return ResponseEntity(BatteryResponse, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateBattery(@PathVariable id: Long, @RequestBody BatteryRequest: BatteryRequest): ResponseEntity<BatteryResponse> {
        val BatteryResponse = BatteryService.updateBattery(id, BatteryRequest)
        return ResponseEntity(BatteryResponse, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteBattery(@PathVariable id: Long): ResponseEntity<Void> {
        BatteryService.deleteBattery(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}