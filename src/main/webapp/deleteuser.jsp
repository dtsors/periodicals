<%@page import="periodicals.dao.DaoFactory" %>
<%@ page import="periodicals.dao.UserDao" %>
<%@ page import="periodicals.dao.PersistException" %>
<jsp:useBean id="u" class="periodicals.domain.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
    DaoFactory daoFactory = (DaoFactory) application.getAttribute("periodicals.dao");
    UserDao userDao = daoFactory.getUserDao();
    try {
        userDao.delete(u);
    } catch (PersistException e) {
        e.printStackTrace();
    }
    response.sendRedirect("viewusers.jsp");
%>