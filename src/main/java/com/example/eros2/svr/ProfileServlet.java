package com.example.eros2.svr;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.eros2.dao.LoginDao;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LogManager.getLogger(ProfileServlet.class);

    @Resource(name = "jdbc/eros")
    private DataSource ds;

    public ProfileServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Controlla se la sessione esiste e se contiene l'attributo 'user'.
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            log.warn("Tentativo di accesso senza sessione attiva.");
            response.sendRedirect("login.jsp"); // Reindirizza al login se non c'è sessione o utente loggato.
            return;
        }       
        // Recupera i dati dal form.
        Integer userId = (Integer) session.getAttribute("userID");
        String bio = request.getParameter("bio");
        // I valori booleani sono ottenuti direttamente dai parametri del form.
        boolean sport = "on".equals(request.getParameter("sport"));
        boolean viaggiare = "on".equals(request.getParameter("viaggiare"));
        boolean lettura = "on".equals(request.getParameter("lettura"));
        String fumatore = request.getParameter("fumatore");

        try (LoginDao dao = new LoginDao(ds)) {
            // Utilizza il metodo del DAO per inserire il profilo nel database.
            dao.insertProfile(userId, bio, sport, viaggiare, lettura, fumatore);
            log.info("Profilo inserito correttamente per l'utente ID: " + userId);
            response.sendRedirect("home.jsp"); // Reindirizza alla pagina di successo.
        } catch (Exception e) {
            log.error("Errore nell'inserimento dei dati del profilo.", e);
            request.setAttribute("errorMessage", "Errore nel salvataggio del profilo. Riprova.");
            request.getRequestDispatcher("account-form.jsp").forward(request, response);
        }
    }
}
