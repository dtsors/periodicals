<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<c:set scope="request" var="title" value="Add periodical" />
<%@ include file="header.jsp" %>
<h1><l:translate key="Add periodical"/></h1>
<form action="/add/periodical" method="post">
    <table>
        <tr>
            <td><l:translate key="Name"/>:</td>
            <td><input type="text" name="name" value="test"/></td>
        </tr>
        <tr>
            <td><l:translate key="Description"/>:</td>
            <td><textarea name="description">test</textarea></td>
        </tr>
        <tr>
            <td><l:translate key="IssuesPerMonth"/>:</td>
            <td><input type="number" name="issuesPerMonth" value="1"/></td>
        </tr>
        <tr>
            <td><l:translate key="Cost"/>:</td>
            <td><input type="number" name="cost" min="0" max="99999.99" step="0.01" value="2"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="<l:translate key="Submit"/>"/></td>
        </tr>
    </table>
</form>
<%@ include file="footer.html" %>