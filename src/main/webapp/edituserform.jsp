<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.apache.log4j.Logger,periodicals.model.dao.DaoFactory" %>
<%@ page import="periodicals.model.dao.UserDao" %>
<%@ page import="periodicals.model.dao.exceptions.PersistException" %>
<%@ page import="static periodicals.Constants.APPLICATION_DAO" %>
<%@ page import="static periodicals.Constants.PARAM_ID" %>
<%
    String id = request.getParameter(PARAM_ID);
    DaoFactory daoFactory = (DaoFactory) application.getAttribute(APPLICATION_DAO);
    UserDao userDao = daoFactory.getUserDao();
    User u = null;
    try {
        u = userDao.getRecordById(Integer.parseInt(id));
    } catch (PersistException e) {
        Logger LOGGER = Logger.getLogger("editperiodicalform.jsp");
        LOGGER.error(e);
    }
%>
<c:set scope="request" var="title" value="Edit" />
<%@ include file="header.jsp" %>
<div class="container">
    <form class="form-signin" action="edit/user" method="post">
        <h1><l:translate key="Edit"/></h1>
        <input type="hidden" name="id" value="<%= u.getId()%>"/>
        <div class="form-group">
            <input type="text" class="form-control" name="login" placeholder="<l:translate key="Login"/>" value="<%= u.getLogin()%>">
        </div>
        <button type="submit" class="btn btn-primary"><l:translate key="Submit"/></button>
    </form>
</div>
<%@ include file="footer.jsp" %>