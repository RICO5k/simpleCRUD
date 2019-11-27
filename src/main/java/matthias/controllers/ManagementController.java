package matthias.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManagementController", description = "management controller", urlPatterns = {"/management/*"} )

public class ManagementController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean isLoggedIn = request.getSession().getAttribute("isLoggedIn") != null;

        if(!isLoggedIn) {
            response.sendRedirect(request.getContextPath()+"/login");
            return;
        }

        String path = "" + request.getPathInfo();

        switch(path) {
            case "/add": request.getRequestDispatcher("/jsp/personForm.jsp").forward(request, response); return;
            case "/remove": request.getRequestDispatcher("/removeServlet").forward(request, response); return;
            case "/update": request.getRequestDispatcher("/updateServlet").forward(request, response); return;
            case "/logout": request.getRequestDispatcher("/logoutServlet").forward(request, response); return;
        }

        request.getRequestDispatcher("/jsp/management.jsp").forward(request, response);

    }
}


