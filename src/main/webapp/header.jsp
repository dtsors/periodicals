<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><l:translate key="${title}"/></title>
    <link rel="stylesheet" href="/css/css.css">
</head>
<body>
<table border="1px" width="100%">
    <tr>
        <td>
            <a href="index.jsp"><l:translate key="Main"/></a>
        </td>
        <td>
            <a href="addperiodicalform.jsp"><l:translate key="Add periodical"/></a>
        </td>
        <td>
            <a href="viewusers.jsp"><l:translate key="Subscribers"/></a>
        </td>
        <td>
            <l:translate key="Login"/>
        </td>
        <td>
            <a href="adduserform.jsp"><l:translate key="Registration"/></a>
        </td>
        <td>
            <l:translate key="Language"/>:
            <a href="${pageContext.request.servletPath}?lang=en<c:if test="${!empty param.id}">&id=${param.id}</c:if>">en</a>
            <a href="${pageContext.request.servletPath}?lang=ru<c:if test="${!empty param.id}">&id=${param.id}</c:if>">ru</a>
        </td>
    </tr>
</table>
<table border="1px" width="100%">
    <tr>
        <td>
            <%
                String message = (String) request.getSession().getAttribute("status");
                if (message != null) {
                    if (Integer.parseInt(message) < 0) {
                        out.print("Error in data manipulating");
                    } else {
                        out.print("Row(s) affected: " + message);
                    }
                    request.getSession().setAttribute("status", null);
                }
            %>
        </td>
    </tr>
</table>
