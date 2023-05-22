package ua.kpi.its.lab.rest.dto

data class ExampleRequest(
    var name: String
)

data class ExampleResponse(
    var id: Long,
    var name: String
)

class BatteryRequest {
    var name: String? = null
        private set
    var description: String? = null
        private set
    var manufacturer: String? = null
        private set

    constructor()
    constructor(name: String?, description: String?, manufacturer: String?) {
        this.name = name
        this.description = description
        this.manufacturer = manufacturer
    }
}


class BatteryResponse {
    var id: Long? = null
        private set
    var name: String? = null
        private set
    var description: String? = null
        private set
    var manufacturer: String? = null
        private set

    constructor()
    constructor(id: Long?, name: String?, description: String?, manufacturer: String?) {
        this.id = id
        this.name = name
        this.description = description
        this.manufacturer = manufacturer
    }
}


class VehicleRequest {
    var name: String? = null
        private set
    var address: String? = null
        private set
    var phoneNumber: String? = null
        private set

    constructor()
    constructor(name: String?, address: String?, phoneNumber: String?) {
        this.name = name
        this.address = address
        this.phoneNumber = phoneNumber
    }
}


class VehicleResponse {
    var id: Long? = null
        private set
    var name: String? = null
        private set
    var address: String? = null
        private set
    var phoneNumber: String? = null
        private set

    constructor()
    constructor(id: Long?, name: String?, address: String?, phoneNumber: String?) {
        this.id = id
        this.name = name
        this.address = address
        this.phoneNumber = phoneNumber
    }
}
