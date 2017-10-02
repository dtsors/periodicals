<%@ page import="periodicals.dao.DaoFactory" %>
<%@ page import="periodicals.dao.PeriodicalDao" %>
<%@ page import="periodicals.dao.PersistException" %>
<jsp:useBean id="p" class="periodicals.domain.Periodical"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>

<%
    DaoFactory daoFactory = (DaoFactory) application.getAttribute("periodicals.dao");
    PeriodicalDao periodicalDao = daoFactory.getPeriodicalDao();
    try {
        periodicalDao.save(p);
    } catch (PersistException e) {
        e.printStackTrace();
    }
    response.sendRedirect("index.jsp");
%>