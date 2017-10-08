<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<c:set scope="request" var="title" value="Registration"/>
<%@ include file="header.jsp" %>
<h1><l:translate key="Registration"/></h1>
<form action="/add/user" method="post">
    <table>
        <tr>
            <td><l:translate key="Login"/>:</td>
            <td><input type="text" name="login" value="test"/></td>
        </tr>
        <tr>
            <td><l:translate key="Password"/>:</td>
            <td><input type="password" name="password" value="test"/></td>
        </tr>
        <tr>
            <td><l:translate key="Email"/>:</td>
            <td><input type="email" name="email" value="test@test"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="<l:translate key="Submit"/>"/></td>
        </tr>
    </table>
</form>
<%@ include file="footer.html" %>