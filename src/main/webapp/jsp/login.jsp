<%=  request.getAttribute("error") == null ? "" : request.getAttribute("error") %>
<form action="login" method="post" class="text-center border shadow-lg rounded p-5">
    <div class="form-group">
        <label class="col-form-label col-form-label-lg">Username:</label>
        <input type="text" name="username" class="form-control form-control" value="<%= session.getAttribute("username") == null ? "" : session.getAttribute("username") %>">
    </div>
    <div class="form-group">
        <label class="col-form-label col-form-label-lg">Password:</label>
        <input type="password" name="password" class="form-control">
    </div>
    <button type="submit" class="btn">Submit</button>
</form>