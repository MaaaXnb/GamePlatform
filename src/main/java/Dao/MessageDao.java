package Dao;

import Model.messageType;

public class MessageDao {
    //create a message in message table, given user id & content & type
    public static boolean createMessage(int userID, String content, messageType type) throws MySQLException {
        return true;
    }

    //delete a message, given message id
    public static boolean deleteMessage(int messageID) throws MySQLException {
        return true;
    }
}
