package ua.kpi.its.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.VehicleRequest
import ua.kpi.its.lab.rest.dto.VehicleResponse
import ua.kpi.its.lab.rest.exception.ResourceNotFoundException
import javax.validation.Valid


@RestController
@RequestMapping("/api/Vehicles")
public class VehicleController {

    private final VehicleService VehicleService;

    @Autowired
    public VehicleController(VehicleService VehicleService)
    {
        this.VehicleService = VehicleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponse> getVehicleById(@PathVariable Long id) throws ResourceNotFoundException
    {
        VehicleResponse VehicleResponse = VehicleService . getVehicleById (id);
        if (VehicleResponse == null) {
            throw new ResourceNotFoundException ("Vehicle with id " + id + " not found");
        }
        return ResponseEntity.ok(VehicleResponse);
    }

    @GetMapping("/")
    open fun getAllVehicles(): ResponseEntity<MutableList<VehicleResponse?>?>? {
        val VehicleResponses: kotlin.collections.List<VehicleResponse> = VehicleService.getAllVehicles()
        return ResponseEntity.ok<kotlin.collections.List<VehicleResponse>>(VehicleResponses)
    }

    @PostMapping("/")
    fun createVehicle(@Valid @RequestBody VehicleRequest: VehicleRequest?): ResponseEntity<VehicleResponse>? {
        val VehicleResponse: VehicleResponse = VehicleService.createVehicle(VehicleRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body<VehicleResponse>(VehicleResponse)
    }

    @PutMapping("/{id}")
    @Throws(ResourceNotFoundException::class)
    fun updateVehicle(
        @PathVariable id: Long,
        @Valid @RequestBody VehicleRequest: VehicleRequest?
    ): ResponseEntity<VehicleResponse>? {
        val VehicleResponse: VehicleResponse = VehicleService.updateVehicle(id, VehicleRequest)
            ?: throw ResourceNotFoundException("Vehicle with id $id not found")
        return ResponseEntity.ok<VehicleResponse>(VehicleResponse)
    }

    @DeleteMapping("/{id}")
    @Throws(ResourceNotFoundException::class)
    fun deleteVehicle(@PathVariable id: Long): ResponseEntity<Void?>? {
        val isDeleted: Boolean = VehicleService.deleteVehicle(id)
        if (!isDeleted) {
            throw ResourceNotFoundException("Vehicle with id $id not found")
        }
        return ResponseEntity.noContent().build()
    }
}