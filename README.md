# Silver Lining Web Application

### The Team
**The name of our team is Silver Lining. Our members are:**
- Cameron Conn, cmc19v
- Omar Pippin, oyp17
- Austin Schmid, ats20bb
- Michael Stevens, ms20
- Luciano Zavala, lez17b

### Problem Statement
Weather influences our lives. Many outdoor activities are enhanced, degraded, or made outright impossible with
the right weather conditions. Weather is a substantial factor in how we plan, go about, and live our lives.

### Project Overview
The goal of this project is to give our users better information about weather and how it may affect them.
In our app users will be able to select a list of activities they care to be updated on the conditions of.

When a user opens the app he or she will select from a menu of sporting activities they care about. Afterwards,
the app will display a local weather radar of the area where the user is located. The display will have markers of
where their activities can be performed. For example, a user could select basketball and soccer as their preferred
activities. If a user selects a particular marker, the app will present information about the location such as hours
of operation, reviews, costs, weather conditions, and a way of connecting with users already playing at a particular
location.

### Goals
- **Relevance:** Show users relevant weather information for activities they care about.
- **Health:** Help our users enjoy the outdoors and live healthier lives.
- **Academic:** Get an A in CEN 4090L.
- **Involvement:** Create a messaging system that connects our users.
- **Stretch Goals Tips/Reminders:** Our app could implement things like reminders or tips for sports they care about. For example,
  the app could remind users to get a certain number of hours of exercise each week.
- **Affiliated Links:** Our app could link to third parties that provide equipment rentals or training for an activity.
- **Activity Discounts:** We would like to incentivize users to keep participating in outdoor activities with things
  such as gear-rental or in-store discount coupons.
- **Scheduling:** We would like to implement a scheduling or calendar feature that allows our users to plan their
  sporting activities. For example, our app could predict the quality of weather a location will have favorable weather
  on a given day. This could be implemented as a prediction system or with a rating with machine learning.

### Specifications
Our project will be constructed as a webapp with a backend written in Kotlin using the ktor web framework and a
UI built with HTML, CSS, and JavaScript. Our app will query third-party map and weather data providers to give users
localized and relevant weather information. We will store user-relevant and frequently accessed data in a local
database such as Postgresql or MongoDB. For weather data we will query public APIs such as the OpenWeatherMap API or
NOAA’s Web Service API. For maps we will use permissively-licensed data from OpenStreetMap.

### Editing the code
The code is based on a Github CI/CD structure for managing versions and also to collaborate.
To run the code type the following commands in the terminal:
```
    git clone https://github.com/SilverLining2021/Silver-Lining-web-Application.git
```
Once you have the repository cloned into your local machine you will be able to pull and push changes from the
remote branch. For remotely updating the code type the following commands:
```
    git add -A
    git commit -m 'message'
```
For the push you cna use the integrated Intellij IDEA green arrow to push.
In case you wna to update your code from the main branch please run the following commmand:
```
    git pull
```

### Running the Code
Assuming you have the code built, in your project directory do:
```
./gradlew run
``

Note that you will now have a local SQLite database created at `data.db` if one does not already exist.