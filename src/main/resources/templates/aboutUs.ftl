<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Silver Lining - About Us</title>
    <body id="page-top">
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
        <div class="container">
            <a class="navbar-brand" href="/">SilverLining</a>
            <button class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                Menu
                <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="/">Home</a></li>
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
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
        }

        html {
            box-sizing: border-box;
        }

        *, *:before, *:after {
            box-sizing: inherit;
        }

        .column {
            float: left;
            width: 33.3%;
            margin-bottom: 16px;
            padding: 0 8px;
        }

        .card {
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            margin: 8px;
        }

        .about-section {
            padding: 50px;
            text-align: center;
            background-color: #474e5d;
            color: white;
        }

        .container {
            padding: 0 16px;
        }

        .container::after, .row::after {
            content: "";
            clear: both;
            display: table;
        }

        .title {
            color: grey;
        }

        .button {
            border: none;
            outline: 0;
            display: inline-block;
            padding: 8px;
            color: white;
            background-color: #000;
            text-align: center;
            cursor: pointer;
            width: 100%;
        }

        .button:hover {
            background-color: #555;
        }

        @media screen and (max-width: 650px) {
            .column {
                width: 100%;
                display: block;
            }
        }
    </style>
</head>
<body>

<div class="about-section">
    <h1>What is Silver Lining?</h1>
    <p>Silver Lining is a web application that takes local weather data, along with relevant data to sports</p>
    <p>and provides a way to determine if a sport can be played in those conditions.</p>
</div>

<h2 style="text-align:center">Our Team</h2>
<div class="row">
    <div class="column">
        <div class="card">
            <div class="container">
                <h2>Cameron Conn</h2>
                <p><button class="button">Contact</button></p>
            </div>
        </div>
    </div>

    <div class="column">
        <div class="card">
            <div class="container">
                <h2>Omar Pippin</h2>
                <p><button class="button">Contact</button></p>
            </div>
        </div>
    </div>

    <div class="column">
        <div class="card">
            <div class="container">
                <h2>Austin Schmid</h2>
                <p><button class="button">Contact</button></p>
            </div>
        </div>
    </div>

    <div class="column">
        <div class="card">
            <div class="container">
                <h2>Michael Stevens</h2>
                <p><button class="button">Contact</button></p>
            </div>
        </div>
    </div>

    <div class="column">
        <div class="card">
            <div class="container">
                <h2>Luciano Zavala</h2>
                <p><button class="button">Contact</button></p>
            </div>
        </div>
    </div>
</div>

</body>
</html>
