<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Silver Lining</title>
</head>
<body>
    <h3>Welcome to the Silver Lining Web Application</h3>

    <div>
        <p>Sports-weather app under development</p>
        <#if user?? && user?has_content>
            <p>Hello, ${user.name}!</p>
        <#else>
            <p>You are currenetly not logged in. Please <a href="/login">log in</a></p>
        </#if>
    </div>
</body>
</html>