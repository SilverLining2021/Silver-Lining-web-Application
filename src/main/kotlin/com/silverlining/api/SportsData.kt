package com.silverlining.api

import com.silverlining.entities.InDoor
import com.silverlining.entities.OutDoor
import com.silverlining.entities.SportsDataClass
import com.silverlining.entities.weatherDataClass
import com.silverlining.repository.InMemorySportsRepository
import com.silverlining.repository.SportsRepository

fun computeSportsData(weatherData: weatherDataClass): SportsDataClass{

    /* these are the conditions we can pull in from the API */
    // None; Rain; Snow
    // var weather = weatherData.
    val sportsRepo: SportsRepository = InMemorySportsRepository()

    //var sportsData = SportsDataClass(inDoor, ourDoor)


    val precip: String = "None"
    // (0 K − 273.15) × 9/5 + 32 = -459.7 °F
    // < 12; 12 - 24; 24+
    val wind = weatherData.wind.speed
    // < 32; 32 - 80; 80+
    var temp = weatherData.main.temp
    temp = (temp - 273.15) * (9/5) + 32
    // Clear; Cloudy

    val id = InDoor("1", "2", "3", "4", "5")
    val od = OutDoor("1", "2", "3", "4", "5")
    val sportsData = SportsDataClass(id, od)

    // INDOOR data
    sportsData.InDoor.Sport1 = "Badminton"
    sportsData.InDoor.Sport2 = "Dodgeball"
    sportsData.InDoor.Sport3 = "Gymnastics"
    sportsData.InDoor.Sport4 = "Indoor basketball"
    sportsData.InDoor.Sport5 = "Indoor volleyball"

    // OUTDOOR Data
    sportsData.OutDoor.Sport1 = "Football"
    sportsData.OutDoor.Sport2 = "Hockey"
    sportsData.OutDoor.Sport3 = "Skiing"
    sportsData.OutDoor.Sport4 = "Ice Gymnastics"
    sportsData.OutDoor.Sport5 = "Sliding"


    return sportsData

}