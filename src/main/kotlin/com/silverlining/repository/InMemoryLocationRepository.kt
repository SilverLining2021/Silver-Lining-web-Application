package com.silverlining.repository

import com.silverlining.entities.Location

class InMemoryLocationRepository: LocationRepository {

    private val location = listOf(
        Location("1600 Amphitheatre Parkway, Mountain View, CA 94043, USA",
            -122.0842499,
            37.4224764,
            "ROOFTOP",
            "ChIJ2eUgeAK6j4ARbn5u_wAGqWA")
    )

    // Function to get the location data from the data structure.
    override fun getAllLocationData(): List<Location> {
        return(location)
    }


    // Function to get the geolocation from the Maps API
    override fun getGeoLocation(latitude: Double, longitude: Double): Location? {
        TODO("Not yet implemented")
    }


    // Function to post the geolocation data into the Weather API
    override fun postGeoLocation(latitude: Double, longitude: Double) {
        TODO("Not yet implemented")
    }
}