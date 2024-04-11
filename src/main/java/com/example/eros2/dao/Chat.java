package com.example.eros2.dao;

import java.time.LocalDateTime;

public class Chat {
    private int chatID;
    private int senderUserID;
    private int receiverUserID;
    private String message;
    private LocalDateTime timestamp;

    public Chat() {
    }

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

    public int getSenderUserID() {
        return senderUserID;
    }

    public void setSenderUserID(int senderUserID) {
        this.senderUserID = senderUserID;
    }

    public int getReceiverUserID() {
        return receiverUserID;
    }

    public void setReceiverUserID(int receiverUserID) {
        this.receiverUserID = receiverUserID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Chat [chatID=" + chatID + ", senderUserID=" + senderUserID + ", receiverUserID=" + receiverUserID
                + ", message=" + message + ", timestamp=" + timestamp + "]";
    }

} 