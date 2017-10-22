<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<%@ page import="org.apache.log4j.Logger,periodicals.model.dao.DaoFactory" %>
<%@ page import="periodicals.model.dao.PeriodicalDao" %>
<%@ page import="periodicals.model.dao.exceptions.PersistException" %>
<%@ page import="static periodicals.Constants.APPLICATION_DAO" %>
<%@ page import="static periodicals.Constants.PARAM_ID" %>
<%@ page import="periodicals.model.entity.Periodical" %>
<%
    String id = request.getParameter(PARAM_ID);
    DaoFactory daoFactory = (DaoFactory) application.getAttribute(APPLICATION_DAO);
    PeriodicalDao periodicalDao = daoFactory.getPeriodicalDao();
    Periodical p = null;
    try {
        p = periodicalDao.getRecordById(Integer.parseInt(id));
    } catch (PersistException e) {
        Logger LOGGER = Logger.getLogger("editperiodicalform.jsp");
        LOGGER.error(e);
    }
%>
<c:set scope="request" var="title" value="Edit" />
<%@ include file="header.jsp" %>
<div class="col-7">
    <h1><l:translate key="Edit"/></h1>
    <form action="edit/periodical" method="post">
        <input type="hidden" name="id" value="<%= p.getId()%>"/>
        <div class="form-group">
            <input type="text" class="form-control" name="name" placeholder="<l:translate key="Name"/>" value="<%= p.getName()%>">
        </div>
        <div class="form-group">
            <textarea class="form-control" name="description" placeholder="<l:translate key="Description"/>"><%= p.getDescription()%></textarea>
        </div>
        <div class="form-group">
            <input type="number" min="1" max="31" step="1" class="form-control" name="issuesPerMonth" placeholder="<l:translate key="IssuesPerMonth"/>" value="<%= p.getIssuesPerMonth()%>">
        </div>
        <div class="form-group">
            <input type="number" min="0.1" max="99999.99" step="0.01" class="form-control" name="cost" placeholder="<l:translate key="Cost"/>" value="<%= p.getCost()%>">
        </div>
        <button type="submit" class="btn btn-primary"><l:translate key="Submit"/></button>
    </form>
</div>
<%@ include file="footer.jsp" %>