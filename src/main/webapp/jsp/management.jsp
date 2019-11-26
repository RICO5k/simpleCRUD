<div id="container">
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
        <header class="mdl-layout__header">
            <div class="mdl-layout__header-row">
                <span class="mdl-layout-title">People management</span>
                <div class="mdl-layout-spacer"></div>
                <nav class="mdl-navigation">
                    <a class="mdl-navigation__link" href="personForm.jsp">Add Person</a>
                    <a class="mdl-navigation__link" href="logout">Logout</a>
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