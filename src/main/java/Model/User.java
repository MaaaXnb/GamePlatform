package Model;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/


import java.util.*;

public class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String username;
  private String password;
  private String nickname;
  private List<User> friendList;

  //User Associations
  private GamePlatformSystem gamePlatformSystem;
  private Room room;
  private List<Message> messages;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aUsername, String aPassword, String aNickname, List<User> aFriendList, GamePlatformSystem aGamePlatformSystem)
  {
    username = aUsername;
    password = aPassword;
    nickname = aNickname;
    if (aFriendList == null) friendList = new ArrayList<>();
    else friendList = aFriendList;
    boolean didAddGamePlatformSystem = setGamePlatformSystem(aGamePlatformSystem);
    if (!didAddGamePlatformSystem)
    {
      throw new RuntimeException("Unable to create user due to gamePlatformSystem. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    messages = new ArrayList<Message>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUsername(String aUsername)
  {
    boolean wasSet = false;
    username = aUsername;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public boolean setNickname(String aNickname)
  {
    boolean wasSet = false;
    nickname = aNickname;
    wasSet = true;
    return wasSet;
  }

  public boolean setFriendList(List aFriendList)
  {
    boolean wasSet = false;
    friendList = aFriendList;
    wasSet = true;
    return wasSet;
  }

  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }

  public String getNickname()
  {
    return nickname;
  }

  public List getFriendList()
  {
    return friendList;
  }

  /* Code from template association_GetOne */
  public GamePlatformSystem getGamePlatformSystem()
  {
    return gamePlatformSystem;
  }
  /* Code from template association_GetOne */
  public Room getRoom()
  {
    return room;
  }

  public boolean hasRoom()
  {
    boolean has = room != null;
    return has;
  }

  /* Code from template association_GetMany */
  public Message getMessage(int index)
  {
    Message aMessage = messages.get(index);
    return aMessage;
  }

  public List<Message> getMessages()
  {
    List<Message> newMessages = Collections.unmodifiableList(messages);
    return newMessages;
  }

  public int numberOfMessages()
  {
    int number = messages.size();
    return number;
  }

  public boolean hasMessages()
  {
    boolean has = messages.size() > 0;
    return has;
  }

  public int indexOfMessage(Message aMessage)
  {
    int index = messages.indexOf(aMessage);
    return index;
  }
  /* Code from template association_SetOneToMany */
  public boolean setGamePlatformSystem(GamePlatformSystem aGamePlatformSystem)
  {
    boolean wasSet = false;
    if (aGamePlatformSystem == null)
    {
      return wasSet;
    }

    GamePlatformSystem existingGamePlatformSystem = gamePlatformSystem;
    gamePlatformSystem = aGamePlatformSystem;
    if (existingGamePlatformSystem != null && !existingGamePlatformSystem.equals(aGamePlatformSystem))
    {
      existingGamePlatformSystem.removeUser(this);
    }
    gamePlatformSystem.addUser(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setRoom(Room aRoom)
  {
    boolean wasSet = false;
    Room existingRoom = room;
    room = aRoom;
    if (existingRoom != null && !existingRoom.equals(aRoom))
    {
      existingRoom.removeUser(this);
    }
    if (aRoom != null)
    {
      aRoom.addUser(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfMessages()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addMessage(Message aMessage)
  {
    boolean wasAdded = false;
    if (messages.contains(aMessage)) { return false; }
    User existingUser = aMessage.getUser();
    if (existingUser == null)
    {
      aMessage.setUser(this);
    }
    else if (!this.equals(existingUser))
    {
      existingUser.removeMessage(aMessage);
      addMessage(aMessage);
    }
    else
    {
      messages.add(aMessage);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMessage(Message aMessage)
  {
    boolean wasRemoved = false;
    if (messages.contains(aMessage))
    {
      messages.remove(aMessage);
      aMessage.setUser(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public void delete()
  {
    GamePlatformSystem placeholderGamePlatformSystem = gamePlatformSystem;
    this.gamePlatformSystem = null;
    if(placeholderGamePlatformSystem != null)
    {
      placeholderGamePlatformSystem.removeUser(this);
    }
    if (room != null)
    {
      Room placeholderRoom = room;
      this.room = null;
      placeholderRoom.removeUser(this);
    }
    while (messages.size() > 0)
    {
      Message aMessage = messages.get(messages.size() - 1);
      aMessage.delete();
      messages.remove(aMessage);
    }
    
  }

}