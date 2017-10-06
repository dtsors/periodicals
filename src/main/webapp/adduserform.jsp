<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<c:set scope="request" var="title" value="Registration" />
<jsp:include page="header.jsp"/>
<h1><l:translate key="Registration"/></h1>
<form action="registration.jsp" method="post">
    <table>
        <tr>
            <td><l:translate key="Login"/>:</td>
            <td><input type="text" name="login"/></td>
        </tr>
        <tr>
            <td><l:translate key="Password"/>:</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td><l:translate key="Email"/>:</td>
            <td><input type="email" name="email"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="<l:translate key="Submit"/>"/></td>
        </tr>
    </table>
</form>
<jsp:include page="footer.jsp"/>