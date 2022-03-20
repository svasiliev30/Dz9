
 <%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
     <%@ page isELIgnored = "false" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page import="java.io.*,java.util.*,java.sql.*"%>
  <%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<html>
<head>

    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>Person</h1>
<form action="simpleRestControllerperson/postProcessing" method="POST">
    <label>Name-</label>
    <input type="text" name="name"><br />
    <label>Age-</label>
    <input type="number" name="age"><br />
    <label>Id-</label>
    <input type="number" name="id"><br />
    <label>City-</label>
    <input type="text" name="city"><br />
    <input type="submit"/>
</form>

</body>
</html>