<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>map</title>
</head>
<body>
<h2>Map</h2>
<h3>Welcome to the Silver Lining Webb Application</h3>
<a>Sports-weather app under development</a>
<br><br>
<li><a href="/">Home</a> </li>
<li><a href="map">Map</a> </li>
<li><a href="contact-us">Contact Us</a> </li>
<li><a href="about-us">About Us</a> </li>
<br>

<style>
    #map{
        height: 500px;
        width: 100%;
    }
</style>
<div id="map"></div>

<script>
    // function for setting map with markers
    function initMap(){

        //  get user location
        const successCallback = (position) => {
            //console.log(position);
            //let coord = position.coords
            //console.log(coord);
            //const latitude  = position.coords.latitude;   // if latitude are needed to store
            //const longitude = position.coords.longitude;  // if longitude are needed to store
            //console.log(position.coords.latitude,position.coords.longitude);

            // if needed replace "lat:position.coords.latitude,lng:position.coords.longitude" to "lat:latitude,lng:longitude" if variables enabled
            addMarker({coords:{lat:position.coords.latitude,lng:position.coords.longitude},
                iconImage:null,
                content: '<h1>Your location</h1>'})    // User/device location added to markers
        }
        const errorCallback = (error) => {
            console.log(error);
        }
        // watchPosition as it updates in chang of devise location, while getCurrentPosition does not
        navigator.geolocation.watchPosition(successCallback, errorCallback);

        // map options
        var options = {
            zoom: 8,
            center:{lat:30.1895,lng:-85.7232}
        }
        // new map
        var map = new google.maps.Map(document.getElementById('map'),options);

//*************** remove comments if add markers on click is required ***************************
        // // listen for click on map
        // google.maps.event.addListener(map, 'click', function(event){
        //     // add marker
        //     addMarker({coords:event.latLng})    // add to a database to keep markers
        // });
//*************** remove comments if add markers on click is required ***************************

        // array of markers
        var markers = [
            {
                coords:{lat:30.1895,lng:-85.7232},
                iconImage:null,
                content: '<h1>Florida State University Panama City</h1>'
            },
            {
                coords:{lat:30.1853,lng:-85.7288},
                iconImage:null,
                content: '<h1>Gulf Coast State College</h1>'
            },
        ];
        // loop through markers
        for(var i = 0;i < markers.length;i++){
            // add markers
            addMarker(markers[i]);
        }
        // add marker function
        function addMarker(props){
            var marker = new google.maps.Marker({
                position:props.coords,
                map:map,
               // icon:props.iconImage
            });
            // check for customicon
            if(props.iconImage){
                // set icon image
                marker.setIcon(props.iconImage);
            }
            //check content
            if(props.content){
                var infoWindow = new google.maps.InfoWindow({
                   content:props.content
                });
                marker.addListener('click',function (){
                    infoWindow.open(map,marker);
                });
            }
        }
    }

</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5pQEI4KnHeijsaDOjIrUDWPrB1WE4A9A&callback=initMap">
</script>

<br>
<section>
    <div>
<#--        <iframe-->
<#--                width="600"-->
<#--                height="450"-->
<#--                style="border:0"-->
<#--                loading="lazy"-->
<#--                allowfullscreen-->
<#--                src="https://www.google.com/maps/embed/v1/place?key=AIzaSyAs03qxiVuz_YcTauXKaNS-OMIGftpG1yI-->
<#--    &q=Space+Needle,Seattle+WA">-->
<#--        </iframe>-->
    </div>
</section>
<#--// info for location?-->
<h2>Forecast</h2>
<table style="width:100%">
    <tr>
<#--        // info we wish to display-->
        <td>temperature</td>
        <td>Weather</td>
        <td>Wind</td>
        <td>UV Index</td>
    </tr>
    <tr>
<#--        // values need to be set base location and weather-->
        <td>100</td>
        <td>windy</td>
        <td>80</td>
        <td>16</td>
    </tr>
</table>
</body>
</html>