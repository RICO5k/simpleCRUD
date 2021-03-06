<%@ page import="matthias.dao.PersonDao" %>
<%@ page import="matthias.beans.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<%
    String id = request.getParameter("id");
    Person person = null;

    if(id != null) {
        person = PersonDao.getPersonById( Integer.parseInt(id) );
    }
%>

<%@include file="head.jsp"%>
<body>
    <div id="container" class="flex-center">
        <form action="<%=person!=null ? "http://localhost:8080/CRUDLogin_war/updateServlet" : "http://localhost:8080/CRUDLogin_war/addServlet"%>" method="post" class="mdl-card  mdl-shadow--6dp" onsubmit="return validateForm()">
            <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
            <div class="mdl-card__title mdl-color--primary mdl-color-text--white">
                <h2 class="mdl-card__title-text">Add New User</h2>
            </div>
            <div class="mdl-card__supporting-text">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <label class="mdl-textfield__label" >First Name:</label>
                    <input type="text" name="firstName" class="mdl-textfield__input" value="<%=person!=null ? person.getFirstName() : ""%>">
                </div>
            </div>
            <div class="mdl-card__supporting-text">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <label class="mdl-textfield__label" >Last Name:</label>
                    <input type="text" name="lastName" class="mdl-textfield__input" value="<%=person!=null ? person.getLastName() : ""%>">
                </div>
            </div>
            <div class="mdl-card__supporting-text">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <label class="mdl-textfield__label" >Age:</label>
                    <input type="number" name="age" class="mdl-textfield__input" value="<%=person!=null ? person.getAge() : ""%>">
                </div>
            </div>
            <div class="mdl-card__supporting-text">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" >
                        <input type="radio" name="sex" value="M" class="mdl-radio__button" <%if(person!=null){%><%=person.getSex().equals("M") ? "CHECKED" : ""%><%}%>>
                        <span class = "mdl-radio__label">Man:</span>
                    </label>
                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" >
                        <input type="radio" name="sex" value="W" class="mdl-radio__button" <%if(person!=null){System.out.println(person.getSex());%><%=person.getSex().equals("W") ? "CHECKED" : ""%><%}%>>
                        <span class = "mdl-radio__label">Woman:</span>
                    </label>
                </div>
            </div>
            <div class="mdl-card__supporting-text">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <label class="mdl-textfield__label" >Country:</label>
                    <input type="text" name="country" class="mdl-textfield__input" value="<%=person!=null ? person.getCountry() : ""%>">
                </div>
            </div>
            <div class="mdl-card__actions mdl-card--border flex-center ">
                <button type="submit" class="mdl-button mdl-button--raised mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-color-text--white">Save</button>
            </div>
    </form>
    </div>
    <script>
        let validateForm = () => {
            let firstName = document.querySelector("input[name='firstName']").value;
            let lastName = document.querySelector("input[name='lastName']").value;
            let age = document.querySelector("input[name='age']").value;
            let country = document.querySelector("input[name='country']").value;

            if(firstName.trim() == "" ||
                lastName.trim() == "" ||
                age.trim() == "" ||
                country.trim() == "") {
                alert("fill all fields");
                return false;
            } else {
                return true;
            }
        }
    </script>
</body>
</html>