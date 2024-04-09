package com.example.eros2.svr;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

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
        String userName = request.getParameter("userName");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        Date birthDate = Date.valueOf(request.getParameter("birthDate"));
        
        try (LoginDao dao = new LoginDao(ds)) {
            //Check users is into database 
            if (dao.get(userName, password) != null) {
                log.warn("L'utente " + userName + " è già registrato.");
                //  Handle the case when the user is already registered
                //  Here you may redirect the user to an error page or display an appropriate message  
                request.getRequestDispatcher("").forward(request, response);
            } else {
                //register the user into database
                dao.registerUser(email, password, userName, firstName, lastName, gender, birthDate);
                log.info("L'utente " + userName + " è stato registrato con successo.");
                //Redirects the user to the login page after registration
                request.getRequestDispatcher("account-form.html").forward(request, response);
            }
        } catch (Exception e) {
            log.error("Errore durante la registrazione dell'utente " + userName, e);
            // Handle the error by displaying an appropriate error message  
            // For example: request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}