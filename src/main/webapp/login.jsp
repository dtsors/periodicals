<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<c:set scope="request" var="title" value="SignIn"/>
<%@ include file="header.jsp" %>
<div class="container">
    <form class="form-signin" action="login" method="post">
        <h1><l:translate key="SignIn"/></h1>
        <div class="form-group">
            <input type="email" class="form-control" name="email" aria-describedby="emailHelp" placeholder="<l:translate key="Email"/>">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="<l:translate key="Password"/>">
        </div>
        <button type="submit" class="btn btn-primary"><l:translate key="Submit"/></button>
    </form>
</div>
<%@ include file="footer.jsp" %>