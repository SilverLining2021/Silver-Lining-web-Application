package com.silverlining.api

import com.silverlining.entities.InDoor
import com.silverlining.entities.OutDoor
import com.silverlining.entities.SportsDataClass
import com.silverlining.entities.weatherDataClass
//import com.silverlining.repository.InMemorySportsRepository
//import com.silverlining.repository.SportsRepository

fun computeSportsData(weatherData: weatherDataClass): SportsDataClass{

    /* these are the conditions we can pull in from the API */
    // None; Rain; Snow
    // var weather = weatherData.
    //val sportsRepo: SportsRepository = InMemorySportsRepository()

    //var sportsData = SportsDataClass(inDoor, ourDoor)


    val precip: String = "None"
    // < 12; 12 - 24; 24+
    val wind = weatherData.wind.speed
    // < 32; 32 - 80; 80+
    var temp = weatherData.main.temp
    temp = (temp - 273.15) * (9/5) + 32

    //val id = InDoor("1", "2", "3", "4", "5")
    //val od = OutDoor("1", "2", "3", "4", "5")
    val sportsData = SportsDataClass("a", "b", "c", "d", "e", "f","g", "h", "i", "j")


    sportsData.Sport1 = "Badminton"
    sportsData.Sport2 = "Dodgeball"
    sportsData.Sport3 = "Gymnastics"
    sportsData.Sport4 = "Indoor basketball"
    sportsData.Sport5 = "Indoor volleyball"
    sportsData.Sport6 = "Football"
    sportsData.Sport7 = "Hockey"
    sportsData.Sport8 = "Skiing"
    sportsData.Sport9 = "Ice Gymnastics"
    sportsData.Sport10 = "Sledding"

    if(precip == "None" && wind < 12 && temp < 32) {
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6 = "Football"
        sportsData.Sport7 = "Hockey"
        sportsData.Sport8 = "Skiing"
        sportsData.Sport9 = "Curling"
        sportsData.Sport10 = "Sledding"
    }
    else if(precip == "None" && wind < 12 && (temp > 32 || temp < 60)){
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6 = "Football"
        sportsData.Sport7 = "Kickball"
        sportsData.Sport8 = "Soccer"
        sportsData.Sport9 = "Softball"
        sportsData.Sport10 = "Tennis"
    }
    else if(precip == "None" && wind < 12 && temp > 60){
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6 = "Beach Volleyball"
        sportsData.Sport7 = "Football"
        sportsData.Sport8 = "Golf"
        sportsData.Sport9 = "Surfing"
        sportsData.Sport10 = "Tennis"
    }
    else if(precip == "None" && (wind >12 || wind < 24) && temp < 32){
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6 = "Football"
        sportsData.Sport7 = "Hockey"
        sportsData.Sport8 = "Skiing"
        sportsData.Sport9 = "Curling"
        sportsData.Sport10 = "Sledding"
    }
    else if (precip == "None" && (wind >12 || wind < 24) && (temp > 32 || temp < 60)){
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6 = "Football"
        sportsData.Sport7 = "Golf"
        sportsData.Sport8 = "Kickball"
        sportsData.Sport9 = "Kiting"
        sportsData.Sport10 = "Soccer"
    }
    else if(precip == "None" && (wind >12 || wind < 24) && temp > 60){
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6 = "Beach Volleyball"
        sportsData.Sport7 = "Football"
        sportsData.Sport8 = "Frisbee"
        sportsData.Sport9 = "Golf"
        sportsData.Sport10 = "Outdoor basketball"
    }
    else if(precip == "None" && wind > 24 && temp < 32){
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6 = "Football"
        sportsData.Sport7 = "Hockey"
        sportsData.Sport8 = "Sledding"
        sportsData.Sport9 = "Ice Fishing"
        sportsData.Sport10 = "Curling"
    }
    else if(precip == "None" && wind > 24 && (temp > 32 || temp < 60)){
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6 = "Football"
        sportsData.Sport7 = "Frisbee"
        sportsData.Sport8 = "Kiting"
        sportsData.Sport9 = "Soccer"
        sportsData.Sport10 = "Running"
    }
    else if(precip == "None" && wind > 24 && temp > 60){
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6 = "Football"
        sportsData.Sport7 = "Frisbee"
        sportsData.Sport8 = "Kiting"
        sportsData.Sport9 = "Soccer"
        sportsData.Sport10 = "Surfing"
    }
    else if(precip == "Rain" && wind < 12){
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6 = "Football"
        sportsData.Sport7 = "Soccer"
        sportsData.Sport8 = "None"
        sportsData.Sport9 = "None"
        sportsData.Sport10 = "None"
    }
    else if(precip == "Rain" && wind < 12 && (temp > 32 || temp < 60)){
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6 = "Football"
        sportsData.Sport7 = "None"
        sportsData.Sport8 = "None"
        sportsData.Sport9 = "None"
        sportsData.Sport10 = "None"
    }
    else if(precip == "Rain" && wind < 12 && temp > 60){
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6 = "Football"
        sportsData.Sport7 = "Soccer"
        sportsData.Sport8 = "None"
        sportsData.Sport9 = "None"
        sportsData.Sport10 = "None"
    }
    else if(precip == "Rain" && (wind > 12 || wind < 24) && (temp > 32 || temp < 60)){
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6 = "Football"
        sportsData.Sport7 = "None"
        sportsData.Sport8 = "None"
        sportsData.Sport9 = "None"
        sportsData.Sport10 = "None"
    }
    else if(precip == "Rain" && (wind > 12 || wind < 24) && temp > 60){
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6 = "Football"
        sportsData.Sport7 = "Soccer"
        sportsData.Sport8 = "None"
        sportsData.Sport9 = "None"
        sportsData.Sport10 = "None"
    }
    else if(precip == "Rain" && wind > 24 && (temp > 32 || temp < 60)){
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6 = "Football"
        sportsData.Sport7 = "None"
        sportsData.Sport8 = "None"
        sportsData.Sport9 = "None"
        sportsData.Sport10 = "None"
    }
    else if(precip == "Rain" && wind > 24 && temp > 60){
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6 = "Football"
        sportsData.Sport7 = "Soccer"
        sportsData.Sport8 = "None"
        sportsData.Sport9 = "None"
        sportsData.Sport10 = "None"
    }
    else if(precip == "Snow" && wind < 12 && temp <32){
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6 = "Football"
        sportsData.Sport7 = "Hockey"
        sportsData.Sport8 = "Skiing"
        sportsData.Sport9 = "Sledding"
        sportsData.Sport10 = "Snowboarding"
    }
    else if(precip == "Snow" && (wind > 12 || wind <12) && temp < 32){
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6 = "Football"
        sportsData.Sport7 = "Hockey"
        sportsData.Sport8 = "Skiing"
        sportsData.Sport9 = "Sledding"
        sportsData.Sport10 = "Snowboarding"
    }
    else if(precip == "Snow" && wind > 24 && temp < 32){
        // INDOOR data
        sportsData.Sport1 = "Badminton"
        sportsData.Sport2 = "Dodgeball"
        sportsData.Sport3 = "Gymnastics"
        sportsData.Sport4 = "Indoor basketball"
        sportsData.Sport5 = "Indoor volleyball"

        // OUTDOOR Data
        sportsData.Sport6= "Football"
        sportsData.Sport7 = "Hockey"
        sportsData.Sport8 = "Skiing"
        sportsData.Sport9 = "Sledding"
        sportsData.Sport10 = "Snowboarding"
    }

    return sportsData
}