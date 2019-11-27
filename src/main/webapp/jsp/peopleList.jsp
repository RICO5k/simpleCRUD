<%@ page import="java.util.ArrayList" %>
<%@ page import="matthias.beans.Person" %>
<%@ page import="java.util.List" %>
<table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp fullwidth">
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th>Sex</th>
        <th>Country</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
        <% List<Person> people = (List<Person>)request.getAttribute("peopleList"); %>
        <%for(Person p : people) {%>
            <tr>
                <td><%=p.getFirstName()%></td>
                <td><%=p.getLastName()%></td>
                <td><%=p.getAge()%></td>
                <td><%=p.getSex()%></td>
                <td><%=p.getCountry()%></td>
                <td>
                    <a href="http://localhost:8080/CRUDLogin_war/management/update?id=<%=p.getId()%>">
                        <i class="material-icons">edit</i>
                    </a>
                </td>
                <td>
                    <a href="http://localhost:8080/CRUDLogin_war/management/remove?id=<%=p.getId()%>">
                        <i class="material-icons">delete</i>
                    </a>
                </td>
            </tr>
        <%}%>
    </tbody>
</table>