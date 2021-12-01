<!DOCTYPE html>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Silver Lining</title>
    <link rel="icon" type="image/x-icon" href="/files/favicon.ico" />
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="/files/styles.css" rel="stylesheet" />
    <link href="/files/main.css" rel="stylesheet" />
</head>
<body id="page-top">
<!-- Navigation-->
<nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="/">map</a>
        <button class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="/map">Map</a></li>
                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="/about-us">About us</a></li>
                <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="/contact-us">Contact us</a></li>
                <!-- User-login specific content -->
                <#if user?? && user?has_content>
                    <p>Hello, ${user.name}!</p>
                <#else>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="/login">log in</a></li>
                </#if>
            </ul>
        </div>
    </div>
</nav>



<!-- Masthead-->
<header class="masthead bg-primary-x text-white text-center">


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
</header>

<!-- Footer-->
<footer class="footer text-center">
    <div class="container">
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
    </div>
</footer>
<!-- Copyright Section-->
<div class="copyright py-4 text-center text-white">
    <div class="container"><small>Copyright &copy; SilverLining 2021</small></div>
</div>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="/files/scripts.js"></script>
<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
<!-- * *                               SB Forms JS                               * *-->
<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>