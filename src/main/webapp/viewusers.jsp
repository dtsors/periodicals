<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<%@ taglib prefix="lists" uri="/WEB-INF/periodicalTag" %>
<c:set scope="request" var="title" value="Subscribers"/>
<%@ include file="header.jsp" %>
<h1><l:translate key="Subscribers"/></h1>
<table border="1" width="100%">
    <tr>
        <th><l:translate key="Id"/></th>
        <th><l:translate key="Login"/></th>
        <th><l:translate key="Password"/></th>
        <th><l:translate key="Email"/></th>
        <th><l:translate key="Edit"/></th>
        <th><l:translate key="Delete"/></th>
    </tr>
    <lists:getUsers/>
    <c:forEach items="${userslist}" var="user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getLogin()}</td>
            <td>${user.getPassword()}</td>
            <td>${user.getEmail()}</td>
            <td><a href="edituserform.jsp?id=${user.getId()}"><l:translate key="Edit"/></a></td>
            <td>
                <a href="delete/user?id=${user.getId()}" onclick='return confirm("<l:translate key="Confirm deletion"/>")'>
                    <l:translate key="Delete"/>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@ include file="footer.html" %>