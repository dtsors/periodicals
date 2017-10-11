<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<%@ taglib prefix="lists" uri="/WEB-INF/periodicalTag" %>
<c:set scope="request" var="title" value="Periodicals"/>
<%@ include file="header.jsp" %>
<div class="col-12">
    <h1><l:translate key="Periodicals"/></h1>
    <table class="table table-hover">
        <thead class="table-dark">
        <tr class="bg-light text-primary">
            <th><l:translate key="Id"/></th>
            <th><l:translate key="Name"/></th>
            <th><l:translate key="Description"/></th>
            <th><l:translate key="IssuesPerMonth"/></th>
            <th><l:translate key="Cost"/></th>
            <th></th>
            <th></th>
            <th><l:translate key="Count"/></th>
        </tr>
        </thead>
        <lists:getPeriodicals/>
        <c:forEach items="${periodicalList}" var="orders">
            <tr>
                <td scope="row">${orders.getId()}</td>
                <td>${orders.getName()}</td>
                <td>${orders.getDescription()}</td>
                <td>${orders.getIssuesPerMonth()}</td>
                <td>${orders.getCost()}</td>
                <td>
                    <form action="editperiodicalform.jsp" method="post">
                        <input type="hidden" name="id" value="${orders.getId()}"/>
                        <button type="submit">
                            <image src="img/24/edit.png"/>
                        </button>
                    </form>
                </td>
                <td>
                    <form action="delete/periodical" method="post">
                        <input type="hidden" name="id" value="${orders.getId()}"/>
                        <button type="submit" onclick='return confirm("<l:translate key="Confirm deletion"/>")'>
                            <image src="img/24/delete.png"/>
                        </button>
                    </form>
                </td>
                <td>
                    <form action="add/order" method="post">
                        <div class="form-row">
                            <input type="hidden" name="id" value="${orders.getId()}"/>
                            <div class="col">
                                <input type="number" class="form-control" min="1" max="9" step="1"  name="count"
                                       value="1">
                            </div>
                            <div class="col">
                                <button type="submit">
                                    <image src="img/24/cart.png"/>
                                </button>
                            </div>
                        </div>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@ include file="footer.jsp" %>