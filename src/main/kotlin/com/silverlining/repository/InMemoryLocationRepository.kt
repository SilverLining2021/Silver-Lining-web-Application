package com.silverlining.repository

import com.silverlining.entities.Location

class InMemoryLocationRepository: LocationRepository {

    private var location = Location(-122.0842499, 37.4224764)

    // Function to get the location data from the data structure.
    override fun getAllLocationData(): Location {
        return(location)
    }

    // Function to get the geolocation from the Maps API
    override fun initGeoLocation(latitude: Double, longitude: Double): Location {
        location = Location(latitude, longitude)
        return(location)
    }

    override fun getLongitude(): Double {
        return location.longitude
    }


    override fun getLatitude(): Double {
        return location.latitude
    }

    // Function to post the geolocation data into the Weather API
    override fun postGeoLocation(latitude: Double, longitude: Double) {
        TODO("Not yet implemented")
    }
}