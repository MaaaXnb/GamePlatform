package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySQLtableCreator {
    public static void main(String[] args) {
        try {

            // Step 1 Connect to MySQL.
            System.out.println("Connecting to " + MySQLUtils.getMySQLAddress());
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(MySQLUtils.getMySQLAddress());

            if (conn == null) {
                return;
            }
            Statement statement = conn.createStatement();//帮助执行SQL语句 可重复使用
            // Step 2 Drop tables in case they exist.
            String sql = "DROP TABLE IF EXISTS message";
            statement.executeUpdate(sql);
            sql = "DROP TABLE IF EXISTS friend_list";
            statement.executeUpdate(sql);
            sql = "DROP TABLE IF EXISTS chat_box";
            statement.executeUpdate(sql);
            sql = "DROP TABLE IF EXISTS rooms";
            statement.executeUpdate(sql);
            sql = "DROP TABLE IF EXISTS users";
            statement.executeUpdate(sql);
            // Step 3 Create new tables.
            sql = "CREATE TABLE users ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "username VARCHAR(255) NOT NULL,"
                    + "password VARCHAR(255) NOT NULL,"
                    + "nick_name VARCHAR(255) NOT NULL"
                    + ")";
            statement.executeUpdate(sql);

            sql = "CREATE TABLE rooms ("
                    + "id INT AUTO_INCREMENT,"
                    + "password VARCHAR(255),"
                    + "maxPlayer INT NOT NULL,"
                    + "gameMode VARCHAR(255),"
                    + "host_id INT NOT NULL,"
                    + "FOREIGN KEY (host_id) REFERENCES users(id),"
                    + "PRIMARY KEY (id)"
                    + ")";
            statement.executeUpdate(sql);

            sql = "CREATE TABLE friend_list ("
                    + "userA_id INT NOT NULL,"
                    + "userB_id INT NOT NULL,"
                    + "PRIMARY KEY (userA_id, userB_id),"
                    + "FOREIGN KEY (userA_id) REFERENCES users(id),"
                    + "FOREIGN KEY (userA_id) REFERENCES users(id)"
                    + ")";
            statement.executeUpdate(sql);

            sql = "CREATE TABLE message ("
                    + "id INT AUTO_INCREMENT,"
                    + "user_id INT NOT NULL,"
                    + "content VARCHAR(255) NOT NULL,"
                    + "type VARCHAR(255) NOT NULL,"
                    + "set_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,"
                    + "PRIMARY KEY (id),"
                    + "FOREIGN KEY (user_id) REFERENCES users(id)"
                    + ")";
            statement.executeUpdate(sql);

            sql = "CREATE TABLE chat_box ("
                    + "room_id INT NOT NULL,"
                    + "message_id INT NOT NULL,"
                    + "PRIMARY KEY (room_id, message_id),"
                    + "FOREIGN KEY (message_id) REFERENCES message(id),"
                    + "FOREIGN KEY (room_id) REFERENCES rooms(id)"
                    + ")";
            statement.executeUpdate(sql);

            //variable char-> 长度255？ 第一位存长度+255=》 256
            // Step 4: insert fake user
            sql = "INSERT INTO users VALUES(null,'username', 'password', 'tester')";
            statement.executeUpdate(sql);
            conn.close();
            System.out.println("Import done successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}