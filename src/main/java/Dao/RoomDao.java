package Dao;

import Model.Room;

import java.util.List;

public class RoomDao {
    //create a public room, given host id & max player number & gameMode
    public static boolean createPublicRoom(int hostID, int maxPlayer, String gameMode) throws MySQLException {
        return true;
    }

    //create a private room, given host id & password & max player number & gameMode
    public static boolean createPrivateRoom(int hostID, String password, int maxPlayer, String gameMode) throws MySQLException {
        return true;
    }

    //delete a room, given host id & room id
    public static boolean deleteRoom(int hostID, int roomID) throws MySQLException {
        return true;
    }

    //get a room, given room id
    public static Room getRoom(int roomID) throws MySQLException {
        return null;
    }

    //get all rooms
    public static List<Room> getAllRooms() throws MySQLException {
        return null;
    }

    //get all public rooms
    public static List<Room> getAllPublicRooms() throws MySQLException {
        return null;
    }

    //get all rooms with a required max player number
    public static List<Room> getAllRoomsByMaxPlayer() throws MySQLException {
        return null;
    }

    //get all rooms with a required gameMode
    public static List<Room> getAllRoomsByGameMode() throws MySQLException {
        return null;
    }

    //update room mode, given host id & room id & new game mode
    public static boolean updateRoomMode(int hostID, int roomID, String gameMode) throws MySQLException {
        return true;
    }

    //update max player, given host id & room id & new max player
    public static boolean updateMaxPlayer(int hostID, int roomID, int maxPlayer) throws MySQLException {
        return true;
    }

    //update password, given host id & room id & new password
    public static boolean updatePassword(int hostID, int roomID, String password) throws MySQLException {
        return true;
    }
}
