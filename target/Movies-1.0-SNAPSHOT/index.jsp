<%-- 
    Document   : welcome
    Created on : Oct 19, 2021, 3:09:02 AM
    Author     : Jaeline
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Store</title>
    </head>
    <body>
        <h1>Welcome to our movie store!</h1>
        <h2>Please make your selection below</h2>
        <form method="post" action="/Movies/movie.do">
            <select name="selection">
                <option value="browse">Browse Movies
                <option value="add">Add New Movie to Database
            </select>
            <input type="submit" value="send">
        </form>
    </body>
</html>
