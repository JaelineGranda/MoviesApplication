<%-- 
    Document   : entermovie
    Created on : Oct 19, 2021, 3:21:51 AM
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
        <h1>Please enter the details below</h1>
        <form method="post" action="/Movies/movie.do">
            Movie Title: <input type="text" name="title">
            Lead Actor: <input type="text" name="actor">
            Lead Actress: <input type="text" name="actress">
            Genre: <input type="text" name="genre">
            Year: <input type="text" name="year">
                <input type="hidden" value="added" name="selection">
            <input type="submit" value="Add Movie">
        </form>
    </body>
</html>
