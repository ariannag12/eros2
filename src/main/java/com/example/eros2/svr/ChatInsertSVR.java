package com.example.eros2.svr;

import com.example.eros2.dao.ChatDao;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.io.IOException;


@WebServlet("/chat/insert")
public class ChatServlet extends HttpServlet { /**
     * 
     */
    private static final long serialVersionUID = 755015009380990069L;
    @Resource(name = "jdbc/eros")
    private DataSource ds;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the parameters of the sent message
        String message = request.getParameter("message");
        int senderUserID = Integer.parseInt(request.getParameter("senderUserID"));
        int receiverUserID = Integer.parseInt(request.getParameter("receiverUserID"));
        ChatDao chatDao = null;
        try {
            chatDao = new ChatDao(ds);
            chatDao.insertMessage(senderUserID, receiverUserID, message);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        } finally {
            if (chatDao != null) {
                try {
                    chatDao.close();
                } catch (SQLException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        }

//        // Getting the names of users
//        String senderUserName = userDao.getUserNameById(senderUserID);
//        String receiverUserName = userDao.getUserNameById(receiverUserID);
        // for select
//        // instance chat
//        Chat chat = new Chat();
//        chat.setMessage(message);
//        chat.setSenderUserID(senderUserID);
//        chat.setReceiverUserID(receiverUserID);
//        chat.setTimestamp(LocalDateTime.now());

//        // Add message using DAO 
//        try {
////            chatDao.insertMessage(chat);
////            //Send a JSON response to confirm success
////            response.setContentType("application/json");
////            response.setCharacterEncoding("UTF-8");
////            response.getWriter().write("{\"success\": true}");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Send a JSON response to report the error
//            response.setContentType("application/json");
//            response.setCharacterEncoding("UTF-8");
//            response.getWriter().write("{\"success\": false, \"error\": \"" + e.getMessage() + "\"}");
//        }
    }

}
