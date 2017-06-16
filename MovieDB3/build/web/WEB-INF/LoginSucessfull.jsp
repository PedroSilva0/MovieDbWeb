<%-- 
    Document   : LoginSucessfull
    Created on : 15/jun/2017, 15:54:17
    Author     : Utilizador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Sucessfull</title>
    </head>
    <body>
        <h1>
        Hello,
        <%
            String userName = request.getAttribute("user").toString();
            out.println(userName+" !!!");
        %>
        </h1>
    </body>
</html>
