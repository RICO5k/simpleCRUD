<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<%@include file="head.jsp"%>
<body>
    <div id="container">
        <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
            <header class="mdl-layout__header">
                <div class="mdl-layout__header-row">
                    <span class="mdl-layout-title">People management</span>
                    <div class="mdl-layout-spacer"></div>
                    <nav class="mdl-navigation">
                        <a class="mdl-navigation__link" href="http://localhost:8080/CRUDLogin_war/management/add">Add Person</a>
                        <a class="mdl-navigation__link" href="http://localhost:8080/CRUDLogin_war/management/logout">Logout</a>
                    </nav>
                </div>
            </header>
            <main class="mdl-layout__content">
                <div class="page-content flex-center">
                    <%@include file="peopleList.jsp"%>
                </div>
            </main>
        </div>
    </div>
</body>
</html>
