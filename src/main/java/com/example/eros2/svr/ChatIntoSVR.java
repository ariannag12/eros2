package com.example.eros2.svr;


//// Getting the names of users
//String senderUserName = userDao.getUserNameById(senderUserID);
//String receiverUserName = userDao.getUserNameById(receiverUserID);
// for select
//// instance chat
//Chat chat = new Chat();
//chat.setMessage(message);
//chat.setSenderUserID(senderUserID);
//chat.setReceiverUserID(receiverUserID);
//chat.setTimestamp(LocalDateTime.now());

//// Add message using DAO 
//try {
////  chatDao.insertMessage(chat);
////  //Send a JSON response to confirm success
////  response.setContentType("application/json");
////  response.setCharacterEncoding("UTF-8");
////  response.getWriter().write("{\"success\": true}");
//} catch (SQLException e) {
//  e.printStackTrace();
//  // Send a JSON response to report the error
//  response.setContentType("application/json");
//  response.setCharacterEncoding("UTF-8");
//  response.getWriter().write("{\"success\": false, \"error\": \"" + e.getMessage() + "\"}");
//}