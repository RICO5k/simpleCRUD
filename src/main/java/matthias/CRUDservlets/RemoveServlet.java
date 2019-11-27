package matthias.CRUDservlets;

import matthias.dao.PersonDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveServlet", description = "remove person record", urlPatterns = {"/removeServlet"} )

public class RemoveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        PersonDao.removePerson(id);

        request.getRequestDispatcher("management").forward(request, response);
    }
}
