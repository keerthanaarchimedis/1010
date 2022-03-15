<%-- 
    Document   : fetchdata
    Created on : 15-Mar-2022, 12:26:32 am
    Author     : 91805
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Database</title>
    </head>
    <body>
        <h1>Hello World!</h1><br><br>
        <form action="fetchAll" method="GET">
            
        <input type="submit" value="Click me to get all data"/>
        </form>
        <form action="fetchDB" method="POST">
            <input type="text" name="filter"/><br><br>
        <input type="submit" value="Click me to get filtered data"/>
        </form>
    </body>
</html>
