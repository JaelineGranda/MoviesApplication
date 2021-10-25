<%-- 
    Document   : newjsp
    Created on : Oct 19, 2021, 3:27:52 AM
    Author     : Jaeline
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Searching Movies</h1>
        <form method="post" action="/Movies/movie.do">
            Keyword: <input type="text" name="keyword">
            <input type="radio" name="search" value="title">Search by title
            <input type="radio" name="search" value="actor">Search by actor
            <input type="radio" name="search" value="actress">Search by actress
            <input type="submit" value="Search Movies">
            <input type="hidden" value="browsed" name="selection">
        </form>
    </body>
</html>
