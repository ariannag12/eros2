/*
 * Java / RDBMS integration by JDBC
 * 
 * https://github.com/egalli64/jd
 */
package com.example.eros2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginDao implements AutoCloseable {
    private static final Logger log = LogManager.getLogger(LoginDao.class);

    private static final String LOGIN = """
            SELECT userName, firstName, lastName
            FROM users
            WHERE userName = ? and password = ?""";

    private static final String INSERT_USERS = """
            INSERT INTO users (email, password, userName, firstName, lastName, gender, birthdate) VALUES
                (?, ?, ?, ?, ?, ?, ?)""";
    
    private static final String INSERT_PROFILE = """
                INSERT INTO UserProfile (UserID, Bio, Sport, Viaggiare, Lettura, Fumatore) 
                VALUES (?, ?, ?, ?, ?, ?)""";

    private static final String UPDATE_PROFILE = """
            UPDATE UserProfile SET Sport = ?, Viaggiare = ?, Lettura = ?, Fumatore = ? 
            WHERE UserProfileID = ?""";
    private Connection conn;

    public LoginDao(DataSource ds) {
        try {
            this.conn = ds.getConnection(); // Stabilisce la connessione con il database
            log.trace("Connessione al database stabilita.");
        } catch (SQLException ex) {
            log.error("Impossibile stabilire la connessione con il database.", ex);
            throw new IllegalStateException("Impossibile stabilire la connessione con il database.", ex);
        }
    }

    public Login get(String userName, String password) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(LOGIN)) {
            ps.setString(1, userName);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Login(rs.getString("userName"), rs.getString("firstName"), rs.getString("lastName"));
                }
            }
        } catch (SQLException se) {
            log.error("Errore durante il recupero dell'utente " + userName, se);
            throw se;
        }
        return null;
    }

    public boolean userExists(String userName) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE userName = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, userName);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public boolean emailExists(String email) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE email = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public Login registerUser(String email, String password, String userName, String firstName, String lastName,
            String gender, Date birthdate) throws SQLException {
        if (userExists(userName) || emailExists(email)) {
            throw new SQLException("Nickname o email già in uso");
        }

        try (PreparedStatement ps = conn.prepareStatement(INSERT_USERS)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, userName);
            ps.setString(4, firstName);
            ps.setString(5, lastName);
            ps.setString(6, gender);
            ps.setDate(7, birthdate);
            ps.executeUpdate();
            log.info("Utente registrato con successo: " + userName);
        }
        return null; // Adjust based on your method's return needs
    }

    public Login insertProfile(int userID, String bio, boolean sport, boolean viaggiare, boolean lettura, String fumatore)
            throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_PROFILE)) {
            ps.setInt(1, userID);
            ps.setString(2, bio);
            ps.setBoolean(3, sport);
            ps.setBoolean(4, viaggiare);
            ps.setBoolean(5, lettura);
            ps.setString(6, fumatore);
            ps.executeUpdate();
            log.info("Profilo inserito con successo.");
        } catch (SQLException se) {
            log.error("Errore nell'inserimento del profilo", se);
            throw se;  // Rilancia l'eccezione per gestione esterna
        }
        return null;
    }

    public Login updateProfile(int userProfileID, boolean sport, boolean viaggiare, boolean lettura, String fumatore) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_PROFILE)) {
            ps.setBoolean(1, sport);
            ps.setBoolean(2, viaggiare);
            ps.setBoolean(3, lettura);
            ps.setString(4, fumatore);
            ps.setInt(5, userProfileID);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                log.info("Profilo aggiornato con successo.");
            } else {
                log.warn("Nessun profilo trovato con ID: " + userProfileID);
            }
        } catch (SQLException se) {
            log.error("Errore nell'aggiornamento del profilo", se);
            throw se;
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        if (conn != null) {
            try {
                conn.close();
                log.trace("Connessione al database chiusa.");
            } catch (SQLException ex) {
                log.error("Errore nella chiusura della connessione al database.", ex);
                throw new IllegalStateException("Errore nella chiusura della connessione al database.", ex);
            }
        }
    }
}
