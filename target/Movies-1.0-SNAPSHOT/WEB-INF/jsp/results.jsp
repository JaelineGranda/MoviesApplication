<%-- 
    Document   : results
    Created on : Oct 19, 2021, 3:35:54 AM
    Author     : Jaeline
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.me.pojo.Movie"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movies</title>
    </head>
    <body>
        <h1>You searched for: </h1>
        <h2>Here are the search results: </h2>
        <table border="1">
            <tr>
                <th>title</th>
                <th>actor</th>
                <th>actress</th>
                <th>genre</th>
                <th>year</th>
            </tr>

            <c:forEach items="${requestScope.movies}" var="c">
                <tr>
                    <td>${c.title}</td>
                    <td>${c.actor}</td>                    
                    <td>${c.actress}</td>                    
                    <td>${c.genre}</td>                    
                    <td>${c.year}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="/Movies/movie.do?name=home">Click here to go back to homepage</a>
    </body>
</html>
