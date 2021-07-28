package Model;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

import static Model.messageType.Text;

public class testModel {
    public static void main(String[] args) {
        GamePlatformSystem system = new GamePlatformSystem();
        User host = new User("username", "password", "Max", null, system);
        User userA = new User("usernameA", "passwordA", "A", null, system);
        User userB = new User("usernameB", "passwordB", "B", null, system);
        Room created = new Room(10, "chat", true, 1234,host, system);
        userA.setRoom(created);
        userB.setRoom(created);
        userA.addMessage(new Message(java.sql.Time.valueOf(LocalTime.now()),"HELLOHost",Text, created.getChatBox()));
        userB.addMessage(new Message(java.sql.Time.valueOf(LocalTime.now()),"HELLOA",Text, created.getChatBox()));
        host.addMessage(new Message(java.sql.Time.valueOf(LocalTime.now()),"HELLOB",Text, created.getChatBox()));
        System.out.println(created.getChatBox().getMessages());
    }
}
