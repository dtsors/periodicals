<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lists" uri="/WEB-INF/periodicalTag" %>
<lists:getUser/>
<c:set scope="request" var="title" value="Edit"/>
<%@ include file="header.jsp" %>
<div class="container">
    <form class="form-signin" action="edit/user" method="post">
        <h1><l:translate key="Edit"/></h1>
        <input type="hidden" name="id" value="${periodicals_user.getId()}"/>
        <div class="form-group">
            <input type="text" class="form-control" name="login" placeholder="<l:translate key="Login"/>"
                   value="${periodicals_user.getLogin()}">
        </div>
        <button type="submit" class="btn btn-primary"><l:translate key="Submit"/></button>
    </form>
</div>
<%@ include file="footer.jsp" %>