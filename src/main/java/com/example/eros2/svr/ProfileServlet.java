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
		log.traceEntry();
		String userName = request.getParameter("userName");
		String sport = request.getParameter("sport");
		String viaggiare = request.getParameter("viaggiare");
		String lettura = request.getParameter("lettura");
		String fumatore = request.getParameter("fumatore");
//		boolean existingProfile = checkExistingProfile(userName);
	}

}
