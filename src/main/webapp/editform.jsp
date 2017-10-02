<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Form</title>
    <link rel="stylesheet" href="css/css.css">
</head>
<body>
<%@page import="periodicals.dao.DaoFactory,periodicals.dao.PersistException" %>
<%@ page import="periodicals.dao.UserDao" %>
<%@ page import="periodicals.domain.User" %>

<%
    String id = request.getParameter("id");
    DaoFactory daoFactory = (DaoFactory) application.getAttribute("periodicals.dao");
    UserDao userDao = daoFactory.getUserDao();
    User u = null;
    try {
        u = userDao.getRecordById(Integer.parseInt(id));
    } catch (PersistException e) {
        e.printStackTrace();
    }
%>

<h1>Edit Form</h1>
<form action="edituser.jsp" method="post">
    <input type="hidden" name="id" value="<%= u.getId()%>"/>
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="login" value="<%= u.getLogin()%>"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" value="<%= u.getPassword()%>"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="email" value="<%= u.getEmail()%>"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Edit User"/></td>
        </tr>
    </table>
</form>

</body>
</html>