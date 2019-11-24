package matthias.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", description = "login functionality", urlPatterns = {"/login"} )
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                String username = request.getParameter("username");
                String password = request.getParameter("password");

                HttpSession session = request.getSession();
                session.setAttribute("username", username);

                if(username.isEmpty() || password.isEmpty()) {
                    request.setAttribute("error", "<div class='alert alert-danger text-center'>Please fill all fields</div>");
                    getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    return;
        }

        session.setAttribute("isLoggedIn", "true");
        response.sendRedirect("CRUDManagement.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
}
