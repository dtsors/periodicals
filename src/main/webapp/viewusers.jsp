<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<%@ taglib prefix="lists" uri="/WEB-INF/periodicalTag" %>
<c:set scope="request" var="title" value="Subscribers"/>
<%@ include file="header.jsp" %>
<div class="col-7">
    <h1><l:translate key="Subscribers"/></h1>
    <table class="table table-hover">
        <thead class="table-dark">
        <tr class="bg-light text-primary">
            <th><l:translate key="Id"/></th>
            <th><l:translate key="Login"/></th>
            <th><l:translate key="Email"/></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <lists:getUsers/>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td scope="row">${user.getId()}</td>
                <td>${user.getLogin()}</td>
                <td><a href="mailto:${user.getEmail()}">${user.getEmail()}</a></td>
                <td>
                    <form action="edituserform.jsp" method="post">
                        <input type="hidden" name="id" value="${user.getId()}"/>
                        <button type="submit">
                            <image src="img/24/edit.png"/>
                        </button>
                    </form>
                </td>
                <td>
                    <form action="delete/user" method="post">
                        <input type="hidden" name="id" value="${user.getId()}"/>
                        <button type="submit" onclick='return confirm("<l:translate key="Confirm deletion"/>")'>
                            <image src="img/24/delete.png"/>
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@ include file="footer.jsp" %>