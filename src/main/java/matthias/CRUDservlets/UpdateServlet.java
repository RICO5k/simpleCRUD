package matthias.CRUDservlets;

import matthias.beans.Person;
import matthias.dao.PersonDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", description = "update person record", urlPatterns = {"/updateServlet"} )

public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Person person = new Person();

        person.setFirstName(request.getParameter("firstName"));
        person.setLastName(request.getParameter("lastName"));
        person.setAge(Integer.parseInt(request.getParameter("age")));
        person.setSex(request.getParameter("sex"));
        person.setCountry(request.getParameter("country"));

        PersonDao.updatePerson(id, person);

        request.getRequestDispatcher("management").forward(request, response);

    }
}
