<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<c:set scope="request" var="title" value="Add periodical" />
<%@ include file="header.jsp" %>
<div class="col-7">
    <h1><l:translate key="Add periodical"/></h1>
    <form action="add/periodical" method="post">
        <div class="form-group">
            <label class="form-control-label"><l:translate key="Name"/></label>
            <input type="text" required="true" class="form-control" name="name" placeholder="<l:translate key="Name"/>">
        </div>
        <div class="form-group">
            <label class="form-control-label"><l:translate key="Description"/></label>
            <textarea class="form-control" required="true" name="description" placeholder="<l:translate key="Description"/>"></textarea>
        </div>
        <div class="form-group">
            <label class="form-control-label"><l:translate key="IssuesPerMonth"/></label>
            <input type="number" required="true" min="1" max="31" step="1" class="form-control" name="issuesPerMonth" placeholder="<l:translate key="IssuesPerMonth"/>">
        </div>
        <div class="form-group">
            <label class="form-control-label"><l:translate key="Cost"/></label>
            <input type="number" required="true" min="0.1" max="99999.99" step="0.01" class="form-control" name="cost" placeholder="<l:translate key="Cost"/>">
        </div>
        <button type="submit" class="btn btn-primary"><l:translate key="Submit"/></button>
    </form>
</div>
<%@ include file="footer.jsp" %>