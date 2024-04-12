package com.example.eros2.svr;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.eros2.dao.Login;
import com.example.eros2.dao.LoginDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LogManager.getLogger(LoginServlet.class);
   
    @Resource(name = "jdbc/eros")
    private DataSource ds;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        
        try (LoginDao dao = new LoginDao(ds)) {
            Login user = dao.get(userName, password);
            if (user != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);
                session.setAttribute("userID", user.getUserID());  // Assuming Login class has getUserID() method.
                response.sendRedirect("home.jsp");
            } else {
                request.setAttribute("loginError", "Invalid username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            log.error("Login error", e);
            request.setAttribute("loginError", "System error during login. Please try again.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

