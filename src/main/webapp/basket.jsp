<%@ page import="periodicals.model.entity.Order" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="static periodicals.Constants.SESSION_ORDER" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<%@ taglib prefix="lists" uri="/WEB-INF/periodicalTag" %>
<c:set scope="request" var="title" value="Basket"/>
<%@ include file="header.jsp" %>
<%--<%
    if (session.getAttribute(SESSION_ORDER) != null) {
        ArrayList<Order> orderList = (ArrayList<Order>) session.getAttribute(SESSION_ORDER);
        for (Order order : orderList) {
            out.print(order.toString() + "<br>");
        }
    }
%>--%>
<div class="col-12">
    <h1><l:translate key="Basket"/></h1>
    <table class="table table-hover">
        <thead class="table-dark">
        <tr class="bg-light text-primary">
            <th><l:translate key="Id"/></th>
            <th><l:translate key="Count"/></th>
        </tr>
        </thead>
        <c:forEach items='${pageContext.session.getAttribute("periodicals.order")}' var="orders">
            <tr>
                <td scope="row">${orders.getPeriodicalId()}</td>
                <td>${orders.getCount()}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<div class="container">
    <form class="form-signin" action="add/payment" method="post">
        <input type="text" class="form-control" name="address" placeholder="<l:translate key="Address"/>">
        <button type="submit" class="btn btn-primary"><l:translate key="Pay"/></button>
    </form>
</div>
<%@ include file="footer.jsp" %>