<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Silver Lining - Login</title>
</head>
<body>
<h2>Login</h2>
<li><a href="/">Home</a> </li>
<p>Please login to use this application</p>
<form name="auth-form" method="post" enctype="application/x-www-form-urlencoded">
    <label>Username:
        <input type="text" name="username" placeholder="myusername" /></label><br />
    <label>Password:
        <input type="password" name="password" placeholder="hunter2" /></label><br />
    <input type="submit" value="Login" formaction="/login" />
</form>
</body>
</html>