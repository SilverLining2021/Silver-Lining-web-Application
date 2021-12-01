package com.silverlining.entities

data class Location(
    var formatted_address: String,
    var longitude: Double ,
    var latitude: Double,
    var location_type: String,
    var place_id: String
)

