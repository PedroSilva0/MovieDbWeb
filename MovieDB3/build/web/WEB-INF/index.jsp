<%-- 
    Document   : Index
    Created on : 15/jun/2017, 12:23:33
    Author     : Utilizador
--%>

<%@page import="java.util.List"%>
<%@page import="moviedb_classes.Movie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Hello!</h1>
        <table style="width:100%">
        <tr>
            <th> Poster </th>
            <th>Movie Title</th>
            <th>Movie Duration</th> 
        </tr>
        <% List<Movie> movies = (List) request.getAttribute("movies");
                    for(Movie g : movies) { %>
                        <tr>
                            <td><img src=<%= g.getPoster()%> height="100" width="60"/></td>
                            <td><%= g.getTitle() %></td>
                            <td><%= g.getDuration()%></td> 
                        </tr>
                    <% } %>
        </table>
        <form action="LoginServlet" method="POST">
            <input type="text" name="name" value="User"/>
            <input type="password" name="password" Value="Pass"/>
        <input type="submit" value="Login"/>
        </form>
    </body>
</html>
