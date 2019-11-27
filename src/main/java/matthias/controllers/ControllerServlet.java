package matthias.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ControllerServlet", description = "controller", urlPatterns = {"/login", "/"} )
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean isLoggedIn = request.getSession().getAttribute("isLoggedIn") != null;

        if(isLoggedIn) {
            response.sendRedirect("management");
        } else {
            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
        }

    }
}


