package Model;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/


import java.util.*;

// line 7 "model.ump"
// line 55 "model.ump"
public class Room
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Room Attributes
  private String roomID;
  private int maxPlayer;
  private String gameMode;
  private boolean isPublic;
  private int passwordForRoom;
  private User host;

  //Room Associations
  private List<User> users;
  private List<User> hostUser;
  private GamePlatformSystem gamePlatformSystem;
  private ChatBox chatBox;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Room(String aRoomID, int aMaxPlayer, String aGameMode, boolean aIsPublic, int aPasswordForRoom, User aHost, GamePlatformSystem aGamePlatformSystem, ChatBox aChatBox)
  {
    roomID = aRoomID;
    maxPlayer = aMaxPlayer;
    gameMode = aGameMode;
    isPublic = aIsPublic;
    passwordForRoom = aPasswordForRoom;
    host = aHost;
    users = new ArrayList<User>();
    hostUser = new ArrayList<User>();
    boolean didAddGamePlatformSystem = setGamePlatformSystem(aGamePlatformSystem);
    if (!didAddGamePlatformSystem)
    {
      throw new RuntimeException("Unable to create room due to gamePlatformSystem. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aChatBox == null || aChatBox.getRoom() != null)
    {
      throw new RuntimeException("Unable to create Room due to aChatBox. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    chatBox = aChatBox;
  }

  public Room(String aRoomID, int aMaxPlayer, String aGameMode, boolean aIsPublic, int aPasswordForRoom, User aHost, GamePlatformSystem aGamePlatformSystem)
  {
    roomID = aRoomID;
    maxPlayer = aMaxPlayer;
    gameMode = aGameMode;
    isPublic = aIsPublic;
    passwordForRoom = aPasswordForRoom;
    host = aHost;
    users = new ArrayList<User>();
    hostUser = new ArrayList<User>();
    boolean didAddGamePlatformSystem = setGamePlatformSystem(aGamePlatformSystem);
    if (!didAddGamePlatformSystem)
    {
      throw new RuntimeException("Unable to create room due to gamePlatformSystem. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    chatBox = new ChatBox(this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRoomID(String aRoomID)
  {
    boolean wasSet = false;
    roomID = aRoomID;
    wasSet = true;
    return wasSet;
  }

  public boolean setMaxPlayer(int aMaxPlayer)
  {
    boolean wasSet = false;
    maxPlayer = aMaxPlayer;
    wasSet = true;
    return wasSet;
  }

  public boolean setGameMode(String aGameMode)
  {
    boolean wasSet = false;
    gameMode = aGameMode;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsPublic(boolean aIsPublic)
  {
    boolean wasSet = false;
    isPublic = aIsPublic;
    wasSet = true;
    return wasSet;
  }

  public boolean setPasswordForRoom(int aPasswordForRoom)
  {
    boolean wasSet = false;
    passwordForRoom = aPasswordForRoom;
    wasSet = true;
    return wasSet;
  }

  public boolean setHost(User aHost)
  {
    boolean wasSet = false;
    host = aHost;
    wasSet = true;
    return wasSet;
  }

  public String getRoomID()
  {
    return roomID;
  }

  public int getMaxPlayer()
  {
    return maxPlayer;
  }

  public String getGameMode()
  {
    return gameMode;
  }

  public boolean getIsPublic()
  {
    return isPublic;
  }

  public int getPasswordForRoom()
  {
    return passwordForRoom;
  }

  public User getHost()
  {
    return host;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isIsPublic()
  {
    return isPublic;
  }
  /* Code from template association_GetMany */
  public User getUser(int index)
  {
    User aUser = users.get(index);
    return aUser;
  }

  public List<User> getUsers()
  {
    List<User> newUsers = Collections.unmodifiableList(users);
    return newUsers;
  }

  public int numberOfUsers()
  {
    int number = users.size();
    return number;
  }

  public boolean hasUsers()
  {
    boolean has = users.size() > 0;
    return has;
  }

  public int indexOfUser(User aUser)
  {
    int index = users.indexOf(aUser);
    return index;
  }
  /* Code from template association_GetMany */
  public User getHostUser(int index)
  {
    User aHostUser = hostUser.get(index);
    return aHostUser;
  }

  public List<User> getHostUser()
  {
    List<User> newHostUser = Collections.unmodifiableList(hostUser);
    return newHostUser;
  }

  public int numberOfHostUser()
  {
    int number = hostUser.size();
    return number;
  }

  public boolean hasHostUser()
  {
    boolean has = hostUser.size() > 0;
    return has;
  }

  public int indexOfHostUser(User aHostUser)
  {
    int index = hostUser.indexOf(aHostUser);
    return index;
  }
  /* Code from template association_GetOne */
  public GamePlatformSystem getGamePlatformSystem()
  {
    return gamePlatformSystem;
  }
  /* Code from template association_GetOne */
  public ChatBox getChatBox()
  {
    return chatBox;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUsers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addUser(User aUser)
  {
    boolean wasAdded = false;
    if (users.contains(aUser)) { return false; }
    Room existingRoom = aUser.getRoom();
    if (existingRoom == null)
    {
      aUser.setRoom(this);
    }
    else if (!this.equals(existingRoom))
    {
      existingRoom.removeUser(aUser);
      addUser(aUser);
    }
    else
    {
      users.add(aUser);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUser(User aUser)
  {
    boolean wasRemoved = false;
    if (users.contains(aUser))
    {
      users.remove(aUser);
      aUser.setRoom(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUserAt(User aUser, int index)
  {  
    boolean wasAdded = false;
    if(addUser(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserAt(User aUser, int index)
  {
    boolean wasAdded = false;
    if(users.contains(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserAt(aUser, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfHostUser()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addHostUser(User aHostUser)
  {
    boolean wasAdded = false;
    if (hostUser.contains(aHostUser)) { return false; }
    Room existingHostRoom = aHostUser.getHostRoom();
    if (existingHostRoom == null)
    {
      aHostUser.setHostRoom(this);
    }
    else if (!this.equals(existingHostRoom))
    {
      existingHostRoom.removeHostUser(aHostUser);
      addHostUser(aHostUser);
    }
    else
    {
      hostUser.add(aHostUser);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeHostUser(User aHostUser)
  {
    boolean wasRemoved = false;
    if (hostUser.contains(aHostUser))
    {
      hostUser.remove(aHostUser);
      aHostUser.setHostRoom(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addHostUserAt(User aHostUser, int index)
  {  
    boolean wasAdded = false;
    if(addHostUser(aHostUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHostUser()) { index = numberOfHostUser() - 1; }
      hostUser.remove(aHostUser);
      hostUser.add(index, aHostUser);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveHostUserAt(User aHostUser, int index)
  {
    boolean wasAdded = false;
    if(hostUser.contains(aHostUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHostUser()) { index = numberOfHostUser() - 1; }
      hostUser.remove(aHostUser);
      hostUser.add(index, aHostUser);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addHostUserAt(aHostUser, index);
    }
    return wasAdded;
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
      existingGamePlatformSystem.removeRoom(this);
    }
    gamePlatformSystem.addRoom(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    while( !users.isEmpty() )
    {
      users.get(0).setRoom(null);
    }
    while( !hostUser.isEmpty() )
    {
      hostUser.get(0).setHostRoom(null);
    }
    GamePlatformSystem placeholderGamePlatformSystem = gamePlatformSystem;
    this.gamePlatformSystem = null;
    if(placeholderGamePlatformSystem != null)
    {
      placeholderGamePlatformSystem.removeRoom(this);
    }
    ChatBox existingChatBox = chatBox;
    chatBox = null;
    if (existingChatBox != null)
    {
      existingChatBox.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "roomID" + ":" + getRoomID()+ "," +
            "maxPlayer" + ":" + getMaxPlayer()+ "," +
            "gameMode" + ":" + getGameMode()+ "," +
            "isPublic" + ":" + getIsPublic()+ "," +
            "passwordForRoom" + ":" + getPasswordForRoom()+ "]" + java.lang.System.getProperties().getProperty("line.separator") +
            "  " + "host" + "=" + (getHost() != null ? !getHost().equals(this)  ? getHost().toString().replaceAll("  ","    ") : "this" : "null") + java.lang.System.getProperties().getProperty("line.separator") +
            "  " + "gamePlatformSystem = "+(getGamePlatformSystem()!=null?Integer.toHexString(java.lang.System.identityHashCode(getGamePlatformSystem())):"null") + java.lang.System.getProperties().getProperty("line.separator") +
            "  " + "chatBox = "+(getChatBox()!=null?Integer.toHexString(java.lang.System.identityHashCode(getChatBox())):"null");
  }
}