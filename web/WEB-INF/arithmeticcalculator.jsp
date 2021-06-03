<%-- 
    Document   : arithmeticcalculator
    Created on : Jun 2, 2021, 10:04:43 PM
    Author     : Main
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="post">
            First: <input type="text" name="first" value="${first}">
            <br>
            Second: <input type="text" name="second" value="${second}">
            <br>
            <input type="submit" name="plus" value="+">
            <input type="submit" name="minus" value="-">
            <input type="submit" name="multiply" value="x">
            <input type="submit" name="divide" value="/">
        </form>
        <br>
        Result: ${message}
        <br>
        <a href="/Lab3_Calculators/age">Age Calculator</a>
    </body>
</html>
