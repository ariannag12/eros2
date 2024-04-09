/*
 * Java / RDBMS integration by JDBC
 * 
 * https://github.com/egalli64/jd
 */
package com.example.eros2.dao;

import java.sql.Connection;
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
//    private static final String INSERT = """
//            INSERT INTO users (userID, email, password, username, firstName, lastName, gender, birthDate) VALUES
//                (?, ?, ?, ?, ?, ?, ?, ?)""";
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

	@Override
	public void close() throws Exception {
		try {
			conn.close();
		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		}
	}
}