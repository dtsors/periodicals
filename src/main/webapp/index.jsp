<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<%@ taglib prefix="lists" uri="/WEB-INF/periodicalTag" %>
<c:set scope="request" var="title" value="Periodicals"/>
<%@ include file="header.jsp" %>
<h1><l:translate key="Periodicals"/></h1>
<table border="1" width="100%">
    <tr>
        <th>Id</th>
        <th><l:translate key="Name"/></th>
        <th><l:translate key="Description"/></th>
        <th><l:translate key="IssuesPerMonth"/></th>
        <th><l:translate key="Cost"/></th>
        <th><l:translate key="Edit"/></th>
        <th><l:translate key="Delete"/></th>
    </tr>
    <lists:getPeriodicals/>
    <c:forEach items="${periodicalslist}" var="periodicals">
        <tr>
            <td>${periodicals.getId()}</td>
            <td>${periodicals.getName()}</td>
            <td>${periodicals.getDescription()}</td>
            <td>${periodicals.getIssuesPerMonth()}</td>
            <td>${periodicals.getCost()}</td>
            <td><a href="editperiodicalform.jsp?id=${periodicals.getId()}"><l:translate key="Edit"/></a></td>
            <td>
                <a href="delete/periodical?id=${periodicals.getId()}"
                   onclick='return confirm("<l:translate key="Confirm deletion"/>")'>
                    <l:translate key="Delete"/>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@ include file="footer.html" %>