package matthias.CRUDservlets;

import matthias.beans.Person;
import matthias.dao.PersonDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewServlet", description = "view records", urlPatterns = {"/viewServlet"} )

public class ViewServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Person> people = PersonDao.getAllPeople();
        request.setAttribute("peopleList", people);
        request.getRequestDispatcher("/jsp/management.jsp").forward(request, response);
    }
}
