<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<%@ page import="periodicals.domain.Periodical,periodicals.model.dao.DaoFactory" %>
<%@ page import="periodicals.model.dao.PeriodicalDao" %>
<%@ page import="periodicals.model.dao.exceptions.PersistException" %>
<jsp:useBean id="periodical" class="periodicals.domain.Periodical"></jsp:useBean>
<%
    String id = request.getParameter("id");
    DaoFactory daoFactory = (DaoFactory) application.getAttribute("periodicals.model");
    PeriodicalDao periodicalDao = daoFactory.getPeriodicalDao();
    Periodical p = null;
    try {
        p = periodicalDao.getRecordById(Integer.parseInt(id));
    } catch (PersistException e) {
        e.printStackTrace();
    }
%>
<c:set scope="request" var="title" value="Edit" />
<jsp:include page="header.jsp"/>
<h1><l:translate key="Edit"/></h1>
<form action="editperiodical.jsp" method="post">
    <input type="hidden" name="id" value="<%= p.getId()%>"/>
    <table>
        <tr>
            <td><l:translate key="Name"/>:</td>
            <td><input type="text" name="name" value="<%= p.getName()%>"/></td>
        </tr>
        <tr>
            <td><l:translate key="Description"/>:</td>
            <td><textarea name="description"><%= p.getDescription()%></textarea></td>
        </tr>
        <tr>
            <td><l:translate key="IssuesPerMonth"/>:</td>
            <td><input type="number" name="issuesPerMonth" value="<%= p.getIssuesPerMonth()%>"/></td>
        </tr>
        <tr>
            <td><l:translate key="Cost"/>:</td>
            <td><input type="number" name="cost" min="0" max="99999.99" step="0.01" value="<%= p.getCost()%>"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="<l:translate key="Submit"/>"/></td>
        </tr>
    </table>
</form>
<jsp:include page="footer.jsp"/>