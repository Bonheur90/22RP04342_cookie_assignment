<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="jakarta.servlet.http.HttpSession" %>  
    
<%  
    HttpSession session2 = request.getSession(false);  
    if (session2 == null || session2.getAttribute("username") == null) {  
        response.sendRedirect("login.html");  
    } else {  
        String username = (String) session2.getAttribute("username");  
%>  
<!DOCTYPE html>  
<html lang="en">  
<head>  
    <meta charset="UTF-8">  
    <meta name="viewport" content="width=device-width, initial-scale=1.0">  
    <title>Welcome</title>  
</head>  
<body>  
    <h2>Welcome, <%= username %>!</h2>  
    <form action="LogoutServlet" method="post">  
        <input type="submit" value="Logout">  
    </form>  
</body>  
</html>  
<%  
    }  
%>  
