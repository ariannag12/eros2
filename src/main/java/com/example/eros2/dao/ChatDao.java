package com.example.eros2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ChatDao {
    private Connection connection;

    public ChatDao(DataSource ds) throws SQLException {
        this.connection = ds.getConnection();
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public void insertMessage(int senderId, int receiverId, String message) throws SQLException {
        String query = "INSERT INTO Chat (SenderUserID, ReceiverUserID, Message) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, senderId);
            statement.setInt(2, receiverId);
            statement.setString(3, message);
            statement.executeUpdate();
        }
    }

    public List<Chat> getUserConversations(int userID) throws SQLException {
        List<Chat> conversations = new ArrayList<>();
        String query = "SELECT * FROM Chat WHERE SenderUserID = ? OR ReceiverUserID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userID);
            statement.setInt(2, userID);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Chat chat = new Chat();
                    chat.setChatID(resultSet.getInt("ChatID"));
                    chat.setSenderUserID(resultSet.getInt("SenderUserID"));
                    chat.setReceiverUserID(resultSet.getInt("ReceiverUserID"));
                    chat.setMessage(resultSet.getString("Message"));
                    chat.setTimestamp(resultSet.getTimestamp("Timestamp").toLocalDateTime());
                    conversations.add(chat);
                }
            }
        }
        return conversations;
    }
}
