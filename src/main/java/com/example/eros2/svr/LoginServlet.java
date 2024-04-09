package com.example.eros2.svr;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");

        try (LoginDao dao = new LoginDao(ds)) {
            Login user = dao.get(nickname, password);
            log.info(user);
        } catch (Exception e) {
            log.error("");
        }
        if (nickname.equals("Mario")) {
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.html").forward(request, response);
        }

    }

}