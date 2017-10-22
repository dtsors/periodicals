<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<%@ taglib prefix="lists" uri="/WEB-INF/periodicalTag" %>
<lists:getPeriodical/>
<c:set scope="request" var="title" value="Edit"/>
<%@ include file="header.jsp" %>
<div class="col-7">
    <h1><l:translate key="Edit"/></h1>
    <form action="edit/periodical" method="post">
        <input type="hidden" name="id" value="${periodicals_periodical.getId()}"/>
        <div class="form-group">
            <input type="text" class="form-control" name="name" placeholder="<l:translate key="Name"/>"
                   value="${periodicals_periodical.getName()}">
        </div>
        <div class="form-group">
            <textarea class="form-control" name="description"
                      placeholder="<l:translate key="Description"/>">${periodicals_periodical.getDescription()}</textarea>
        </div>
        <div class="form-group">
            <input type="number" min="1" max="31" step="1" class="form-control" name="issuesPerMonth"
                   placeholder="<l:translate key="IssuesPerMonth"/>"
                   value="${periodicals_periodical.getIssuesPerMonth()}">
        </div>
        <div class="form-group">
            <input type="number" min="0.1" max="99999.99" step="0.01" class="form-control" name="cost"
                   placeholder="<l:translate key="Cost"/>" value="${periodicals_periodical.getCost()}">
        </div>
        <button type="submit" class="btn btn-primary"><l:translate key="Submit"/></button>
    </form>
</div>
<%@ include file="footer.jsp" %>