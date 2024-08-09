<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Login</title>
</head>
<body>
    <h1>Enter Your Username or Email</h1>
    <form action="StoreCookieServlet" method="POST">
        <input type="text" name="username" id="username" placeholder="Username or Email" 
               value="<%= request.getAttribute("username") != null ? request.getAttribute("username") : "" %>">
        <input type="submit" value="Submit">
    </form>
</body>
</html>