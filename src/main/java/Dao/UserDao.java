package Dao;

import Model.Room;
import Model.User;

import java.util.List;

public class UserDao {
    //get all users
    public static List<User> getAllUsers() throws MySQLException {
        return null;
    }

    //get all friends's id, given userID
    public static List<Integer> getAllFriendsID(int userID) throws MySQLException {
        return null;
    }

    //get all users with certain ids, given userID list
    public static List<Integer> getAllFriends(List<Integer> userIDs) throws MySQLException {
        return null;
    }

    //get user by username, given username
    public static List<Integer> getUserByUsername(String username) throws MySQLException {
        return null;
    }

    //delete user
    public static List<User> deleteUser(int userID) throws MySQLException {
        return null;
    }
}
