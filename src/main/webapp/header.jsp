<%@ page import="static periodicals.Constants.SESSION_COMMAND_RESULT" %>
<%@ page import="periodicals.controller.command.CommandResult" %>
<%@ page import="static periodicals.Constants.SESSION_IS_AUTHORIZED" %>
<%@ page import="periodicals.model.entity.User" %>
<%@ page import="static periodicals.Constants.SESSION_USER" %>
<%@ page import="periodicals.Role" %>
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
                <%
                    String authorized = (String) request.getSession().getAttribute(SESSION_IS_AUTHORIZED);
                    boolean admin;
                    if ((authorized != null) && ("true".contentEquals(authorized))) {
                        User user = (User) request.getSession().getAttribute(SESSION_USER);
                        admin = Role.ADMIN.toString().contentEquals(user.getRole());
                        if (admin) {
                            out.print("<li class='nav-item'><a class='nav-link text-light' href='addperiodicalform.jsp'>Add periodical</a></li>" +
                                    "<li class='nav-item'><a class='nav-link text-light' href='viewusers.jsp'>Subscribers</a></li>");
                        }
                    }
                %>
            </ul>
        </div>
        <div class="col">
            <ul class="navbar-nav mr-auto">
                <%
                    if ((authorized == null) || ("false".contentEquals(authorized))) {
                        out.print("<li class='nav-item'><a class='nav-link text-light' href='adduserform.jsp'>Registration</a></li>" +
                                "<li><a class='nav-link text-light' href='recoverpassword.jsp'>Recover</a></li>" +
                                "<li><a class='nav-link text-light' href='login.jsp'>SignIn</a></li>");
                    } else {
                        out.print("<li><a class='nav-link text-light' href='logout'>SignOut</a></li>");
                    }
                %>
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
    <%
    CommandResult result = (CommandResult) request.getSession().getAttribute(SESSION_COMMAND_RESULT);
    if ((result != null) && (!"".contentEquals(result.getType()))) {
            out.print("<div class='container'>\n" +
                    "    <div class='alert " + result.getType() + " alert-dismissible'>\n" +
                    "        <a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>\n" +
                    "        <strong>" + result.getMessage() + "</strong>\n" +
                    "    </div>\n" +
                    "</div>");
        request.getSession().setAttribute(SESSION_COMMAND_RESULT, null);
    }
%>
