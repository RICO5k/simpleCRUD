<%=  request.getAttribute("error") == null ? "" : request.getAttribute("error") %>
<div id="container" class="flex-center">
    <form action="login" method="post" class="mdl-card  mdl-shadow--6dp">
        <div class="mdl-card__title mdl-color--primary mdl-color-text--white">
            <h2 class="mdl-card__title-text">Sign In</h2>
        </div>
        <div class="mdl-card__supporting-text">
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <label class="mdl-textfield__label" >Username:</label>
                <input type="text" name="username" class="mdl-textfield__input" value="<%= session.getAttribute("username") == null ? "" : session.getAttribute("username") %>">
            </div>
        </div>
        <div class="mdl-card__supporting-text">
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <label class="mdl-textfield__label" >Password:</label>
                <input type="password" name="password" class="mdl-textfield__input">
            </div>
        </div>
        <div class="mdl-card__actions mdl-card--border flex-center ">
            <button type="submit" class="mdl-button mdl-button--raised mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-color-text--white">Submit</button>
        </div>
    </form>
</div>