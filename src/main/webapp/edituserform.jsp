<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="periodicals.model.entity.User,periodicals.model.dao.DaoFactory" %>
<%@ page import="periodicals.model.dao.UserDao" %>
<%@ page import="periodicals.model.dao.exceptions.PersistException" %>
<jsp:useBean id="user" class="periodicals.model.entity.User"></jsp:useBean>
<%
    String id = request.getParameter("id");
    DaoFactory daoFactory = (DaoFactory) application.getAttribute("periodicals.model");
    UserDao userDao = daoFactory.getUserDao();
    User u = null;
    try {
        u = userDao.getRecordById(Integer.parseInt(id));
    } catch (PersistException e) {
        e.printStackTrace();
    }
%>
<c:set scope="request" var="title" value="Edit" />
<%@ include file="header.jsp" %>
<h1><l:translate key="Edit"/></h1>
<form action="/edit/user" method="post">
    <input type="hidden" name="id" value="<%= u.getId()%>"/>
    <table>
        <tr>
            <td><l:translate key="Login"/>:</td>
            <td><input type="text" name="login" value="<%= u.getLogin()%>"/></td>
        </tr>
        <tr>
            <td><l:translate key="Password"/>:</td>
            <td><input type="password" name="password" value="<%= u.getPassword()%>"/></td>
        </tr>
        <tr>
            <td><l:translate key="Email"/>:</td>
            <td><input type="email" name="email" value="<%= u.getEmail()%>"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="<l:translate key="Submit"/>"/></td>
        </tr>
    </table>
</form>
<%@ include file="footer.html" %>