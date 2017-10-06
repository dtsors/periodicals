<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set scope="request" var="title" value="Error"/>
<jsp:include page="header.jsp"/>
<h1><l:translate key="Error"/></h1>
<jsp:include page="footer.jsp"/>
