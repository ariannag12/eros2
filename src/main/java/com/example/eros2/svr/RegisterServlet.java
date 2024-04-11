package com.example.eros2.svr;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.eros2.dao.LoginDao;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private static final Logger log = LogManager.getLogger(RegisterServlet.class);
    
    @Resource(name = "jdbc/eros")
    private DataSource ds;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        Date birthDate = Date.valueOf(request.getParameter("birthDate"));
        
        try (LoginDao dao = new LoginDao(ds)) {
            boolean usernameExists = dao.userExists(userName);
            boolean emailExists = dao.emailExists(email);
            
            if (usernameExists || emailExists) {
                if (usernameExists) {
                    request.setAttribute("errorMessage", "Username already in use");
                }
                if (emailExists) {
                    request.setAttribute("errorMessage", "Email already in use");
                }
                request.getRequestDispatcher("createaccount.jsp").forward(request, response);
            } else {
                dao.registerUser(email, password, userName, firstName, lastName, gender, birthDate);
                log.info("User " + userName + " registered successfully.");
                response.sendRedirect("account-form.html");  // Use sendRedirect for changing page to avoid form resubmission issues
            }
        } catch (SQLException e) {
            log.error("Error during registration for user " + userName, e);
            request.setAttribute("errorMessage", "Registration error. Please try again.");
            request.getRequestDispatcher("createaccount.jsp").forward(request, response);
        } catch (Exception e) {
            log.error("Unexpected error", e);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}