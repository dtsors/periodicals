<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<c:set scope="request" var="title" value="Recover password"/>
<%@ include file="header.jsp" %>
<div class="container">
    <form class="form-signin" action="recover" method="post">
        <h1><l:translate key="Recover password"/></h1>
        <div class="form-group">
            <input type="email" class="form-control" name="email" aria-describedby="emailHelp" placeholder="<l:translate key="Email"/>">
        </div>
        <button type="submit" class="btn btn-primary"><l:translate key="Submit"/></button>
    </form>
</div>
<%@ include file="footer.jsp" %>