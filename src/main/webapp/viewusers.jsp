<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Users</title>
    <link rel="stylesheet" href="css/css.css">
</head>
<body>

<%@page import="periodicals.dao.DaoFactory,periodicals.dao.PersistException" isELIgnored="false" %>
<%@ page import="periodicals.dao.UserDao" %>
<%@ page import="periodicals.domain.User" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Users List</h1>

<%
    DaoFactory daoFactory = (DaoFactory) application.getAttribute("periodicals.dao");
    UserDao userDao = daoFactory.getUserDao();
    List<User> list = null;
    try {
        list = userDao.getAllRecords();
    } catch (PersistException e) {
        e.printStackTrace();
    }
    request.setAttribute("list", list);
%>

<table border="1" width="90%">
    <tr>
        <th>Id</th>
        <th>Login</th>
        <th>Password</th>
        <th>Email</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.getId()}</td>
            <td>${u.getLogin()}</td>
            <td>${u.getPassword()}</td>
            <td>${u.getEmail()}</td>
            <td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>
            <td><a href="deleteuser.jsp?id=${u.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/><a href="adduserform.jsp">Add New User</a>

</body>
</html>