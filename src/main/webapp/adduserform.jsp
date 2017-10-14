<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<c:set scope="request" var="title" value="Registration"/>
<%@ include file="header.jsp" %>
<div class="container">
    <form class="form-signin" action="add/user" method="post">
        <h1><l:translate key="Registration"/></h1>
        <div class="form-group">
            <label class="form-control-label"><l:translate key="Login"/></label>
            <input type="text" required="true" class="form-control" name="login" placeholder="<l:translate key="Login"/>">
        </div>
        <div class="form-group">
            <label><l:translate key="Email"/></label>
            <input type="email" required="true" class="form-control" name="email" aria-describedby="emailHelp" placeholder="<l:translate key="Email"/>">
        </div>
        <div class="form-group">
            <label><l:translate key="Password"/></label>
            <input type="password" required="true" class="form-control" name="password" placeholder="<l:translate key="Password"/>">
        </div>
        <button type="submit" class="btn btn-primary"><l:translate key="Submit"/></button>
    </form>
</div>
<%@ include file="footer.jsp" %>