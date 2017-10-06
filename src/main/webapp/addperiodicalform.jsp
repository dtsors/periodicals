<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<c:set scope="request" var="title" value="Add periodical" />
<jsp:include page="header.jsp"/>
<h1><l:translate key="Add periodical"/></h1>
<form action="addperiodical.jsp" method="post">
    <table>
        <tr>
            <td><l:translate key="Name"/>:</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td><l:translate key="Description"/>:</td>
            <td><textarea name="description"></textarea></td>
        </tr>
        <tr>
            <td><l:translate key="IssuesPerMonth"/>:</td>
            <td><input type="number" name="issuesPerMonth"/></td>
        </tr>
        <tr>
            <td><l:translate key="Cost"/>:</td>
            <td><input type="number" name="cost" min="0" max="99999.99" step="0.01"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="<l:translate key="Submit"/>"/></td>
        </tr>
    </table>
</form>
<jsp:include page="footer.jsp"/>