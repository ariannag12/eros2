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
            INSERT INTO UserProfile (sport, viaggiare, lettura, fumatore) VALUES
                (?, ?, ?, ?)""";
    private static final String UPDATE_PROFILE = """
            UPDATE UserProfile
            SET sport = ?, viaggiare = ?, lettura = ?, fumatore = ?
            WHERE UserProfileID = ? """;
    private Connection conn;

    public LoginDao(DataSource ds) {
        log.traceEntry();

        try {
            this.conn = ds.getConnection();
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
    }

    public Login get(String userName, String password) {
        try (PreparedStatement ps = conn.prepareStatement(LOGIN)) {
            ps.setString(1, userName);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Login(rs.getString(1), rs.getString(2), rs.getString(3));
                }
            }
        } catch (SQLException se) {
            log.error("Can't get user " + userName, se);
        }

        return null;
    }

    public Login registerUser(String email, String password, String userName, String firstName, String lastName,
            String gender, Date birthdate) {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_USERS)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, userName);
            ps.setString(4, firstName);
            ps.setString(5, lastName);
            ps.setString(6, gender);
            ps.setDate(7, birthdate);
            ps.executeUpdate();
            log.info("User" + userName + "registered successfully.");
        } catch (SQLException se) {
            log.error("Error registering user " + userName, se);
        }

        return null;
    }

    public Login insertProfile(String sport, String viaggiare, String lettura, String fumatore) {
        try (PreparedStatement ps = conn.prepareStatement(INSERT_PROFILE)) {
            ps.setString(1, sport);
            ps.setString(2, viaggiare);
            ps.setString(3, lettura);
            ps.setString(4, fumatore);
        } catch (SQLException se) {
            log.error("Existing Profile");
        }
        return null;
    }

    public Login updateProfile(String sport, String viaggiare, String lettura, String fumatore, int userProfileID) {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE_PROFILE)) {
            ps.setString(1, sport);
            ps.setString(2, viaggiare);
            ps.setString(3, lettura);
            ps.setString(4, fumatore);
            ps.setInt(5, userProfileID);
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                log.info("Profile updated successfully for " + userProfileID);
            } else {
                log.warn("No profile found for " + userProfileID);
            }
        } catch (SQLException se) {
            log.error("Data not updated", se);
        }

        return null;
    }

    @Override
    public void close() throws Exception {
        try {
            conn.close();
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
