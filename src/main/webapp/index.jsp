<%--<%@ page import="java.util.Enumeration" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<%@ taglib prefix="lists" uri="/WEB-INF/periodicalTag" %>
<%@ taglib prefix="pagination" uri="/WEB-INF/paginationTag" %>
<lists:getPeriodicalList/>
<c:set scope="request" var="title" value="Periodicals"/>
<%@ include file="header.jsp" %>
<div class="col-12">
    <h1><l:translate key="Periodicals"/></h1>
    <table class="table table-hover">
        <thead class="table-dark">
        <tr class="bg-light text-primary">
            <th><l:translate key="Id"/></th>
            <th><l:translate key="Name"/></th>
            <th><l:translate key="Description"/></th>
            <th><l:translate key="IssuesPerMonth"/></th>
            <th><l:translate key="Cost"/></th>
            <th></th>
            <th></th>
            <th><l:translate key="Count"/></th>
        </tr>
        </thead>
        <c:forEach items="${periodicals_periodicalList}" var="orders">
            <tr>
                <td scope="row">${orders.getId()}</td>
                <td>${orders.getName()}</td>
                <td>${orders.getDescription()}</td>
                <td>${orders.getIssuesPerMonth()}</td>
                <td>${orders.getCost()}</td>
                <td>
                    <form action="editperiodicalform.jsp" method="post">
                        <input type="hidden" name="id" value="${orders.getId()}"/>
                        <button type="submit">
                            <image src="img/24/edit.png"/>
                        </button>
                    </form>
                </td>
                <td>
                    <form action="delete/periodical" method="post">
                        <input type="hidden" name="id" value="${orders.getId()}"/>
                        <button type="submit" onclick='return confirm("<l:translate key="Confirm deletion"/>")'>
                            <image src="img/24/delete.png"/>
                        </button>
                    </form>
                </td>
                <td>
                    <form action="add/order" method="post">
                        <div class="form-row">
                            <input type="hidden" name="id" value="${orders.getId()}"/>
                            <div class="col">
                                <input type="number" class="form-control" min="1" max="9" step="1" name="count"
                                       value="1">
                            </div>
                            <div class="col">
                                <button type="submit">
                                    <image src="img/24/cart.png"/>
                                </button>
                            </div>
                        </div>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <pagination:pagination/>
</div>
<%--<%
    out.write("RequestAttributes");
    Enumeration<String> parameterNames = request.getAttributeNames();
    while (parameterNames.hasMoreElements()) {
        out.write(parameterNames.nextElement() + "<br>");
    }
    out.write("RequestAttributes<br><br>");

    out.write("SessionAttributes<br>");
    parameterNames = request.getSession().getAttributeNames();
    while (parameterNames.hasMoreElements()) {
        String s = parameterNames.nextElement();
        out.write(s + "<br>");
    }
    out.write("SessionAttributes<br><br>");

    out.write("AppAttributes<br>");
    parameterNames = request.getServletContext().getAttributeNames();
    while (parameterNames.hasMoreElements()) {
        String s = parameterNames.nextElement();
        out.write(s + "<br>");
    }
    out.write("AppAttributes<br>");
%>--%>
<div class="empty-space"></div>
<%@ include file="footer.jsp" %>