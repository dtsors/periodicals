<%@ page import="periodicals.model.entity.Order" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="static periodicals.Constants.SESSION_ORDER" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<%@ taglib prefix="lists" uri="/WEB-INF/periodicalTag" %>
<c:set scope="request" var="title" value="Basket"/>
<%@ include file="header.jsp" %>
<h1><l:translate key="Basket"/></h1>
<%
    if (session.getAttribute(SESSION_ORDER) != null) {
        ArrayList<Order> orderList = (ArrayList<Order>) session.getAttribute(SESSION_ORDER);
        for (Order order : orderList) {
            out.print(order.toString() + "<br>");
        }
    }
%>
<%@ include file="footer.jsp" %>