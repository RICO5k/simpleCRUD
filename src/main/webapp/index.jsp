<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<%@include file="jsp/head.jsp"%>
<body>
    <div id="container" class="d-flex justify-content-center align-items-center">
        <% if( session.getAttribute("isLoggedIn") != null ) { %>
            <%@include file="jsp/management.jsp"%>
        <% } else { %>
            <%@include file="jsp/login.jsp"%>
        <% } %>
    </div>
</body>
</html>