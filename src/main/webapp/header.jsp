<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="l" uri="/WEB-INF/localizationTag" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><l:translate key="${title}"/></title>
    <link rel="stylesheet" href="css/css.css">
</head>
<body>
<table border="1px" width="100%">
    <tr>
        <td>
            <a href="index.jsp"><l:translate key="Main"/></a>
        </td>
        <td>
            <l:translate key="Language"/>:
            <a href="${pageContext.request.servletPath}?lang=en<c:if test="${!empty param.id}">&id=${param.id}</c:if>">en</a>
            <a href="${pageContext.request.servletPath}?lang=ru<c:if test="${!empty param.id}">&id=${param.id}</c:if>">ru</a>
        </td>
        <td>
            <l:translate key="Login"/>
        </td>
        <td>
            <a href="adduserform.jsp"><l:translate key="Registration"/></a>
        </td>
    </tr>
</table>