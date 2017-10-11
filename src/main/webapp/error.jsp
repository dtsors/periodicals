<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<c:set scope="request" var="title" value="Error"/>
<%@ include file="header.jsp" %>
<div class="text-center">
    <h1>Oops</h1>
    <a class="navbar-brand" href="index.jsp" title="<l:translate key="Main"/>"><img src="img/oops.png"></a>
</div>
<%@ include file="footer.jsp" %>