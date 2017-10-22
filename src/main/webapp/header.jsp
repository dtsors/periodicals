<%@ taglib prefix="security" uri="/WEB-INF/securityTag" %>
<%@ taglib prefix="alert" uri="/WEB-INF/alertTag" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><l:translate key="${title}"/></title>
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="dock-to-top">
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="index.jsp" title="<l:translate key="Main"/>"><img src="img/logo.png"></a>
        <div class="col">
            <ul class="navbar-nav mr-auto">
                <security:ifAdmin>
                    <li class='nav-item'><a class='nav-link text-light' href='addperiodicalform.jsp'>Add periodical</a>
                    </li>
                    <li class='nav-item'><a class='nav-link text-light' href='viewusers.jsp'>Subscribers</a></li>
                </security:ifAdmin>
            </ul>
        </div>
        <div class="col">
            <ul class="navbar-nav mr-auto">
                <security:ifAuthorized/>
            </ul>
        </div>
        <div class="col">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link text-light"
                       href="${pageContext.request.servletPath}?lang=en<c:if test="${!empty param.id}">&id=${param.id}</c:if>">
                        En</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-light"
                       href="${pageContext.request.servletPath}?lang=ru<c:if test="${!empty param.id}">&id=${param.id}</c:if>">
                        Ru</a>
                </li>
            </ul>
        </div>
        <a class="navbar-brand" href="basket.jsp" title="<l:translate key="Basket"/>"><img src="img/cart.png"></a>
    </nav>
</div>
<div class="empty-space"></div>
<alert:alertTag/>