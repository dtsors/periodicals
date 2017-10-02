<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Periodicals</title>
    <link rel="stylesheet" href="css/css.css">
</head>
<body>

<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="myTag" uri="myTagLib" %>

<h1>Periodicals</h1>
<a href="adduserform.jsp">Registration</a><br><br>
<table border="1" width="90%">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>IssuesPerMonth</th>
        <th>Cost</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <myTag:getPeriodicals/>
    <c:forEach items="${list}" var="p">
        <tr>
            <td>${p.getId()}</td>
            <td>${p.getName()}</td>
            <td>${p.getDescription()}</td>
            <td>${p.getIssuesPerMonth()}</td>
            <td>${p.getCost()}</td>
            <td><a href="editperiodicalform.jsp?id=${p.getId()}">Edit</a></td>
            <td><a href="deleteperiodical.jsp?id=${p.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/><a href="addperiodicalform.jsp">Add New Periodical</a>

</body>
</html>