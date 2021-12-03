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

    if(precip == "None" && wind < 12 && temp < 32) {
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
        sportsData.OutDoor.Sport4 = "Curling"
        sportsData.OutDoor.Sport5 = "Sledding"
    }
    else if(precip == "None" && wind < 12 && (temp > 32 || temp < 60)){
        // INDOOR data
        sportsData.InDoor.Sport1 = "Badminton"
        sportsData.InDoor.Sport2 = "Dodgeball"
        sportsData.InDoor.Sport3 = "Gymnastics"
        sportsData.InDoor.Sport4 = "Indoor basketball"
        sportsData.InDoor.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.OutDoor.Sport1 = "Football"
        sportsData.OutDoor.Sport2 = "Kickball"
        sportsData.OutDoor.Sport3 = "Soccer"
        sportsData.OutDoor.Sport4 = "Softball"
        sportsData.OutDoor.Sport5 = "Tennis"
    }
    else if(precip == "None" && wind < 12 && temp > 60){
        // INDOOR data
        sportsData.InDoor.Sport1 = "Badminton"
        sportsData.InDoor.Sport2 = "Dodgeball"
        sportsData.InDoor.Sport3 = "Gymnastics"
        sportsData.InDoor.Sport4 = "Indoor basketball"
        sportsData.InDoor.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.OutDoor.Sport1 = "Beach Volleyball"
        sportsData.OutDoor.Sport2 = "Football"
        sportsData.OutDoor.Sport3 = "Golf"
        sportsData.OutDoor.Sport4 = "Surfing"
        sportsData.OutDoor.Sport5 = "Tennis"
    }
    else if(precip == "None" && (wind >12 || wind < 24) && temp < 32){
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
        sportsData.OutDoor.Sport4 = "Curling"
        sportsData.OutDoor.Sport5 = "Sledding"
    }
    else if (precip == "None" && (wind >12 || wind < 24) && (temp > 32 || temp < 60)){
        // INDOOR data
        sportsData.InDoor.Sport1 = "Badminton"
        sportsData.InDoor.Sport2 = "Dodgeball"
        sportsData.InDoor.Sport3 = "Gymnastics"
        sportsData.InDoor.Sport4 = "Indoor basketball"
        sportsData.InDoor.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.OutDoor.Sport1 = "Football"
        sportsData.OutDoor.Sport2 = "Golf"
        sportsData.OutDoor.Sport3 = "Kickball"
        sportsData.OutDoor.Sport4 = "Kiting"
        sportsData.OutDoor.Sport5 = "Soccer"
    }
    else if(precip == "None" && (wind >12 || wind < 24) && temp > 60){
        // INDOOR data
        sportsData.InDoor.Sport1 = "Badminton"
        sportsData.InDoor.Sport2 = "Dodgeball"
        sportsData.InDoor.Sport3 = "Gymnastics"
        sportsData.InDoor.Sport4 = "Indoor basketball"
        sportsData.InDoor.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.OutDoor.Sport1 = "Beach Volleyball"
        sportsData.OutDoor.Sport2 = "Football"
        sportsData.OutDoor.Sport3 = "Frisbee"
        sportsData.OutDoor.Sport4 = "Golf"
        sportsData.OutDoor.Sport5 = "Outdoor basketball"
    }
    else if(precip == "None" && wind > 24 && temp < 32){
        // INDOOR data
        sportsData.InDoor.Sport1 = "Badminton"
        sportsData.InDoor.Sport2 = "Dodgeball"
        sportsData.InDoor.Sport3 = "Gymnastics"
        sportsData.InDoor.Sport4 = "Indoor basketball"
        sportsData.InDoor.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.OutDoor.Sport1 = "Football"
        sportsData.OutDoor.Sport2 = "Hockey"
        sportsData.OutDoor.Sport3 = "Sledding"
        sportsData.OutDoor.Sport4 = "Ice Fishing"
        sportsData.OutDoor.Sport5 = "Curling"
    }
    else if(precip == "None" && wind > 24 && (temp > 32 || temp < 60)){
        // INDOOR data
        sportsData.InDoor.Sport1 = "Badminton"
        sportsData.InDoor.Sport2 = "Dodgeball"
        sportsData.InDoor.Sport3 = "Gymnastics"
        sportsData.InDoor.Sport4 = "Indoor basketball"
        sportsData.InDoor.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.OutDoor.Sport1 = "Football"
        sportsData.OutDoor.Sport2 = "Frisbee"
        sportsData.OutDoor.Sport3 = "Kiting"
        sportsData.OutDoor.Sport4 = "Soccer"
        sportsData.OutDoor.Sport5 = "Running"
    }
    else if(precip == "None" && wind > 24 && temp > 60){
        // INDOOR data
        sportsData.InDoor.Sport1 = "Badminton"
        sportsData.InDoor.Sport2 = "Dodgeball"
        sportsData.InDoor.Sport3 = "Gymnastics"
        sportsData.InDoor.Sport4 = "Indoor basketball"
        sportsData.InDoor.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.OutDoor.Sport1 = "Football"
        sportsData.OutDoor.Sport2 = "Frisbee"
        sportsData.OutDoor.Sport3 = "Kiting"
        sportsData.OutDoor.Sport4 = "Soccer"
        sportsData.OutDoor.Sport5 = "Surfing"
    }
    else if(precip == "Rain" && wind < 12){
        // INDOOR data
        sportsData.InDoor.Sport1 = "Badminton"
        sportsData.InDoor.Sport2 = "Dodgeball"
        sportsData.InDoor.Sport3 = "Gymnastics"
        sportsData.InDoor.Sport4 = "Indoor basketball"
        sportsData.InDoor.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.OutDoor.Sport1 = "Football"
        sportsData.OutDoor.Sport2 = "Soccer"
        sportsData.OutDoor.Sport3 = "None"
        sportsData.OutDoor.Sport4 = "None"
        sportsData.OutDoor.Sport5 = "None"
    }
    else if(precip == "Rain" && wind < 12 && (temp > 32 || temp < 60)){
        // INDOOR data
        sportsData.InDoor.Sport1 = "Badminton"
        sportsData.InDoor.Sport2 = "Dodgeball"
        sportsData.InDoor.Sport3 = "Gymnastics"
        sportsData.InDoor.Sport4 = "Indoor basketball"
        sportsData.InDoor.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.OutDoor.Sport1 = "Football"
        sportsData.OutDoor.Sport2 = "None"
        sportsData.OutDoor.Sport3 = "None"
        sportsData.OutDoor.Sport4 = "None"
        sportsData.OutDoor.Sport5 = "None"
    }
    else if(precip == "Rain" && wind < 12 && temp > 60){
        // INDOOR data
        sportsData.InDoor.Sport1 = "Badminton"
        sportsData.InDoor.Sport2 = "Dodgeball"
        sportsData.InDoor.Sport3 = "Gymnastics"
        sportsData.InDoor.Sport4 = "Indoor basketball"
        sportsData.InDoor.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.OutDoor.Sport1 = "Football"
        sportsData.OutDoor.Sport2 = "Soccer"
        sportsData.OutDoor.Sport3 = "None"
        sportsData.OutDoor.Sport4 = "None"
        sportsData.OutDoor.Sport5 = "None"
    }
    else if(precip == "Rain" && (wind > 12 || wind < 24) && (temp > 32 || temp < 60)){
        // INDOOR data
        sportsData.InDoor.Sport1 = "Badminton"
        sportsData.InDoor.Sport2 = "Dodgeball"
        sportsData.InDoor.Sport3 = "Gymnastics"
        sportsData.InDoor.Sport4 = "Indoor basketball"
        sportsData.InDoor.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.OutDoor.Sport1 = "Football"
        sportsData.OutDoor.Sport2 = "None"
        sportsData.OutDoor.Sport3 = "None"
        sportsData.OutDoor.Sport4 = "None"
        sportsData.OutDoor.Sport5 = "None"
    }
    else if(precip == "Rain" && (wind > 12 || wind < 24) && temp > 60){
        // INDOOR data
        sportsData.InDoor.Sport1 = "Badminton"
        sportsData.InDoor.Sport2 = "Dodgeball"
        sportsData.InDoor.Sport3 = "Gymnastics"
        sportsData.InDoor.Sport4 = "Indoor basketball"
        sportsData.InDoor.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.OutDoor.Sport1 = "Football"
        sportsData.OutDoor.Sport2 = "Soccer"
        sportsData.OutDoor.Sport3 = "None"
        sportsData.OutDoor.Sport4 = "None"
        sportsData.OutDoor.Sport5 = "None"
    }
    else if(precip == "Rain" && wind > 24 && (temp > 32 || temp < 60)){
        // INDOOR data
        sportsData.InDoor.Sport1 = "Badminton"
        sportsData.InDoor.Sport2 = "Dodgeball"
        sportsData.InDoor.Sport3 = "Gymnastics"
        sportsData.InDoor.Sport4 = "Indoor basketball"
        sportsData.InDoor.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.OutDoor.Sport1 = "Football"
        sportsData.OutDoor.Sport2 = "None"
        sportsData.OutDoor.Sport3 = "None"
        sportsData.OutDoor.Sport4 = "None"
        sportsData.OutDoor.Sport5 = "None"
    }
    else if(precip == "Rain" && wind > 24 && temp > 60){
        // INDOOR data
        sportsData.InDoor.Sport1 = "Badminton"
        sportsData.InDoor.Sport2 = "Dodgeball"
        sportsData.InDoor.Sport3 = "Gymnastics"
        sportsData.InDoor.Sport4 = "Indoor basketball"
        sportsData.InDoor.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.OutDoor.Sport1 = "Football"
        sportsData.OutDoor.Sport2 = "Soccer"
        sportsData.OutDoor.Sport3 = "None"
        sportsData.OutDoor.Sport4 = "None"
        sportsData.OutDoor.Sport5 = "None"
    }
    else if(precip == "Snow" && wind < 12 && temp <32){
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
        sportsData.OutDoor.Sport4 = "Sledding"
        sportsData.OutDoor.Sport5 = "Snowboarding"
    }
    else if(precip == "Snow" && (wind > 12 || wind <12) && temp < 32){
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
        sportsData.OutDoor.Sport4 = "Sledding"
        sportsData.OutDoor.Sport5 = "Snowboarding"
    }
    else if(precip == "Snow" && wind > 24 && temp < 32){
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
        sportsData.OutDoor.Sport4 = "Sledding"
        sportsData.OutDoor.Sport5 = "Snowboarding"
    }

    return sportsData
}