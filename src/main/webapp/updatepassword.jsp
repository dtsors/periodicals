<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<c:set scope="request" var="title" value="Update password"/>
<%@ include file="header.jsp" %>
<div class="container">
    <form class="form-signin" action="renew" method="post">
        <input type="hidden" name="token" value="${param.token}"/>
        <h1><l:translate key="Update password"/></h1>
        <div class="form-group">
            <label><l:translate key="Password"/></label>
            <input type="password" class="form-control" name="password" placeholder="<l:translate key="Password"/>">
        </div>
        <button type="submit" class="btn btn-primary"><l:translate key="Submit"/></button>
    </form>
</div>
<%@ include file="footer.jsp" %>