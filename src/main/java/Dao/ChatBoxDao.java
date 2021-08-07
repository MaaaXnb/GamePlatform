package Dao;

import Model.ChatBox;
import Model.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChatBoxDao {
    //get messages' id, given room's id
    public static List<Integer> getMessagesID(int roomID) throws MySQLException {
        Connection connection = MySQLUtils.getConnection();
        if (connection == null) {
            throw new MySQLException("Failed to connect to Database");
        }
        List<Integer> messagesID = new ArrayList<>();
        String sql = "SELECT * FROM chat_box WHERE room_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, roomID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int messageID = rs.getInt("message_id");
                messagesID.add(messageID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new MySQLException("Failed to get messages ids from Database");
        }
        return messagesID;
    }

    //get messages, given room's id
    public static List<Message> getMessages(int roomID) throws MySQLException {
        return null;
    }

    //delete all messages in room, given room's id
    public static boolean deleteMessages(int roomID) throws MySQLException {
        return true;
    }

    //connection a message with a room, given room id & message id
    public static boolean addToChatBox(int roomID, int messageID) throws MySQLException {
        return true;
    }
}
